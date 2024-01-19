package org.example.service;

import org.example.dao.impl.ClasseDAO;
import org.example.entity.*;

import java.util.List;

public class ClasseService implements EntityService<Classe> {

    private ClasseDAO classeDAO;

    public ClasseService(){
        classeDAO = new ClasseDAO();
    }

    public boolean create(String nomClass, NiveauClasse niveau, Enseignant matricule, Departement dpt){

        Classe classe = new Classe();
        classe.setNomClasse(nomClass);
        classe.setNiveauClasse(niveau.toString());
        classe.setEnseignant(matricule);
        classe.setIdDepartement(dpt);

        return create(classe);

    }

    @Override
    public boolean create(Classe obj) {
        return classeDAO.create(obj);
    }

    @Override
    public Classe get(int id) {
        return null;
    }

    public List<Classe> getAll(){
        return classeDAO.getAll();
    }

    @Override
    public boolean upd(Classe obj) {
        return false;
    }

    @Override
    public boolean del(int id) {
        return false;
    }


}
