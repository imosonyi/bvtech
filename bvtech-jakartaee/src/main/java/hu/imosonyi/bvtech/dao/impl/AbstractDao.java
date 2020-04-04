package hu.imosonyi.bvtech.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hu.imosonyi.bvtech.dao.Dao;

/**
 * Provides database access and default DAO implementation.
 *
 * @author István Mosonyi
 *
 * @param <E> Entity class.
 */
public abstract class AbstractDao<E extends Serializable> implements Dao<E> {

    private final Class<E> entityClass;

    protected AbstractDao (Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @PersistenceContext(unitName = "bvtech-pu")
    private EntityManager entityManager;

    public E save (E entity) {
        entityManager.persist(entity);
        return entity;
    }

    protected TypedQuery<E> createNamedQuery (String name) {
        return entityManager.createNamedQuery(name, entityClass);
    }

}
