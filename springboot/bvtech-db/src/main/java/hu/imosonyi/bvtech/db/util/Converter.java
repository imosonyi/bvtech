package hu.imosonyi.bvtech.db.util;

import java.io.Serializable;

/**
 * Utility interface for converting DTO objects to entities and backwards.
 *
 * @author István Mosonyi
 *
 * @param <T> DTO class.
 * @param <U> Entity class.
 */
public interface Converter<T, U extends Serializable> {

    /**
     * Convert DTO to entity.
     *
     * @param dto DTO object.
     * @return Entity object.
     */
    U convert (T dto);

    /**
     * Convert entity to DTO.
     *
     * @param entity Entity object.
     * @return DTO object.
     */
    T revert (U entity);

}
