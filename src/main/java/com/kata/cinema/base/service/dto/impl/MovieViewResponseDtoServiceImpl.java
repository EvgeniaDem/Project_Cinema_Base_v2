package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.MovieViewResponseDtoDao;
import com.kata.cinema.base.models.dto.response.CastResponseDto;
import com.kata.cinema.base.models.dto.response.MoviePersonResponseDto;
import com.kata.cinema.base.models.dto.response.MovieViewResponseDto;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.service.dto.MovieViewResponseDtoService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Primary
@AllArgsConstructor
public class MovieViewResponseDtoServiceImpl implements MovieViewResponseDtoService {

    private final MovieViewResponseDtoDao movieViewResponseDtoDao;

    @Override
    public MovieViewResponseDto getMovieViewResponseDtoById(long id, User user) {
        List<MoviePersonResponseDto> moviePerson = movieViewResponseDtoDao.getMoviePerson(id);
        List<CastResponseDto> castResponseList = movieViewResponseDtoDao.getCastResponse(id);
        MovieViewResponseDto movieViewResponseDto = movieViewResponseDtoDao.getMovieViewResponse(id, user);
        Set<CastResponseDto> castResponseDtoSet = new HashSet<>(castResponseList);
        castResponseDtoSet.forEach(cast -> {
            Set<MoviePersonResponseDto> eachPersonList = new HashSet<>();
            moviePerson.forEach(person -> {
                if (cast.getProfessionId().equals(person.getProfessionId())) eachPersonList.add(person);
            });
            cast.setPersons(new ArrayList<>(eachPersonList));
        });
        movieViewResponseDto.setCasts(new ArrayList<>(castResponseDtoSet));
        return movieViewResponseDto;
    }
}
