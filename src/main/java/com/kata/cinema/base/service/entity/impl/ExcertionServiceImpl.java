package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.converter.ExcertionMapper;
import com.kata.cinema.base.dao.entity.ExcertionDao;
import com.kata.cinema.base.dao.entity.MovieDao;
import com.kata.cinema.base.dao.entity.PersonsDao;
import com.kata.cinema.base.exceptions.NotFoundByIdException;
import com.kata.cinema.base.models.dto.request.ExcertionRequestDto;
import com.kata.cinema.base.models.entitys.Excertion;
import com.kata.cinema.base.models.entitys.Movie;
import com.kata.cinema.base.models.entitys.Person;
import com.kata.cinema.base.service.entity.ExcertionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ExcertionServiceImpl implements ExcertionService {
    private final PersonsDao personsDao;
    private final ExcertionMapper excertionMapper;
    private final MovieDao movieDao;
    private final ExcertionDao excertionDao;

    public ExcertionServiceImpl(PersonsDao personsDao, ExcertionMapper excertionMapper, MovieDao movieDao, ExcertionDao excertionDao) {
        this.personsDao = personsDao;
        this.excertionMapper = excertionMapper;
        this.movieDao = movieDao;
        this.excertionDao = excertionDao;
    }

    @Override
    @Transactional
    public void createExcertionWithPersonId(ExcertionRequestDto excertionRequestDto, Long personId) {
        Excertion excertion = excertionMapper.toExcertion(excertionRequestDto);
        Optional<Person> optional = personsDao.getById(personId);
        if (optional.isEmpty()) {
            throw new NotFoundByIdException("Персоны с id: " + personId + " не существует");
        }
        excertion.setPerson(optional.get());
        excertionDao.create(excertion);
    }

    @Override
    @Transactional
    public void createExcertionWithMovieId(ExcertionRequestDto excertionRequestDto, Long movieId) {
        Excertion excertion = excertionMapper.toExcertion(excertionRequestDto);
        Optional<Movie> optional = movieDao.getById(movieId);
        if (optional.isEmpty()) {
            throw new NotFoundByIdException("Фильма с id: " + movieId + " не существует");
        }
        excertion.setMovie(optional.get());
        excertionDao.create(excertion);
    }

    @Override
    @Transactional
    public void deleteExcertionById(Long excertionId) {
        if (!excertionDao.isExistById(excertionId)) {
            throw new NotFoundByIdException("Выдержки с id: " + excertionId + " не существует");
        }
        excertionDao.deleteById(excertionId);
    }

    @Override
    @Transactional
    public void updateExcertion(ExcertionRequestDto excertionRequestDto, Long excertionId) {
        Optional<Excertion> optional = excertionDao.getById(excertionId);
        if (optional.isEmpty()) {
            throw new NotFoundByIdException("Выдержки с id: " + excertionId + " не существует");
        }
        Excertion excertion = optional.get();
        excertion.setDescription(excertionRequestDto.getDescription());
        excertionDao.update(excertion);
    }
}
