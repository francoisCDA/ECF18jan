package org.example.dao;

import org.example.service.SessionFactoryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public abstract class BaseDAO {

    protected SessionFactory factory;

    protected Session session;


    public BaseDAO() {
        factory = SessionFactoryService.get();
    }





}
