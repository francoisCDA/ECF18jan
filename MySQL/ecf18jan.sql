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

Select * from enseignant;

select * from classe;

select * from matiere;



/*****************************
	requete à tester
***********************************/


-- Afficher la liste des classes (sans les eleves).

select nom_classe from classe;

-- Afficher le nombre de matière d'un élève.

SELECT e.id_etud, COUNT(et.id_matiere) AS nombre_de_matieres
FROM etudiant e
JOIN emploi_temps et ON e.id_classe = et.id_classe
WHERE e.id_etud = 1
GROUP BY e.id_etud;

-- Afficher la liste des notes d'un eleve (avec les détails).

SELECT note, commentaire_note FROM resultat WHERE id_etud = 1;

-- Afficher la moyenne d'un eleve.

SELECT e.id_etud, e.prenom_etud, e.nom_etud, AVG(r.note * m.coef_mat) AS moyenne
FROM etudiant e
JOIN resultat r ON e.id_etud = r.id_etud
JOIN matiere m ON r.id_matiere = m.id_matiere
WHERE e.id_etud = 1
GROUP BY e.id_etud, e.prenom_etud, e.nom_etud;

-- Afficher le nombre d'eleve d'un département.
-- ou pourquoi pas le nombre d'élève pour chaque département
SELECT d.nom_depart, c.nom_classe, COUNT(e.id_etud) AS nombre_eleves
FROM departement d
JOIN classe c ON d.id_departement = c.id_departement
LEFT JOIN etudiant e ON c.id_classe = e.id_classe
GROUP BY d.nom_depart, c.nom_classe;


-- Afficher tous les noms des eleves d'un niveau.

SELECT c.niveau_classe, COUNT(e.id_etud) AS nombre_eleves
FROM classe c
JOIN etudiant e ON c.id_classe = e.id_classe
GROUP BY c.niveau_classe;




