package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.ReviewMovieResponseDtoDao;
import com.kata.cinema.base.dao.entity.impl.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.response.ReviewMovieResponseDto;

import com.kata.cinema.base.models.entitys.Review;
import org.springframework.stereotype.Repository;



@Repository
public class ReviewMovieResponseDtoDaoImpl extends AbstractDaoImpl<Long, Review> implements ReviewMovieResponseDtoDao {


    @Override
    public ReviewMovieResponseDto getReviewMovieResponseDto(Long id) {
        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.response.ReviewMovieResponseDto(cast(count(r.typeReview) as int), " +
                        "(select cast(count(r.typeReview) as int) from Review r where r.movie.id = :id and r.typeReview = 'POSITIVE'), " +
                        "(select cast(count(r.typeReview) as int) from Review r where r.movie.id = :id and r.typeReview = 'NEGATIVE'), " +
                        "(select cast(count(r.typeReview) as int) from Review r where r.movie.id = :id and r.typeReview = 'NEUTRAL')) " +
                        "from Review r where r.movie.id = :id ", ReviewMovieResponseDto.class)
                .setParameter("id", id)
                .getSingleResult();
    }


}
