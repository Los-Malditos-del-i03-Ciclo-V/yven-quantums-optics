package org.yqo.contract;

import java.util.List;

public interface ICrudService<T, ID>{

    // CREATE
    T createEntity (T entity);

    //READ
    T findEntityById (ID id);
    List<T> findAllEntities();

    // UPDATE
    T updateEntity(T entity);

    // DELETE
    void deleteEntityById(ID id);
}