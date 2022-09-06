package com.kata.cinema.base.service.entity;

import org.springframework.stereotype.Service;

@Service
public interface PreviewService {
    void upload(Long id, String URL);
}
