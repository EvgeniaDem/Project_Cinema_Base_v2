package com.kata.cinema.base.dao.impl.dto;
import com.kata.cinema.base.dao.abstracts.dto.UserDao;
import com.kata.cinema.base.models.entitys.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<Long, User> implements UserDao {

    @Override
    public User findUserByEmail(String email) {
        TypedQuery<User> res = entityManager.createQuery("select u from User u JOIN fetch u.roles where u.email=:email", User.class);
        res.setParameter("email" , email);
        return res.getSingleResult();
    }
}
