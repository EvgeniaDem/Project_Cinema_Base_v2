package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.AbstractDao;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDaoImpl<PK, E> implements AbstractDao<PK, E> {

    @PersistenceContext
    protected EntityManager entityManager;
    protected String genericClassName;
    protected String className;
    protected final Class<E> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDaoImpl() {
        this.persistentClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        this.genericClassName = persistentClass.toGenericString();
        this.className = genericClassName.substring(genericClassName.lastIndexOf('.') + 1);
    }

    @Override
    public List<E> getAll() {
        return entityManager.createQuery("FROM " + className, persistentClass).getResultList();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void create(E entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void update(E entity) {
        entityManager.merge(entity);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delete(E entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteById(PK id) {
        E proxyObject = entityManager.getReference(persistentClass, id);
        entityManager.remove(proxyObject);
    }

    @Override
    public Optional<E> getById(PK id) {
        try {
            return Optional.of(entityManager.find(persistentClass, id));
        } catch (NoResultException | NullPointerException e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean isExistById(PK id) {
        return entityManager.createQuery(
                        "SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM " + className + " e WHERE e.id =: id"
                        , Boolean.class
                )
                .setParameter("id", id)
                .getSingleResult();
    }
}
