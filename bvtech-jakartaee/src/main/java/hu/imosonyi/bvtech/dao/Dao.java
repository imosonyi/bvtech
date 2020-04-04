package hu.imosonyi.bvtech.dao;

import java.io.Serializable;

/**
 * Default functions for DAOs.
 *
 * @author István Mosonyi
 *
 * @param <E> Entity class.
 */
public interface Dao<E extends Serializable> {

    /**
     * Store entity in database.
     *
     * @param entity Entity object.
     * @return Stored entity object.
     */
    E save (E entity);

}
