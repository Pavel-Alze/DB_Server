package course.smm_server.service;


import java.util.List;

public interface DAO<T,I,K> {

    void create(T t);
    List<T> getAll();
    T getByPk(I i);
    List<K> getByFk(I i);
    void update(T t, I i);
    void deleteByPk(I i);
    void deleteAll();
}
