package org.example.entity;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "emploi_temps")
public class EmploiTemp {
    @EmbeddedId
    private EmploiTempId id;

    @MapsId("idMatiere")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_matiere", nullable = false)
    private Matiere idMatiere;

    @MapsId("idClasse")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_classe", nullable = false)
    private Classe idClasse;

    @Column(name = "heure")
    private LocalTime heure;

    @Column(name = "jour", length = 10)
    private String jour;

    public EmploiTempId getId() {
        return id;
    }

    public void setId(EmploiTempId id) {
        this.id = id;
    }

    public Matiere getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Matiere idMatiere) {
        this.idMatiere = idMatiere;
    }

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

}