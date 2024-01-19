package org.example.ihm;

import org.example.service.SessionFactoryService;

public class ConsoleIHM {

    private Cmd cmd;

    public ConsoleIHM() {
        cmd = new Cmd();
    }

    public void run() {

        boolean run = true;

        UtilIHM.H2("Welcome");

        UtilIHM.consoleConfirm("Type 'help' to print available commands");

        while (run) {

            String prompt = UtilIHM.inputText("$");

            switch (prompt) {
                case "exit", "quit", "q" -> run = false;
                case "help", "h" -> cmdMenu();
                case "addDpt" -> cmd.addDpt();
                case "rmDpt" -> cmd.rmDpt();
                case "printDpt" -> cmd.printDept();
                case "addEns" -> cmd.addEnsgn();
                case "printEns" -> cmd.printEnsgn();
                case "addClas" -> cmd.addClasse();

                case "" -> {}
                default -> UtilIHM.consoleFail("commande non trouvée - tapper 'help' pour afficher la liste des commandes disponibles");
            }
        }

        UtilIHM.closeScanner();
        SessionFactoryService.close();


    }

    private static void cmdMenu() {

        System.out.println("\n");
        UtilIHM.H3("Liste des commandes :");

        UtilIHM.consoleLi("help / h - afficher ce menu");
        UtilIHM.consoleLi("exit / quit / q - quitter l'application");
        UtilIHM.consoleLi("tests - lancer la procédure de tests");

        UtilIHM.consoleConfirm("gestion des départements");
        UtilIHM.consoleLi("addDpt - ajouter un département");
        UtilIHM.consoleLi("rmDpt - supprimer un département");
        UtilIHM.consoleLi("printDpt - lister les départements");

        UtilIHM.consoleConfirm("gestion des enseignants");
        UtilIHM.consoleLi("addEns - ajouter un enseignant");
        UtilIHM.consoleLi("printEns - lister des enseignants");

        UtilIHM.consoleConfirm("gestion des classes");
        UtilIHM.consoleLi("addClas - gestion des classes");


        System.out.println("\n");
    }



    public void tests() {

        if (cmd.addDpt("kjshfkurf") && cmd.addDpt("alpha") && cmd.addDpt("beta"))
        {
            System.out.println("operation réussie");
        } else {
            System.out.println("opération refusée");
        }


        if (cmd.rmDpt(1)){
            System.out.println("operation réussie");
        } else {
            System.out.println("opération refusée");
        }

        cmd.addEnsgn();

        cmd.addClasse();
        cmd.addClasse();



    }

}
