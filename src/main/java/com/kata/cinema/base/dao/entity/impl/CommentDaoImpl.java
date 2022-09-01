package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.CommentDao;
import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.models.entitys.Comments;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class CommentDaoImpl extends AbstractDaoImpl<Long, Comments> implements CommentDao {

    @Override
    public List<CommentsResponseDto> getListOfComments(Long id) {
        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.response.CommentsResponseDto(c.id, c.text, c.date)" +
                        " from Comments c where c.date <= : presentDate order by c.date desc", CommentsResponseDto.class)
                .setParameter("presentDate", LocalDateTime.now())
                .setMaxResults(10)
                .getResultList();
    }
}
