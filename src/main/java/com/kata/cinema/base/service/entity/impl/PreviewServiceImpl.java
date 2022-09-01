package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.ContentDao;
import com.kata.cinema.base.dao.entity.MovieDao;
import com.kata.cinema.base.models.entitys.Content;
import com.kata.cinema.base.service.entity.PreviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class PreviewServiceImpl implements PreviewService {
    private final ContentDao contentDao;
    private final MovieDao movieDao;

    @Autowired
    public PreviewServiceImpl(ContentDao contentDao, MovieDao movieDao) {
        this.contentDao = contentDao;
        this.movieDao = movieDao;
    }

    @Override
    @Transactional(rollbackFor = {IOException.class})
    public void upload(Long id, String URL) {
        Content con = new Content();
        con.setContentUrl(URL);
        con.setMovies(movieDao.getById(id).orElseThrow());
        con.setContentUrl(URL);
        contentDao.create(con);
    }
}
