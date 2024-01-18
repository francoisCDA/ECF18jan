/*****************************
      etablissement scolaire
******************************/

DROP DATABASE IF EXISTS etabliscolaire ;

CREATE DATABASE IF NOT EXISTS etabliscolaire;

USE etabliscolaire;


/**************************
	LES TABLES 
    
    a priori, j'aurais dû mettre des BIGINT pour les id, pour que JPA Explorer importe des Long...
    trop tard, ce sera des integer, faudra penser à faire un patch avant d'arriver au 2147483648ème élève.
    
*******************************/
CREATE TABLE matiere(
   id_matiere INT  AUTO_INCREMENT,
   intitule_matiere VARCHAR(25) NOT NULL,
   description_mat VARCHAR(200),
   duree_min INT,
   coef_mat DECIMAL(2,1) NOT NULL CHECK( coef_mat >= 1 AND coef_mat <= 5 ) ,
   PRIMARY KEY(id_matiere)
);

CREATE TABLE departement(
   id_departement INT   AUTO_INCREMENT,
   nom_depart VARCHAR(15),
   PRIMARY KEY(id_departement),
   UNIQUE(nom_depart)
);

CREATE TABLE enseignant(
   matricule VARCHAR(50),
   prenom_ens VARCHAR(50),
   nom_ens VARCHAR(50),
   date_naissance_ens DATE NOT NULL,
   grade_ens VARCHAR(20),
   direct_depart BOOLEAN,
   id_departement INT NOT NULL,
   PRIMARY KEY(matricule),
   FOREIGN KEY(id_departement) REFERENCES departement(id_departement)
);

CREATE TABLE classe(
   id_classe INT AUTO_INCREMENT,
   nom_classe VARCHAR(10),
   niveau_classe VARCHAR(10),
   matricule VARCHAR(50) NOT NULL,
   id_departement INT NOT NULL,
   PRIMARY KEY(id_classe),
   UNIQUE(matricule),
   UNIQUE(nom_classe),
   FOREIGN KEY(matricule) REFERENCES enseignant(matricule),
   FOREIGN KEY(id_departement) REFERENCES departement(id_departement)
);

CREATE TABLE etudiant(
   id_etud INT  AUTO_INCREMENT,
   prenom_etud VARCHAR(50),
   nom_etud VARCHAR(50),
   date_naiss_etud DATE,
   email VARCHAR(50),
   id_classe INT NOT NULL,
   PRIMARY KEY(id_etud),
   FOREIGN KEY(id_classe) REFERENCES classe(id_classe)
);

CREATE TABLE resultat(
   id_matiere INT,
   id_etud INT,
   note DECIMAL(3,1) CHECK( note >=0 AND note <= 20 ),
   commentaire_note VARCHAR(150),
   PRIMARY KEY(id_matiere, id_etud),
   FOREIGN KEY(id_matiere) REFERENCES matiere(id_matiere),
   FOREIGN KEY(id_etud) REFERENCES etudiant(id_etud)
);

CREATE TABLE emploi_temps(
   id_matiere INT,
   id_classe INT,
   heure TIME,
   jour VARCHAR(10),
   PRIMARY KEY(id_matiere, id_classe),
   FOREIGN KEY(id_matiere) REFERENCES matiere(id_matiere),
   FOREIGN KEY(id_classe) REFERENCES classe(id_classe)
);

CREATE TABLE enseignant_matiere(
   matricule VARCHAR(50),
   id_matiere INT,
   PRIMARY KEY(matricule, id_matiere),
   FOREIGN KEY(matricule) REFERENCES enseignant(matricule),
   FOREIGN KEY(id_matiere) REFERENCES matiere(id_matiere)
);




/*****************************
	requete vérification
***********************************/

SELECT * FROM departement;  



