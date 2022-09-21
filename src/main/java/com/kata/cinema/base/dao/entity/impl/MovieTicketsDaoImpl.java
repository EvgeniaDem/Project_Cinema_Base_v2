package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.MovieTicketsDao;
import com.kata.cinema.base.models.entitys.MovieTicket;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class MovieTicketsDaoImpl extends AbstractDaoImpl <Long, MovieTicket> implements MovieTicketsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addMovieTickets() {
        LocalDate now = LocalDate.now();
        List<MovieTicket> movieTicketList = entityManager.createQuery("select  new MovieTicket(m, m.dateRelease) from Movie m" +
                        " where m.dateRelease = :now", MovieTicket.class)
                .setParameter("now", now)
                .getResultList();
        for (MovieTicket movieTicket: movieTicketList) {
            entityManager.persist(movieTicket);
        }
    }

    @Override
    @Transactional
    public void deleteMovieTickets() {
        LocalDate now = LocalDate.now();
        List<MovieTicket> movieTicketList = entityManager.createQuery("select  mt from MovieTicket mt" +
                        " where mt.endShowDate < :now", MovieTicket.class)
                .setParameter("now", now)
                .getResultList();
        for (MovieTicket movieTicket: movieTicketList) {
            entityManager.remove(movieTicket);
            entityManager.flush();
        }
    }
}
