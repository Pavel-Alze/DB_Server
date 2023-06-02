package course.smm_server.service;

import java.util.List;

public interface DAO2 <T,I,K,J>{
    void create(T t);
    List<T> getAll();
    T getByPk(I i);
    List<K> getByFk1(I i);
    List<J> getByFk2(I i);
    void update(T t);
    void deleteByPk(I i);
    void deleteAll();
}
