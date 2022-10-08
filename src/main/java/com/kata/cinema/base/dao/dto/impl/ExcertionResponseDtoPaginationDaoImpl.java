package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.ExcertionResponseDtoPaginationDao;
import com.kata.cinema.base.dao.entity.impl.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.response.ExcertionResponseDto;
import com.kata.cinema.base.models.entitys.Excertion;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ExcertionResponseDtoPaginationDaoImpl extends AbstractDaoImpl<Long, Excertion> implements ExcertionResponseDtoPaginationDao {
    @Override
    public List<ExcertionResponseDto> getItemsDto(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        return entityManager.createQuery("select " +
                        "new com.kata.cinema.base.models.dto.response.ExcertionResponseDto(ex.id, ex.description) " +
                        "from Excertion ex where " +
                        parameters.get("referenceId") +
                        " = :id order by ex.id", ExcertionResponseDto.class)
                .setParameter("id", parameters.get("id"))
                .setFirstResult((currentPage - 1) * itemsOnPage)
                .setMaxResults(itemsOnPage)
                .getResultList();
    }

    @Override
    public Long getResultTotal(Map<String, Object> parameters) {
        return entityManager.createQuery("select count(ex) from Excertion ex where " +
                        parameters.get("referenceId") +
                        " = :id", Long.class)
                .setParameter("id", parameters.get("id"))
                .getSingleResult();
    }
}
