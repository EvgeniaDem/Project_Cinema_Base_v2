package com.kata.cinema.base.webapp.controllers.unauthorized;

import com.kata.cinema.base.models.enums.TypeRating;
import com.kata.cinema.base.service.entity.ReactionReviewService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@Api(tags = "Рецензии")
@AllArgsConstructor
public class ReviewRestController {

    private final ReactionReviewService reactionReviewService;


    @PostMapping("/reviews/{id}")
    ResponseEntity<Void> getRatingForReview(@PathVariable Long id,
                                            @RequestParam TypeRating typeRating) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        parameters.put("typeRating", typeRating);
        reactionReviewService.getRatingForReview(id, typeRating);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
