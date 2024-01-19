package org.example.service;


import org.example.dao.impl.DepartementDAO;
import org.example.entity.Departement;

import java.util.List;

public class DepartementService implements EntityService<Departement> {

    private DepartementDAO departementDAO;

    public DepartementService() {
        departementDAO = new DepartementDAO();
    }

    @Override
    public boolean create(Departement dept) {
        return departementDAO.create(dept);
    }

    public boolean create(String nomDept) {
        Departement dept = new Departement();
        dept.setNomDepart(nomDept);

        return create(dept);
    }

    public List<Departement> getAll(){
        return departementDAO.getAll();
    }

    @Override
    public boolean upd(Departement obj) {
        return false;
    }


    public Departement get(int id) {
        return departementDAO.get(id);
    }


    public boolean del(int id) {
        return departementDAO.remove(id);
    }



}
