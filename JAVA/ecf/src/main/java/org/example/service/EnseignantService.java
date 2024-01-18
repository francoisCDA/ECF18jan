package org.example.service;

import org.example.dao.impl.EnseignantDAO;
import org.example.entity.Departement;
import org.example.entity.Enseignant;
import org.example.entity.GradeEnseignant;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class EnseignantService {

    private EnseignantDAO ensgnDAO;

    public EnseignantService() {
        ensgnDAO = new EnseignantDAO();
    }

    public boolean create(String prenom, String nom, LocalDate naissance, GradeEnseignant grade, Departement dept, boolean isDirecteur){

        LocalDate dateMax = LocalDate.now().minusYears(18);

        if (naissance.isAfter(dateMax) || prenom.trim().length() < 3 || nom.trim().length() < 3 ) {return false;}


        Enseignant enseignant = new Enseignant();
        enseignant.setMatricule();
        enseignant.setPrenomEns(prenom);
        enseignant.setNomEns(nom);
        enseignant.setDateNaissanceEns(naissance);
        enseignant.setGradeEns(grade);
        enseignant.setIdDepartement(dept);
        enseignant.setDirectDepart(isDirecteur);

        return ensgnDAO.create(enseignant);

    }

    public List<Enseignant> getAll(){

        return ensgnDAO.getAll();

    }



}
