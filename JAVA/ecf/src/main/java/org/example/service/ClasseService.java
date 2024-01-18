package org.example.service;

import org.example.dao.impl.ClasseDAO;
import org.example.entity.*;

public class ClasseService {

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

        return classeDAO.create(classe);


    }



}
