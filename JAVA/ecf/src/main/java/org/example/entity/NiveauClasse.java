package org.example.entity;

public enum NiveauClasse {
    SIXIEME(0),
    CINQUIME(1),
    QUATRIEME(2),
    TROISIEME(3),
    SECONDE(4),
    TERMINAL(5);

    private final int val;

    NiveauClasse(int i) {
        val = i;
    }

    public int getVal(){
        return val;
    }

}
