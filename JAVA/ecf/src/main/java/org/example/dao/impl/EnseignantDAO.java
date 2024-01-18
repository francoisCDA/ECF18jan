package org.example.dao.impl;

import org.example.dao.BaseDAO;
import org.example.dao.DAO;

import org.example.entity.Enseignant;

import org.hibernate.query.Query;

import java.util.List;

public class EnseignantDAO extends BaseDAO implements DAO<Enseignant> {
    @Override
    public boolean create(Enseignant obj) {
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
    public Enseignant get(int id) {
        session = factory.openSession();
        session.beginTransaction();

        try {
            return session.get(Enseignant.class,id);
        } catch (Exception e){
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Enseignant> getAll() {
        session = factory.openSession();
        session.beginTransaction();

        try {
            Query<Enseignant> deptQuery = session.createQuery("from Enseignant ");
            return deptQuery.list();
        } catch (Exception e){
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Enseignant obj) {
        return create(obj);
    }

    @Override
    public boolean remove(int id) {
        session = factory.openSession();
        session.beginTransaction();

        try {
            Enseignant dept = session.get(Enseignant.class,id);
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
