package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.ContentDao;
import com.kata.cinema.base.models.entitys.Content;
import org.springframework.stereotype.Repository;

@Repository
public class ContentDaoImpl extends AbstractDaoImpl<Long, Content> implements ContentDao {

}
