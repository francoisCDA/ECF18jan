package org.example.service;

import org.example.dao.impl.EtudiantDAO;
import org.example.entity.Classe;
import org.example.entity.Etudiant;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EtudiantService {

    private EtudiantDAO etudiantDAO;

    public EtudiantService() {
        etudiantDAO = new EtudiantDAO();
    }

    public boolean create(String prenom, String nom, LocalDate naissance, String gmailUser, Classe classe){

        if ( prenom.trim().length() < 3 || nom.trim().length() < 3 ) {return false;}

        if (checkUserGmail(gmailUser)) {
            gmailUser += "@gmail.com";
        } else {
            return false;
        }

        Etudiant student = new Etudiant();
        student.setClasse(classe);
        student.setDateNaissEtud(naissance);
        student.setEmail(gmailUser);
        student.setNomEtud(nom);
        student.setPrenomEtud(prenom);

        return etudiantDAO.create(student);

    }

    private boolean checkUserGmail(String userName) {
        String regex = "^[a-zA-Z0-9._-]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userName);
        return matcher.matches();
    }





}
