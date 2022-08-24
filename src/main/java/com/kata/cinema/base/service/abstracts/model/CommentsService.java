package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.dto.GenreResponseDto;
import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.models.entitys.Comments;
import com.kata.cinema.base.models.entitys.Genres;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentsService extends AbstractService<Long, Comments> {
    List<CommentsResponseDto> getComments(Long id);
}
