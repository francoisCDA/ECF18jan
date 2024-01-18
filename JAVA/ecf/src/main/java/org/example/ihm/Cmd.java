package org.example.ihm;

import org.example.entity.Departement;
import org.example.entity.Enseignant;
import org.example.entity.GradeEnseignant;
import org.example.service.DepartementService;
import org.example.service.EnseignantService;

import java.time.LocalDate;
import java.util.List;

public class Cmd {

    private DepartementService dptServ;
    private EnseignantService ensgnServ;


    public Cmd(){
        dptServ = new DepartementService();
        ensgnServ = new EnseignantService();
    }

    /*
            LES DEPARTEMENTS
    */

    public boolean addDpt(String dptName) {

        return dptServ.create(dptName);
    }

    public boolean rmDpt(int idDpt){

        return dptServ.del(idDpt);
    }

    public boolean printDept() {
        List<Departement> deptList = dptServ.getAll();

        if (deptList == null || deptList.isEmpty()) {
            UtilIHM.consoleConfirm("aucun département");
            return false;
        }

        for (Departement dpt: deptList) {
            UtilIHM.consoleLi(dpt.toString());
        }
        return true;

    }

    public Departement selectDpt(){

        UtilIHM.H3("sélectionner un département");

        if (!printDept()) { return null; }

        Departement departement ;

        try {
            int dptId = UtilIHM.inputNumber("numéro de département");
            departement = dptServ.get(dptId);
        } catch (Exception e) {
            UtilIHM.consoleFail("département invalide");
            return null;
        }

        if (departement == null) {
            UtilIHM.consoleFail("problème de connexion");
        }

        return departement;

    }



    /*
            LES ENSEIGNANTS
    */


    public void addEnsgn() {

        UtilIHM.H2("Création d'un nouvel enseignant");


        Departement departement = selectDpt();


        boolean isDirecteur = false;
        String directeur = UtilIHM.inputText("est le nouveau directeur du département (y/N)").toLowerCase();

        if (directeur.equals("y")) {
            isDirecteur = true;
            // TODO mettre à false est autres enseignants du département
        }


        String nom = UtilIHM.inputText("son nom").toUpperCase();
        String prenom = UtilIHM.inputText("son prénom");
        LocalDate naissance = UtilIHM.inputDate("sa date de naissance");

        GradeEnseignant grade;

        UtilIHM.H3("sélectionner son grade");
        UtilIHM.consoleLi("1 - " + GradeEnseignant.NOOB );
        UtilIHM.consoleLi("2 - " + GradeEnseignant.ADVENCED );
        UtilIHM.consoleLi("3 - " + GradeEnseignant.VETERANT );
        UtilIHM.consoleLi("4 - " + GradeEnseignant.MASTER );

        String choix = UtilIHM.inputText("#");

        switch (choix) {
            case "2" -> grade = GradeEnseignant.ADVENCED;
            case "3" -> grade = GradeEnseignant.VETERANT;
            case "4" -> grade = GradeEnseignant.MASTER;
            default -> grade = GradeEnseignant.NOOB;
        }


        if (ensgnServ.create(prenom,nom,naissance,grade,departement,isDirecteur)) {
            UtilIHM.consoleConfirm("ajout réussi");
        } else {
            UtilIHM.consoleFail("ajout impossible");
        }

    }

    private boolean printEnsgn() {

        List<Enseignant> ensgnList = ensgnServ.getAll();

        if (ensgnList == null || ensgnList.isEmpty()) {
            UtilIHM.consoleConfirm("aucun enseignant");
            return false;
        }

        for (Enseignant ensgn: ensgnList) {
            UtilIHM.consoleLi(ensgn.toString());
        }
        return true;

    }

    private Enseignant selectEnsgn() {


        UtilIHM.H3("sélectionner un enseignant");

        List<Enseignant> ensgnList = ensgnServ.getAll();

        if (ensgnList == null || ensgnList.isEmpty()) {
            UtilIHM.consoleConfirm("aucun enseignant");
            return null;
        }

        for (int i = 0 ; i < ensgnList.size() ; i++ ){

            UtilIHM.consoleLi(i + " - " + ensgnList.get(i).toStringNom());

        }

        Enseignant enseignant;

        try {
            int choixEnsg = UtilIHM.inputNumber("insiquer numero");
            enseignant = ensgnList.get(choixEnsg);
        } catch (Exception e) {
            return null;
        }

        return enseignant;
    }





     /*
            LES CLASSES
    */

    public void addClaase(){

        Departement departement = selectDpt();

        Enseignant matricule = selectEnsgn();

        // inutile si une classe n'a QUE des profs d'un même département


        



    }



}
