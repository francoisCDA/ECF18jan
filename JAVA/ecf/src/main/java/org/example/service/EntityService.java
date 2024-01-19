package org.example.service;

import java.util.List;

public interface EntityService <T> {

    public boolean create(T obj);

    public T get(int id);

    public List<T> getAll();

    public boolean upd(T obj);

    public boolean del(int id);

}
