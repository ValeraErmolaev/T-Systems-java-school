package vermolae.crud.service.serviceApi;

import vermolae.exeptions.CustomDAOException;

import java.util.List;

public interface GenericService<E, K> {
    public void createEntity(E entity) throws CustomDAOException;

    public E getEntityById(K id) throws CustomDAOException;

    public void updateEntity(E entity) throws CustomDAOException;

    public void deleteEntity(E entity) throws CustomDAOException;

    public List<E> getAll() throws CustomDAOException;


}
