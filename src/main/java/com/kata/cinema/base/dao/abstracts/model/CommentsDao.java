package com.kata.cinema.base.dao.abstracts.model;

import com.kata.cinema.base.dao.abstracts.dto.AbstractDao;
import com.kata.cinema.base.models.dto.response.GenreResponseDto;
import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.models.entitys.Comments;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsDao extends AbstractDao<Long, Comments> {
    List<CommentsResponseDto> getListOfComments(Long id);
}
