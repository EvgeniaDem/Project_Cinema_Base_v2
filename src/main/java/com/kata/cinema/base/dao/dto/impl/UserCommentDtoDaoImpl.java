package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.UserCommentDtoDao;
import com.kata.cinema.base.models.dto.UserCommentDto;
import org.hibernate.transform.ResultTransformer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserCommentDtoDaoImpl implements UserCommentDtoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Map<Long, UserCommentDto> getMapForCommentsResponseDto() {
        Map<Long, UserCommentDto> dtoMap = new HashMap<>();
        entityManager.createQuery("select " +
                        "u.id, u.login, u.avatarUrl " +
                        "from Comment c left join c.user u " +
                        "where c.isModerate=false")
                .unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(new ResultTransformer() {
                    @Override
                    public Object transformTuple(Object[] tuple, String[] aliases) {
                        UserCommentDto ucd = new UserCommentDto();
                        ucd.setId((Long) tuple[0]);
                        ucd.setLogin((String) tuple[1]);
                        ucd.setAvatarUrl(tuple[2] == null ? null : (String) tuple[2]);
                        dtoMap.put((Long) tuple[0], ucd);
                        return tuple;
                    }

                    @Override
                    public List transformList(List collection) {
                        return collection;
                    }
                }).getResultList();
        return dtoMap;
    }
}
