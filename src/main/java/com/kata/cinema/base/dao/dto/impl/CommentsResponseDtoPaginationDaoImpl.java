package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.CommentsResponseDtoPaginationDao;
import com.kata.cinema.base.dao.entity.impl.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.UserCommentDto;
import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.models.entitys.Comment;
import liquibase.pro.packaged.L;
import org.hibernate.query.Query;
import org.hibernate.transform.ResultTransformer;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
public class CommentsResponseDtoPaginationDaoImpl extends AbstractDaoImpl<Long, Comment> implements CommentsResponseDtoPaginationDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<CommentsResponseDto> getItemsDto(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        return entityManager.createQuery("select " +
                        "c.id, c.message, c.parentId, c.level, c.date, " +
                        "(select cast(sum(rc.rating) as integer) " +
                        "from Comment sc left join RatingComment rc on sc.id = rc.comment.id where sc.id = c.id), " +
                        "u.id, u.login, u.avatarUrl " +
                        "from Comment c left join c.user u where c.isModerate = false order by c.id")
                .unwrap(Query.class)
                .setResultTransformer(new ResultTransformer() {
                    @Override
                    public Object transformTuple(Object[] tuple, String[] aliases) {
                        return new CommentsResponseDto(
                                (Long) tuple[0],
                                (String) tuple[1],
                                tuple[2] == null ? null : (Long) tuple[2],
                                tuple[3] == null ? null : (Integer) tuple[3],
                                (LocalDateTime) tuple[4],
                                tuple[5] == null ? null : (Integer) tuple[5],
                                new UserCommentDto(
                                        (Long) tuple[6],
                                        (String) tuple[7],
                                        tuple[8] == null ? null : (String) tuple[8]
                                ));

                    }

                    @Override
                    public List<CommentsResponseDto> transformList(List collection) {
                        return collection;
                    }
                })
                .setFirstResult((currentPage - 1) * itemsOnPage)
                .setMaxResults(itemsOnPage)
                .getResultList();
    }

    @Override
    public Long getResultTotal(Map<String, Object> parameters) {
        return entityManager.createQuery("select count(c) from Comment c where c.isModerate = false", Long.class)
                .getSingleResult();
    }
}