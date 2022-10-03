package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.CollectionMoviesResponseDtoDao;
import com.kata.cinema.base.dao.dto.MovieResponseDtoDao;
import com.kata.cinema.base.dao.dto.PageDtoDao;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.CollectionMoviesResponseDto;
import com.kata.cinema.base.models.dto.response.MovieResponseDto;
import com.kata.cinema.base.service.dto.CollectionMoviesResponseDtoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CollectionMoviesResponseDtoServiceImpl extends PageDtoServiseImpl<CollectionMoviesResponseDto> implements CollectionMoviesResponseDtoService {

    private final MovieResponseDtoDao movieResponseDtoDao;


    public CollectionMoviesResponseDtoServiceImpl(PageDtoDao<CollectionMoviesResponseDto> pageDtoDao, MovieResponseDtoDao movieResponseDtoDao) {
        super(pageDtoDao);
        this.movieResponseDtoDao = movieResponseDtoDao;
    }

    @Override
    public PageDto<CollectionMoviesResponseDto> getPageDtoWithParameters(Long id, Map<String, Object> parameters) {
        PageDto<CollectionMoviesResponseDto> pageDto = super.getPageDtoWithParameters(id, parameters);
        Map<Long, List<MovieResponseDto>> movieResponseDtoMap = movieResponseDtoDao.getMapMovieResponseValueByCollectionMoviesDtoIds(parameters, id);
        for (CollectionMoviesResponseDto dto : pageDto.getEntities()) {
            dto.setMovies(movieResponseDtoMap.get(id));
            System.out.println(movieResponseDtoMap.get(dto.getId()));
        }
        return pageDto;
    }

}
