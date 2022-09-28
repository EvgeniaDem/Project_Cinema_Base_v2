package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.entity.GenresDao;
import com.kata.cinema.base.models.dto.response.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genre;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.dto.GenreDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreDtoServiceImpl extends AbstractServiceImpl<Long, Genre> implements GenreDtoService {
    private final GenresDao genresDao;

    @Autowired
    public GenreDtoServiceImpl(GenresDao genresDao) {
        super(genresDao);
        this.genresDao = genresDao;
    }

    @Override
    public List<GenreResponseDto> findGenres() {
        return genresDao.getListOfGenres();
    }

}
