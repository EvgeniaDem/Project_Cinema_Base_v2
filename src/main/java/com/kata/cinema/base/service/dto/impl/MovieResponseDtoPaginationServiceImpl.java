package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.PaginationDtoDao;
import com.kata.cinema.base.dao.entity.GenresDao;
import com.kata.cinema.base.dao.entity.impl.MoviePersonDaoImpl;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.MovieResponseDto;
import com.kata.cinema.base.service.dto.MovieResponseDtoPaginationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MovieResponseDtoPaginationServiceImpl extends PaginationDtoServiceImpl<MovieResponseDto> implements MovieResponseDtoPaginationService {

    private final GenresDao genresDao;
    private final MoviePersonDaoImpl moviePersonDaoImpl;

    public MovieResponseDtoPaginationServiceImpl(PaginationDtoDao<MovieResponseDto> paginationDtoDao,
                                                 GenresDao genresDao,
                                                 MoviePersonDaoImpl moviePersonDaoImpl) {
        super(paginationDtoDao);
        this.genresDao = genresDao;
        this.moviePersonDaoImpl = moviePersonDaoImpl;
    }

    @Override
    public PageDto<MovieResponseDto> getPageDtoWithParameters(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        PageDto<MovieResponseDto> pageDto = super.getPageDtoWithParameters(currentPage, itemsOnPage, parameters);
        for (MovieResponseDto dto : pageDto.getEntities()) {
            dto.setGenres(genresDao.getAllMovieGenres(dto.getId()).toString().replaceAll("[\\[\\]]", ""));
            dto.setDirector(getMovieDirector(moviePersonDaoImpl.getMovieDirector(dto.getId())));
            dto.setRoles(moviePersonDaoImpl.getAllMainCharacterOfMovie(dto.getId()).toString().replaceAll("[\\[\\]]", ""));
        }
        return pageDto;
    }

    private String getMovieDirector (List<Object[]> rows){
        StringBuilder sb = new StringBuilder();
        for (Object[] row : rows) {
            sb.append(row[0]).append(" ").append(row[1]);
        }
        return sb.toString();
    }
}
