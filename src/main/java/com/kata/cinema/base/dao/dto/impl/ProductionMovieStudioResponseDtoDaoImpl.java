package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.ProductionMovieStudioResponseDtoDao;
import com.kata.cinema.base.dao.entity.impl.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.response.ProductionMovieStudioResponseDto;
import com.kata.cinema.base.models.entitys.ProductionStudioMovie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductionMovieStudioResponseDtoDaoImpl extends AbstractDaoImpl<Long, ProductionStudioMovie> implements ProductionMovieStudioResponseDtoDao {
    @Override
    public List<ProductionMovieStudioResponseDto> getProductionStudiosMovie(Long id) {
        return entityManager.createQuery("select " +
                                "new com.kata.cinema.base.models.dto.response.ProductionMovieStudioResponseDto(psm.id, s.name, psm.performance)" +
                                "from ProductionStudioMovie psm join psm.movie m join psm.studio s join psm.performance p " +
                                "where m.id = :id"
                        , ProductionMovieStudioResponseDto.class)
                .setParameter("id", id)
                .getResultList();
    }
}
