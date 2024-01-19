package org.example.service;

import org.example.dao.impl.MatiereDAO;
import org.example.entity.Matiere;

import java.math.BigDecimal;
import java.util.List;

public class MatiereService implements EntityService<Matiere> {

    private MatiereDAO matiereDAO;

    public MatiereService() {
        matiereDAO = new MatiereDAO();
    }

    public boolean create(String intitule, String description, int minutes, BigDecimal coef){

        Matiere mat = new Matiere();
        mat.setIntituleMatiere(intitule);
        mat.setDescriptionMat(description);
        mat.setDureeMin(minutes);
        mat.setCoefMat(coef);

        return create(mat);

    }
    @Override
    public boolean create(Matiere obj) {
        return matiereDAO.create(obj);
    }

    @Override
    public Matiere get(int id) {
        return null;
    }

    @Override
    public List<Matiere> getAll() {
        return matiereDAO.getAll();
    }

    @Override
    public boolean upd(Matiere obj) {
        return matiereDAO.update(obj);
    }

    @Override
    public boolean del(int id) {
        return matiereDAO.remove(id);
    }
}
