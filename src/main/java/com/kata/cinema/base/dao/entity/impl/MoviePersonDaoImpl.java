package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.MoviePersonDao;
import com.kata.cinema.base.models.entitys.MoviePerson;
import com.kata.cinema.base.models.enums.TypeCharacter;
import org.hibernate.transform.ResultTransformer;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MoviePersonDaoImpl extends AbstractDaoImpl<Long, MoviePerson> implements MoviePersonDao {
    //TODO переписать на трансформер
    public Map<Long, List<String>> getTwoMoviePersonMap() {
        List<Object[]> rows = entityManager.createQuery("select m.id, mp.nameCharacter from MoviePerson mp left join mp.movie m" +
                        " where mp.type = :type")
                .setParameter("type", TypeCharacter.MAIN_CHARACTER)
                .getResultList();
        Map<Long, List<String>> moviePersonMap = new HashMap<>();
        for (Object[] row : rows) {
            Long key = (Long) row[0];
            String value = (String) row[1];
            moviePersonMap.computeIfAbsent(key, k -> new ArrayList<>());
            if (moviePersonMap.get(key).size() < 2) {
                moviePersonMap.get(key).add(value);
            }
        }
        return moviePersonMap;
    }

    @Override
    public Map<Long, List<String>> getAllMainCharacterOfMoviesMap() {
        Map<Long, List<String>> map = new HashMap<>();
        entityManager.createQuery("select m.id, mp.nameCharacter from MoviePerson" +
                        " mp left join mp.movie m where mp.type =:type")
                .setParameter("type", TypeCharacter.MAIN_CHARACTER)
                .unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(getResultTransformer(map))
                .getResultList();
        return map;
    }

    @Override
    public Map<Long, List<String>> getMovieDirectorMap() {
        Map<Long, List<String>> map = new HashMap<>();
        entityManager.createQuery("select m.id, concat(p.firstName, ' ', p.lastName) from MoviePerson mp " +
                        "join mp.movie m join mp.professions pr join mp.person p where pr.name = 'режиссер'")
                .unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(getResultTransformer(map))
                .getResultList();
        return map;
    }

    private ResultTransformer getResultTransformer(Map<Long, List<String>> map) {
        return new ResultTransformer() {
            @Override
            public Object transformTuple(Object[] tuple, String[] aliases) {
                Long id = (Long) tuple[0];
                if (!map.containsKey(id)) {
                    map.put(id, new ArrayList<>());
                }
                map.get(id).add((String) tuple[1]);
                return tuple;
            }

            @Override
            public List transformList(List list) {
                return list;
            }
        };
    }
}
