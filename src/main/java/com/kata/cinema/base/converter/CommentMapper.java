package com.kata.cinema.base.converter;

import com.kata.cinema.base.models.dto.request.CommentsRequestDto;
import com.kata.cinema.base.models.entitys.Comments;
import org.springframework.core.convert.converter.Converter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper extends Converter<CommentsRequestDto, Comments> {
    Comments toComments(CommentsRequestDto commentsRequestDto);
}
