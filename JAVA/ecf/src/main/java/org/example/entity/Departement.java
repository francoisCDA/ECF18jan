package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "departement")
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departement", nullable = false)
    private Integer id;

    @Column(name = "nom_depart", length = 15)
    private String nomDepart;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomDepart() {
        return nomDepart;
    }

    public void setNomDepart(String nomDepart) {
        this.nomDepart = nomDepart;
    }

    @Override
    public String toString() {
        return "Departement : " +
                "id = " + id +
                ", '" + nomDepart + '\'' +
                '.';
    }
}