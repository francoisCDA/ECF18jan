package org.example.ihm;

import org.example.entity.Departement;
import org.example.entity.Enseignant;
import org.example.entity.GradeEnseignant;
import org.example.entity.NiveauClasse;
import org.example.service.ClasseService;
import org.example.service.DepartementService;
import org.example.service.EnseignantService;

import java.time.LocalDate;
import java.util.List;

public class Cmd {

    private DepartementService dptServ;
    private EnseignantService ensgnServ;

    private ClasseService classeServ;

    public Cmd(){
        dptServ = new DepartementService();
        ensgnServ = new EnseignantService();
        classeServ = new ClasseService();
    }

    /*
            LES DEPARTEMENTS
    */

    public void addDpt(){

        String nomDpt = UtilIHM.inputText("nom du département");

        if (addDpt(nomDpt)) {
            UtilIHM.consoleConfirm("département ajouté");
        } else {
            UtilIHM.consoleFail("erreur");
        }


    }

    public boolean addDpt(String dptName) {

        return dptServ.create(dptName);
    }

    public void rmDpt(){

        if (!printDept()){ return; }

        try {
            int id = UtilIHM.inputNumber("saisir un id");

            if (rmDpt(id)) {
                UtilIHM.consoleConfirm("département supprimé");
            } else {
                UtilIHM.consoleError("suppression impossible");
            }

        } catch (Exception e) {
            UtilIHM.consoleError("erreur de saisie");
        }

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

    private Departement selectDpt(){

        UtilIHM.H3("sélectionner un département");

        if (!printDept()) { return null; }

        Departement departement ;

        try {
            int dptId = UtilIHM.inputNumber("id du département");
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

    public boolean printEnsgn() {

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

    public void addClasse(){

        Departement departement = selectDpt();

        Enseignant matricule = selectEnsgn();

        // inutile si une classe n'a QUE des profs d'un même département

        NiveauClasse[] niv = NiveauClasse.values();
        NiveauClasse niveau;

        for (NiveauClasse n:niv ){
             UtilIHM.consoleLi(n.getVal() + " - " + n);
        }

        try {
            int choix = UtilIHM.inputNumber("indiquer le niveau");
            if (choix >= 0 && choix < niv.length){
                niveau = niv[choix];
            } else {
                niveau = niv[0];
            }

        } catch (Exception e) {
            niveau = niv[0];
        }

        String nomClasse = UtilIHM.inputText("nom de la classe");

        if (classeServ.create(nomClasse,niveau,matricule,departement)){
            UtilIHM.consoleConfirm("la classe a été ajoutée");
        } else {
            UtilIHM.consoleFail("Erreur à l'ajout de la classe");
        }

    }



}
