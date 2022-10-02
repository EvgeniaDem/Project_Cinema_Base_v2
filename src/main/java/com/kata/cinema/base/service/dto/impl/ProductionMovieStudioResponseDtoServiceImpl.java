package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.ProductionMovieStudioResponseDtoDao;
import com.kata.cinema.base.models.dto.response.ProductionMovieStudioResponseDto;
import com.kata.cinema.base.service.dto.ProductionMovieStudioResponseDtoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductionMovieStudioResponseDtoServiceImpl implements ProductionMovieStudioResponseDtoService {

    private final ProductionMovieStudioResponseDtoDao productionMovieStudioResponseDtoDao;

    @Override
    public List<ProductionMovieStudioResponseDto> getProductionStudiosMovie(Long id) {
        return productionMovieStudioResponseDtoDao.getProductionStudiosMovie(id);
    }
}
