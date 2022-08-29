package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.GenresDao;
import com.kata.cinema.base.dao.impl.dto.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.response.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genres;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GenresDaoImpl extends AbstractDaoImpl<Long, Genres> implements GenresDao {
    @Override
    public Map<Long, List<String>> getAllMap() {
        List<Object[]> rows = entityManager.createQuery("select m.id, g.name from Genres g left join g.movies m").getResultList();
        Map<Long, List<String>> genresMap = new HashMap<>();
        for (Object[] o : rows) {
            if (genresMap.get(o[0]) == null) {
                genresMap.put((Long) o[0], new ArrayList<>());
            }
            genresMap.get(o[0]).add((String) o[1]);
        }
        return genresMap;
    }

    @Override
    public List<GenreResponseDto> getListOfGenres() {
        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.response.GenreResponseDto(g.id, g.name)" +
                        " from Genres g", GenreResponseDto.class)
                .getResultList();

    }


}
