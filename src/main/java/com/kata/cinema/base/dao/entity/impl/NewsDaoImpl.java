package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.NewsDao;
import com.kata.cinema.base.models.dto.response.NewsResponseDto;
import com.kata.cinema.base.models.dto.response.NewsTitleResponseDto;
import com.kata.cinema.base.models.entitys.News;
import com.kata.cinema.base.models.enums.Rubric;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class NewsDaoImpl extends AbstractDaoImpl<Long, News> implements NewsDao {

    @Override
    public List<NewsTitleResponseDto> findLatestNews() {
        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.response.NewsTitleResponseDto(n.id, n.title) from News n where n.date > :curentDate " +
                "order by n.date", NewsTitleResponseDto.class)
                .setParameter("curentDate", LocalDate.now())
                .setMaxResults(10)
                .getResultList();
    }

    @Override
    public List<NewsResponseDto> findByDateBetweenAndRubric(LocalDate dateStart, LocalDate dateEnd, Rubric rubric) {
        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.response.NewsResponseDto(n.id, n.rubric, n.date, n.title, n.htmlBody) from News n " +
                "where ((n.date between :dateStart and :dateEnd) or (cast(:dateStart as date) is null and n.date <= :dateEnd) " +
                "or (cast(:dateEnd as date) is null and n.date >= :dateStart) or (cast(:dateStart as date) is null and cast(:dateEnd as date) is null ))" +
                "and (n.rubric = :rubric or cast(:rubric as string) is null)", NewsResponseDto.class)
                .setParameter("dateStart", dateStart)
                .setParameter("dateEnd", dateEnd)
                .setParameter("rubric", rubric)
                .getResultList();
    }
}
