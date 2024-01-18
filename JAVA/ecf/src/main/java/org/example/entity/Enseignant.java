package org.example.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "enseignant")
public class Enseignant {
    @Id
    @Column(name = "matricule", nullable = false, length = 50)
    private String matricule;

    @Column(name = "prenom_ens", length = 50)
    private String prenomEns;

    @Column(name = "nom_ens", length = 50)
    private String nomEns;

    @Column(name = "date_naissance_ens", nullable = false)
    private LocalDate dateNaissanceEns;

    @Column(name = "grade_ens", length = 20)
    private GradeEnseignant gradeEns;

    @Column(name = "direct_depart")
    private Boolean directDepart;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_departement", nullable = false)
    private Departement idDepartement;

    @ManyToMany
    @JoinTable(
            name = "enseignant_matiere",
            joinColumns = @JoinColumn(name="matricule"),
            inverseJoinColumns = @JoinColumn(name = "id_matiere")
    )
    private List<Matiere> matieres;


    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setMatricule(){
        if (matricule != null) return;

        UUID uuid = UUID.randomUUID(); // plus de problème qu'autre chose comme solution

        setMatricule(uuid.toString());
    };

    public String getPrenomEns() {
        return prenomEns;
    }

    public void setPrenomEns(String prenomEns) {
        this.prenomEns = prenomEns;
    }

    public String getNomEns() {
        return nomEns;
    }

    public void setNomEns(String nomEns) {
        this.nomEns = nomEns;
    }

    public LocalDate getDateNaissanceEns() {
        return dateNaissanceEns;
    }

    public void setDateNaissanceEns(LocalDate dateNaissanceEns) {
        this.dateNaissanceEns = dateNaissanceEns;
    }

    public String getGradeEns() {
        return gradeEns.toString();
    }

    public void setGradeEns(GradeEnseignant gradeEns) {
        this.gradeEns = gradeEns;
    }
    public void setGradeEns(){ gradeEns = GradeEnseignant.NOOB; }

    public Boolean getDirectDepart() {
        return directDepart;
    }

    public void setDirectDepart(Boolean directDepart) {
        this.directDepart = directDepart;
    }

    public Departement getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(Departement idDepartement) {
        this.idDepartement = idDepartement;
    }

    @Override
    public String toString() {
        return "Enseignant :" +
                "matricule " + matricule +
                ", '" + prenomEns +
                " " + nomEns + '\'' +
                ", directeur de departement : " + directDepart +
                '.';
    }

    public String toStringNom() {
        return  prenomEns + " " + nomEns + '.';
    }
}