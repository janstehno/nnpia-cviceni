package cz.upce.fei.nnpia.cviceni.service;

import java.util.List;

public interface ServiceI<T> {
    List<T> getAllObjects();

    T getObjectById(Long id);

    T createObject(T t);

    T updateObject(T t);

    void deleteObject(Long id);
}