package service.interfaces;

import exceptions.AlreadyExistsException;

import java.util.List;

public interface IBaseService<T> {
    void save(T t) throws AlreadyExistsException;
    T getById(int id);
    List<T> getAll();
}
