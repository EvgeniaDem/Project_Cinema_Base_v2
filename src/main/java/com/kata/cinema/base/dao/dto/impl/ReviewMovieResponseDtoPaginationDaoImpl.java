package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.ReviewMovieResponseDtoPaginationDao;
import com.kata.cinema.base.dao.entity.impl.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.response.ReviewResponseDto;
import com.kata.cinema.base.models.entitys.Review;
import com.kata.cinema.base.models.enums.ReviewSortType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ReviewMovieResponseDtoPaginationDaoImpl extends AbstractDaoImpl<Long, Review> implements ReviewMovieResponseDtoPaginationDao {
    @Override
    public List<ReviewResponseDto> getItemsDto(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        String sortTypeText;
        switch ((ReviewSortType)parameters.get("sortType")) {
            case DATE_ASC: {
                sortTypeText = " order by r.date asc";
                break;
            }
            case DATE_DESC : {
                sortTypeText = " order by r.date desc";
                break;
            }

            default : {
                sortTypeText = " order by r.date asc";
            }
        }

        return entityManager.createQuery("select distinct " +
                        "new com.kata.cinema.base.models.dto.response.ReviewResponseDto(r.id, r.typeReview, r.title, r.description, r.user.firstName, r.date) " +
                        "from Review r where (r.typeReview = :typeReview or :typeReview is null) and r.movie.id = :id"
                        + sortTypeText, ReviewResponseDto.class)
                .setParameter("typeReview", parameters.get("typeReview"))
                .setParameter("id", parameters.get("id"))
                .setFirstResult((currentPage - 1) * itemsOnPage)
                .setMaxResults(itemsOnPage)
                .getResultList();
    }

    @Override
    public Long getResultTotal(Map<String, Object> parameters) {
        return entityManager.createQuery("select count(distinct r) " +
                        "from Review r where r.typeReview = :typeReview or :typeReview is null and r.movie.id = :id", Long.class)
                .setParameter("typeReview", parameters.get("typeReview"))
                .setParameter("id", parameters.get("id"))
                .getSingleResult();
    }
}
