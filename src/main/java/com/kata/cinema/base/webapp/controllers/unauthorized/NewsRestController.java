package com.kata.cinema.base.webapp.controllers.unauthorized;

import com.kata.cinema.base.exceptions.IdNotFoundException;
import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.models.dto.response.NewsTitleResponseDto;
import com.kata.cinema.base.service.abstracts.model.CommentsService;
import com.kata.cinema.base.service.abstracts.model.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsRestController {
    private final CommentsService commentsService;
    private final NewsService newsService;

    public NewsRestController(CommentsService commentsService, NewsService newsService) {
        this.commentsService = commentsService;
        this.newsService = newsService;
    }

    @GetMapping("/latest")
    public ResponseEntity<List<NewsTitleResponseDto>> getLatestNews() {
        return ResponseEntity.ok(newsService.getLatestNews());
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<CommentsResponseDto>> getListOfComments(@PathVariable Long id) throws IdNotFoundException {
        if (newsService.isExistById(id)) {
            newsService.getById(id);
            return ResponseEntity.ok(commentsService.getComments(id));
        }
        throw new IdNotFoundException("News with id: " + id + " does not exist, try looking for another");
    }

}
