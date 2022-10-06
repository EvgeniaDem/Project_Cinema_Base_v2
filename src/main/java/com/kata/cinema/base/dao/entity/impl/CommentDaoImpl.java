package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.CommentDao;
import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.models.entitys.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl extends AbstractDaoImpl<Long, Comment> implements CommentDao {

    @Override
    public List<CommentsResponseDto> getListOfComments(Long id) {
        return entityManager.createQuery(
                "select new com.kata.cinema.base.models.dto.response.CommentsResponseDto(" +
                        "c.id, c.message, c.parentId, c.level, cast(c.date as java.time.LocalDate) as date, cast(sum(case rc.rating when 0 then 1 else -1 end) as java.lang.Integer)," +
                        " u.id, u.login, u.avatarUrl) from RatingComment rc join rc.comment c join rc.user u where c.news.id = :id"
                        + " group by c.id, c.message, c.parentId, c.level, cast(c.date as java.time.LocalDate), u.id, u.login, u.avatarUrl", CommentsResponseDto.class)
                .setParameter("id", id)
                .getResultList();
    }
}
