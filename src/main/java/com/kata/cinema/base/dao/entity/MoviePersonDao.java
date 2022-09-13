package com.kata.cinema.base.dao.entity;

import com.kata.cinema.base.models.entitys.MoviePerson;

import java.util.List;
import java.util.Map;

public interface MoviePersonDao extends AbstractDao<Long, MoviePerson> {
    Map<Long, List<String>> getTwoMoviePersonMap();

    List<String> getAllMainCharacterOfMovie(Long movieId);

    List<Object[]> getMovieDirector(Long movieId);
}
