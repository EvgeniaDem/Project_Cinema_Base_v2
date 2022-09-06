package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.SearchMovieResponseDtoPaginationDao;
import com.kata.cinema.base.dao.entity.GenresDao;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.SearchMovieResponseDto;
import com.kata.cinema.base.service.dto.SearchMovieResponseDtoPaginationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SearchMovieResponseDtoPaginationServiceImpl extends PaginationDtoServiceImpl<SearchMovieResponseDto> implements SearchMovieResponseDtoPaginationService {

    private final GenresDao genresDao;

    public SearchMovieResponseDtoPaginationServiceImpl(SearchMovieResponseDtoPaginationDao paginationDtoDao, GenresDao genresDao) {
        super(paginationDtoDao);
        this.genresDao = genresDao;
    }

    @Override
    public PageDto<SearchMovieResponseDto> getPageDtoWithParameters(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        PageDto<SearchMovieResponseDto> pageDto = super.getPageDtoWithParameters(currentPage, itemsOnPage, parameters);
        Map<Long, List<String>> map = genresDao.getAllMap();
        for (SearchMovieResponseDto dto : pageDto.getEntities()) {
            dto.setGenres(map.get(dto.getId()));
        }
        return pageDto;
    }
}
