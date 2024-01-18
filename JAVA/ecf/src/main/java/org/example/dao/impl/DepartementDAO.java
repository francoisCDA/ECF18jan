package org.example.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;

import org.example.dao.BaseDAO;
import org.example.dao.DAO;
import org.example.entity.Departement;

import java.util.List;

public class DepartementDAO extends BaseDAO implements DAO<Departement> {
    @Override
    public boolean create(Departement obj) {

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
    public Departement get(int id) {

        session = factory.openSession();
        session.beginTransaction();

        try {
            return session.get(Departement.class,id);
        } catch (Exception e){
            return null;
        } finally {
            session.close();
        }

    }

    @Override
    public List<Departement> getAll() {
        session = factory.openSession();
        session.beginTransaction();

        try {
            Query<Departement> deptQuery = session.createQuery("from Departement");
            return deptQuery.list();
        } catch (Exception e){
            return null;
        } finally {
            session.close();
        }

    }

    @Override
    public boolean update(Departement obj) {
        return create(obj);
    }

    @Override
    public boolean remove(int id) {
        session = factory.openSession();
        session.beginTransaction();

        try {
            Departement dept = session.get(Departement.class,id);
            session.remove(dept);
            session.getTransaction().commit();
            return true;
        } catch (Exception ignored) {
            //System.out.printf(ignored.getMessage());
            return false;
        } finally {
            session.close();
        }
    }
}
