package org.example.dao.impl;

import org.example.dao.BaseDAO;
import org.example.dao.DAO;
import org.example.entity.Departement;
import org.example.entity.Etudiant;
import org.hibernate.query.Query;

import java.util.List;

public class EtudiantDAO extends BaseDAO implements DAO<Etudiant> {
    @Override
    public boolean create(Etudiant obj) {
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
    public Etudiant get(int id) {
        session = factory.openSession();
        session.beginTransaction();

        try {
            return session.get(Etudiant.class,id);
        } catch (Exception e){
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Etudiant> getAll() {
        session = factory.openSession();
        session.beginTransaction();

        try {
            Query<Etudiant> deptQuery = session.createQuery("from Etudiant");
            return deptQuery.list();
        } catch (Exception e){
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Etudiant obj) {
        return create(obj);
    }

    @Override
    public boolean remove(int id) {
        session = factory.openSession();
        session.beginTransaction();

        try {
            Etudiant dept = session.get(Etudiant.class,id);
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
