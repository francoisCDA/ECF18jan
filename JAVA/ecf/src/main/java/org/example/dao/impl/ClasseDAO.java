package org.example.dao.impl;

import org.example.dao.BaseDAO;
import org.example.dao.DAO;
import org.example.entity.Classe;
import org.example.entity.Enseignant;
import org.hibernate.query.Query;

import java.util.List;

public class ClasseDAO extends BaseDAO implements DAO<Classe> {


    @Override
    public boolean create(Classe obj) {
        session = factory.openSession();
        session.beginTransaction();

        try {
            session.saveOrUpdate(obj);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public Classe get(int id) {
        session = factory.openSession();
        session.beginTransaction();

        try {
            return session.get(Classe.class,id); // super class
        } catch (Exception e){
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Classe> getAll() {
        session = factory.openSession();
        session.beginTransaction();

        try {
            Query<Classe> deptQuery = session.createQuery("from Classe ");
            return deptQuery.list();
        } catch (Exception e){
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Classe obj) {
        return create(obj);
    }

    @Override
    public boolean remove(int id) {
        session = factory.openSession();
        session.beginTransaction();

        try {
            Classe dept = session.get(Classe.class,id);
            session.remove(dept);
            session.getTransaction().commit();
            return true;
        } catch (Exception ignored) {
            return false;
        } finally {
            session.close();
        }
    }
}
