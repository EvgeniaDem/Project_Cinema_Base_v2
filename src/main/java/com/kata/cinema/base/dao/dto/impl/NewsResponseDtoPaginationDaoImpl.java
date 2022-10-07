package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.NewsResponseDtoPaginationDao;
import com.kata.cinema.base.dao.entity.impl.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.response.NewsResponseDto;
import com.kata.cinema.base.models.entitys.News;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("newsResponseWithRubric")
public class NewsResponseDtoPaginationDaoImpl extends AbstractDaoImpl<Long, News> implements NewsResponseDtoPaginationDao {
    @Override
    public List<NewsResponseDto> getItemsDto(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        return entityManager.createQuery("" +
                        "select new com.kata.cinema.base.models.dto.response.NewsResponseDto(" +
                        "n.id, n.rubric, n.date, n.title, m.description, n.previewUrl, (select cast(count(com) as int) from Comment com where com.news.id = n.id)" +
                        ") from News n full join n.movies m where n.rubric = :rubric", NewsResponseDto.class)
                .setParameter("rubric", parameters.get("rubric"))
                .setFirstResult((currentPage - 1) * itemsOnPage)
                .setMaxResults(itemsOnPage)
                .getResultList();
    }

    @Override
    public Long getResultTotal(Map<String, Object> parameters) {
        return entityManager.createQuery("select count(n) from News n where n.rubric = :rubric", Long.class)
                .setParameter("rubric", parameters.get("rubric"))
                .getSingleResult();
    }
}
