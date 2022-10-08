package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.PaginationDtoDao;
import com.kata.cinema.base.dao.entity.MovieDao;
import com.kata.cinema.base.dao.entity.PersonsDao;
import com.kata.cinema.base.exceptions.NotFoundByIdException;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.ExcertionResponseDto;
import com.kata.cinema.base.service.dto.ExcertionResponseDtoPaginationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExcertionResponseDtoPaginationServiceImpl extends PaginationDtoServiceImpl<ExcertionResponseDto> implements ExcertionResponseDtoPaginationService {

    private final PersonsDao personsDao;
    private final MovieDao movieDao;

    public ExcertionResponseDtoPaginationServiceImpl(PaginationDtoDao<ExcertionResponseDto> paginationDtoDao,
                                                     PersonsDao personsDao, MovieDao movieDao) {
        super(paginationDtoDao);
        this.personsDao = personsDao;
        this.movieDao = movieDao;
    }

    @Override
    @Transactional
    public PageDto<ExcertionResponseDto> getPaginationExcertionResponseDtoForPerson(Long personId, Integer pageNumber, Integer itemsOnPage) {
        if (!personsDao.isExistById(personId)) {
            throw new NotFoundByIdException("Персоны с id: " + personId + " не существует");
        }
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", personId);
        parameters.put("referenceId", "ex.person.id");
        return getPageDtoWithParameters(pageNumber, itemsOnPage, parameters);
    }

    @Override
    @Transactional
    public PageDto<ExcertionResponseDto> getPaginationExcertionResponseDtoForMovie(Long movieId, Integer pageNumber, Integer itemsOnPage) {
        if (!movieDao.isExistById(movieId)) {
            throw new NotFoundByIdException("Фильма с id: " + movieId + " не существует");
        }
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", movieId);
        parameters.put("referenceId", "ex.movie.id");
        return getPageDtoWithParameters(pageNumber, itemsOnPage, parameters);
    }
}

