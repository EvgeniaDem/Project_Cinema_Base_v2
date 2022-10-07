package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.models.enums.TypeRating;
import com.kata.cinema.base.service.entity.RatingCommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/comment")
@AllArgsConstructor
public class UserCommentRestController {

    private final RatingCommentService ratingCommentService;

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateReaction(@PathVariable Long id, @RequestParam("typeRating")TypeRating typeRating) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user;
        if (auth != null) {
            user = (User) auth.getPrincipal();
        } else {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }

        ratingCommentService.patchComment(id, user, typeRating);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
