package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.models.entitys.Comment;
import com.kata.cinema.base.service.entity.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentDtoService extends AbstractService<Long, Comment> {
    //TODO вынести в CommentDtoService (реализацию тоже)
    List<CommentsResponseDto> getComments(Long id);

}
