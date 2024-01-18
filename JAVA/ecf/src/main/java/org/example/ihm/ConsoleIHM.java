package org.example.ihm;

public class ConsoleIHM {

    private Cmd cmd;

    public ConsoleIHM() {
        cmd = new Cmd();
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



    }

}
