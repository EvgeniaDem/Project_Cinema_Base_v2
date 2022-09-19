package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.GenresDao;
import com.kata.cinema.base.models.dto.response.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genre;
import org.hibernate.transform.ResultTransformer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GenresDaoImpl extends AbstractDaoImpl<Long, Genre> implements GenresDao {
    @Override
    public Map<Long, List<String>> getAllMap() {
        Map<Long, List<String>> genresMap = new HashMap<>();
        entityManager.createQuery("select m.id, g.name from Genre g left join g.movie m")
                .unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(new ResultTransformer() {
                    @Override
                    public Object transformTuple(Object[] tuple, String[] aliases) {
                        Long id = (Long) tuple[0];
                        if (!genresMap.containsKey(id)) {
                            genresMap.put(id, new ArrayList<>());
                        }
                        genresMap.get(id).add((String) tuple[1]);
                        return tuple;
                    }

                    @Override
                    public List transformList(List list) {
                        return list;
                    }
                }).getResultList();
        return genresMap;
    }

    @Override
    public List<GenreResponseDto> getListOfGenres() {
        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.response.GenreResponseDto(g.id, g.name)" +
                        " from Genre g", GenreResponseDto.class)
                .getResultList();
    }
}
