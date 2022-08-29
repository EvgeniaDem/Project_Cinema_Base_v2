package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.model.GenresDao;
import com.kata.cinema.base.models.dto.response.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genres;
import com.kata.cinema.base.service.abstracts.model.AbstractServiceImpl;
import com.kata.cinema.base.service.abstracts.model.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl extends AbstractServiceImpl<Long, Genres> implements GenreService {
    private final GenresDao genresDao;

    @Autowired
    public GenreServiceImpl(GenresDao genresDao) {
        super(genresDao);
        this.genresDao = genresDao;
    }

    @Override
    public List<GenreResponseDto> findGenres() {
        return genresDao.getListOfGenres();
    }

}
