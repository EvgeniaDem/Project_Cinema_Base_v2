package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.PaginationDtoDao;
import com.kata.cinema.base.dao.abstracts.model.GenresDao;
import com.kata.cinema.base.dao.abstracts.model.MoviePersonDao;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.TopMoviesResponseDto;
import com.kata.cinema.base.service.abstracts.dto.TopMoviesResponseDtoPaginationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TopMoviesResponseDtoPaginationServiceImpl extends PaginationDtoServiceImpl<TopMoviesResponseDto> implements TopMoviesResponseDtoPaginationService {

    private final GenresDao genresDao;
    private final MoviePersonDao moviePersonDao;

    public TopMoviesResponseDtoPaginationServiceImpl(PaginationDtoDao<TopMoviesResponseDto> paginationDtoDao, GenresDao genresDao, MoviePersonDao moviePersonDao) {
        super(paginationDtoDao);
        this.genresDao = genresDao;
        this.moviePersonDao = moviePersonDao;
    }

    @Override
    public PageDto<TopMoviesResponseDto> getPageDtoWithParameters(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        PageDto<TopMoviesResponseDto> pageDto = super.getPageDtoWithParameters(currentPage, itemsOnPage, parameters);
        Map<Long,List<String>> genresMap = genresDao.getAllMap();
        Map<Long,List<String>> moviePersonMap = moviePersonDao.getTwoMoviePersonMap();
        for (TopMoviesResponseDto dto : pageDto.getEntities()) {
            dto.setGenres(genresMap.get(dto.getId()));
            dto.setActorsName(moviePersonMap.get(dto.getId()));
        }
        return pageDto;
    }
}
