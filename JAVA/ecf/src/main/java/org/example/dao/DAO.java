package org.example.dao;


import java.util.List;

public interface DAO<T> {

    // alors les ID devrait être des Long et pas des int,

    public boolean create(T obj);

    public T get(int id);

    public List<T> getAll();

    public boolean update(T obj);

    public boolean remove(int id);


}
