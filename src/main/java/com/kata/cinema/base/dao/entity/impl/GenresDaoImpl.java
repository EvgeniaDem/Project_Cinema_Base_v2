package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.GenresDao;
import com.kata.cinema.base.models.dto.response.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genre;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GenresDaoImpl extends AbstractDaoImpl<Long, Genre> implements GenresDao {
    @Override
    public Map<Long, List<String>> getAllMap() {
        List<Object[]> rows = entityManager.createQuery("select m.id, g.name from Genre g left join g.movie m").getResultList();
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
                        " from Genre g", GenreResponseDto.class)
                .getResultList();

    }

    @Override
    public List<String> getAllMovieGenres(Long movieId) {
        return entityManager.createQuery("select g.name from Genre g join g.movie m where m.id =:id", String.class)
                .setParameter("id", movieId)
                .getResultList();
    }
}
