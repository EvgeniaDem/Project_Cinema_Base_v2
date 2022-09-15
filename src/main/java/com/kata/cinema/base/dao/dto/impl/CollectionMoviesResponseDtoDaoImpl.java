package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.CollectionMoviesResponseDtoDao;
import com.kata.cinema.base.dao.dto.MovieResponseDtoDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionMoviesResponseDtoDaoImpl implements CollectionMoviesResponseDtoDao {

    @Autowired
    MovieResponseDtoDao movieResponseDtoDao;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Map<Long, List<String>> getAllCollections() {
        List<Object[]> collectionMoviesResponseDtos = entityManager.createQuery("select c.id, c.name, c.description, c.previewUrl," +
                "m.id, m.name, m.originName, m.dateRelease, m.countries, g.name, p.name, mp.type, avg(s.score) from Collection c left join c.movies m join m.genres g on m.id = g.id " +
                "join MoviePerson mp  join mp.professions p on p.id = m.id join Score s on m.id = s.id")
                .getResultList();
        Map<Long, List<String>> movieResponseDtoMap = new HashMap<>();
        for (Object[] o : collectionMoviesResponseDtos) {
            if (movieResponseDtoMap.get(o[0]) == null) {
                movieResponseDtoMap.put((Long) o[0], new ArrayList<>());
            }
            movieResponseDtoMap.get(o[0]).add((String) o[1]);
        }
        return movieResponseDtoMap;
    }
}
