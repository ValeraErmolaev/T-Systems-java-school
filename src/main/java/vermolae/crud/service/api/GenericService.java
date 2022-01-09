package vermolae.crud.service.api;


import vermolae.exeptions.CustomDAOException;

import java.util.List;

/**
 * Interface for GenericService
 */
public interface GenericService<E, K> {
    void createEntity(E entity) throws CustomDAOException;

    E getEntityById(K id) throws CustomDAOException;

    void updateEntity(E entity) throws CustomDAOException;

    void deleteEntity(E entity) throws CustomDAOException;

    List<E> getAll() throws CustomDAOException;


}
