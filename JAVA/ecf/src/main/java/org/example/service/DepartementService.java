package org.example.service;


import org.example.dao.impl.DepartementDAO;
import org.example.entity.Departement;

import java.util.List;

public class DepartementService {

    private DepartementDAO departementDAO;

    public DepartementService() {
        departementDAO = new DepartementDAO();
    }

    public boolean create(String nomDept) {
        Departement dept = new Departement();
        dept.setNomDepart(nomDept);

        return departementDAO.create(dept);
    }

    public List<Departement> getAll(){
        return departementDAO.getAll();
    }

    public Departement get(int id) {
        return departementDAO.get(id);
    }


    public boolean del(int id) {
        return departementDAO.remove(id);
    }



}
