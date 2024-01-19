package org.example.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LazySessionService {

    // explication : j'ai enfin trouvé un moyen d'éviter les problèmes de lazyAccess en laissant une session ouverte
    // (cf commentaire dans ClassDao)
    // puis m'est venu l'idée de le faire proprement avec une session dédiée pour ne pas avoir à en recréer une à chaque appel de fonction.
    // pas certain d'être parfaitement opti, mais là il est 12h06, ça marche, c'est déjà ça.
    // je ne sais pas si dans l'idéal il faudrait créer une 'LazySession' pour chaque DAO,
    // peut-être qu'une seule utilisée par toutes les requêtes "select" ferait le taf sans trop poser de problème...
    // ou alors peut être même une session unique qui resterait ouverte pour tout type de requête...

    private static Session classeSession;

    public static Session getLazyClassSession() {
        if (classeSession == null ){
            SessionFactory factory = SessionFactoryService.get();
            classeSession = factory.openSession();
        }

        return classeSession;

    }

    public static void closeLazySession() {

        classeSession.close();

    }



}
