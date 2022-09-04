package com.kata.cinema.base.converter;

import com.kata.cinema.base.models.dto.request.CommentsRequestDto;
import com.kata.cinema.base.models.entitys.Comment;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface CommentMapper extends Converter<CommentsRequestDto, Comment> {
    Comment toComments(CommentsRequestDto commentsRequestDto);
}
