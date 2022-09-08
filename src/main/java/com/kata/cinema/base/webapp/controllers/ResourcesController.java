package com.kata.cinema.base.webapp.controllers;


import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@RestController
@RequestMapping("/uploads")
@NoArgsConstructor
public class ResourcesController {

    @GetMapping("/**")
    public ResponseEntity<byte[]> getImage(HttpServletRequest request) {
        String image = request.getServletPath();
        try (InputStream inputStream = getClass().getResourceAsStream(image)) {
            HttpHeaders headers = new HttpHeaders();
            if (image.endsWith(".png")) {
                headers.setContentType(MediaType.IMAGE_PNG);
            } else if (image.endsWith(".jpg")) {
                headers.setContentType(MediaType.IMAGE_JPEG);
            } else if (image.endsWith(".gif")) {
                headers.setContentType(MediaType.IMAGE_GIF);
            }
            byte[] imageCode = Objects.requireNonNull(inputStream).readAllBytes();
            headers.setContentLength(imageCode.length);
            return new ResponseEntity<>(imageCode, headers, HttpStatus.OK);
        } catch (IOException | NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
