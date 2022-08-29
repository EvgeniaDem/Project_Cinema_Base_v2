package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.SearchUserDao;
import com.kata.cinema.base.models.dto.response.SearchUserResponseDto;
import com.kata.cinema.base.models.entitys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SearchUserDaoImpl extends AbstractDaoImpl<Long, User> implements SearchUserDao {

    private final EntityManager entityManager;

    @Autowired
    public SearchUserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<SearchUserResponseDto> findSearchUserByEmail(String email) {
        return entityManager.createQuery(
                        "select new com.kata.cinema.base.models.dto.SearchUserResponseDto(user.id, user.email, user.firstName, " +
                                "cast (user.birthday as string) , user.avatarUrl) ) "
                                + "from User user "
                                + "where user.email"
                                + " like :email",
                        SearchUserResponseDto.class)
                .setParameter("email", email)
                .getResultList();
    }

}
