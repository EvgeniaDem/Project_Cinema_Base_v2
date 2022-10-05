package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.CommentsResponseDtoPaginationDao;
import com.kata.cinema.base.dao.entity.impl.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.UserCommentDto;
import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.models.entitys.Comment;
import org.hibernate.query.Query;
import org.hibernate.transform.ResultTransformer;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

@Repository
public class CommentsResponseDtoPaginationDaoImpl extends AbstractDaoImpl<Long, Comment> implements CommentsResponseDtoPaginationDao {

    @Override
    @SuppressWarnings(value = "unchecked")
    public List<CommentsResponseDto> getItemsDto(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        return entityManager.createNativeQuery("select " +
                        "com.id , com.message, com.parent_id, com.level, com.date, sum(rc.rating), com.user_id " +
                        "from comments com left outer join rating_comment rc on com.id=rc.comment_id " +
                        "where com.is_moderate=false group by com.id order by com.id")
                .unwrap(Query.class)
                .setResultTransformer(new ResultTransformer() {
                    @Override
                    public Object transformTuple(Object[] tuple, String[] aliases) {
                        UserCommentDto ucd = new UserCommentDto();
                        ucd.setId(((BigInteger) tuple[6]).longValue());
                        return new CommentsResponseDto(
                                ((BigInteger) tuple[0]).longValue(),
                                (String) tuple[1],
                                tuple[2] == null ? null : ((BigInteger) tuple[2]).longValue(),
                                tuple[3] == null ? null : (Integer) tuple[3],
                                ((Timestamp) tuple[4]).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                                tuple[5] == null ? 0 : ((BigInteger) tuple[5]).intValue(),
                                ucd);
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