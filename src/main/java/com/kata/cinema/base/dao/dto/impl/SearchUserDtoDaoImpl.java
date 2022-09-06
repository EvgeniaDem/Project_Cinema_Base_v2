package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.SearchUserDtoDao;
import com.kata.cinema.base.models.dto.response.SearchUserResponseDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SearchUserDtoDaoImpl implements SearchUserDtoDao {

    @PersistenceContext
    private EntityManager entityManager;

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
