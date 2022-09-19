package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.PaginationDtoDao;
import com.kata.cinema.base.dao.entity.GenresDao;
import com.kata.cinema.base.dao.entity.MoviePersonDao;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.MovieResponseDto;
import com.kata.cinema.base.service.dto.MovieResponseDtoPaginationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MovieResponseDtoPaginationServiceImpl extends PaginationDtoServiceImpl<MovieResponseDto> implements MovieResponseDtoPaginationService {

    private final GenresDao genresDao;
    private final MoviePersonDao moviePersonDao;

    public MovieResponseDtoPaginationServiceImpl(PaginationDtoDao<MovieResponseDto> paginationDtoDao,
                                                 GenresDao genresDao,
                                                 MoviePersonDao moviePersonDao) {
        super(paginationDtoDao);
        this.genresDao = genresDao;
        this.moviePersonDao = moviePersonDao;
    }

    @Override
    public PageDto<MovieResponseDto> getPageDtoWithParameters(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        PageDto<MovieResponseDto> pageDto = super.getPageDtoWithParameters(currentPage, itemsOnPage, parameters);
        Map<Long, List<String>> genresMap = genresDao.getAllMap();
        Map<Long, List<String>> directorMap = moviePersonDao.getMovieDirectorMap();
        Map<Long, List<String>> rolesMap = moviePersonDao.getAllMainCharacterOfMoviesMap();
        for (MovieResponseDto dto : pageDto.getEntities()) {
            dto.setGenres(genresMap.get(dto.getId()).toString().replaceAll("[\\[\\]]", ""));
            dto.setDirector(directorMap.get(dto.getId()).toString().replaceAll("[\\[\\]]", ""));
            dto.setRoles(rolesMap.get(dto.getId()).toString().replaceAll("[\\[\\]]", ""));
        }
        return pageDto;
    }
}
