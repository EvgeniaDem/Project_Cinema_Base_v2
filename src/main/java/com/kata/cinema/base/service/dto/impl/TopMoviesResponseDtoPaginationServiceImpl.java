package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.TopMoviesResponseDtoPaginationDao;
import com.kata.cinema.base.dao.entity.GenresDao;
import com.kata.cinema.base.dao.entity.MoviePersonDao;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.TopMoviesResponseDto;
import com.kata.cinema.base.service.dto.TopMoviesResponseDtoPaginationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TopMoviesResponseDtoPaginationServiceImpl extends PaginationDtoServiceImpl<TopMoviesResponseDto> implements TopMoviesResponseDtoPaginationService {

    private final GenresDao genresDao;
    private final MoviePersonDao moviePersonDao;

    public TopMoviesResponseDtoPaginationServiceImpl(TopMoviesResponseDtoPaginationDao paginationDtoDao, GenresDao genresDao, MoviePersonDao moviePersonDao) {
        super(paginationDtoDao);
        this.genresDao = genresDao;
        this.moviePersonDao = moviePersonDao;
    }

    @Override
    public PageDto<TopMoviesResponseDto> getPageDtoWithParameters(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        PageDto<TopMoviesResponseDto> pageDto = super.getPageDtoWithParameters(currentPage, itemsOnPage, parameters);
        Map<Long, List<String>> genresMap = genresDao.getAllMap();
        Map<Long, List<String>> moviePersonMap = moviePersonDao.getTwoMoviePersonMap();
        for (TopMoviesResponseDto dto : pageDto.getEntities()) {
            dto.setGenres(genresMap.get(dto.getId()));
            dto.setActorsName(moviePersonMap.get(dto.getId()));
        }
        return pageDto;
    }
}
