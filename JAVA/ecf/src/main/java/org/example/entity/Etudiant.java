package org.example.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etud", nullable = false)
    private Integer id;

    @Column(name = "prenom_etud", length = 50)
    private String prenomEtud;

    @Column(name = "nom_etud", length = 50)
    private String nomEtud;

    @Column(name = "date_naiss_etud")
    private LocalDate dateNaissEtud;

    @Column(name = "email", length = 50)
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenomEtud() {
        return prenomEtud;
    }

    public void setPrenomEtud(String prenomEtud) {
        this.prenomEtud = prenomEtud;
    }

    public String getNomEtud() {
        return nomEtud;
    }

    public void setNomEtud(String nomEtud) {
        this.nomEtud = nomEtud;
    }

    public LocalDate getDateNaissEtud() {
        return dateNaissEtud;
    }

    public void setDateNaissEtud(LocalDate dateNaissEtud) {
        this.dateNaissEtud = dateNaissEtud;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}