package org.example.dao.impl;

import org.example.dao.BaseDAO;
import org.example.dao.DAO;
import org.example.entity.Classe;
import org.example.entity.Matiere;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MatiereDAO extends BaseDAO implements DAO<Matiere> {
    @Override
    public boolean create(Matiere obj) {
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
    public Matiere get(int id) {
        session = factory.openSession();
        session.beginTransaction();

        try {
            return session.get(Matiere.class,id);
        } catch (Exception e){
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Matiere> getAll() {
        Session lazySession = factory.openSession();
        lazySession.beginTransaction();

        try {
            Query<Matiere> deptQuery = lazySession.createQuery("from Matiere ");
            return deptQuery.list();
        } catch (Exception e){
            lazySession.close();
            return null;

        }
    }

    @Override
    public boolean update(Matiere obj) {
        return create(obj);
    }

    @Override
    public boolean remove(int id) {
        session = factory.openSession();
        session.beginTransaction();

        try {
            Matiere dept = session.get(Matiere.class,id);
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
