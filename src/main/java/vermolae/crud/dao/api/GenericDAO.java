package vermolae.crud.dao.api;

import vermolae.exeptions.CustomDAOException;

import java.util.List;

public interface GenericDAO<E, K> {

    void create(E entity) throws CustomDAOException;

    E read(K id) throws CustomDAOException;

    void update(E entity) throws CustomDAOException;

    void delete(E entity) throws CustomDAOException;

    List<E> getAll() throws CustomDAOException;

}
