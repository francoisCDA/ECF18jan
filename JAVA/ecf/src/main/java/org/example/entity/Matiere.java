package org.example.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "matiere")
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matiere", nullable = false)
    private Integer id;

    @Column(name = "intitule_matiere", nullable = false, length = 25)
    private String intituleMatiere;

    @Column(name = "description_mat", length = 200)
    private String descriptionMat;

    @Column(name = "duree_min")
    private Integer dureeMin;

    @Column(name = "coef_mat", nullable = false, precision = 2, scale = 1)
    private BigDecimal coefMat;

    @ManyToMany(mappedBy = "matieres")
    private List<Enseignant> enseignantList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntituleMatiere() {
        return intituleMatiere;
    }

    public void setIntituleMatiere(String intituleMatiere) {
        this.intituleMatiere = intituleMatiere;
    }

    public String getDescriptionMat() {
        return descriptionMat;
    }

    public void setDescriptionMat(String descriptionMat) {
        this.descriptionMat = descriptionMat;
    }

    public Integer getDureeMin() {
        return dureeMin;
    }

    public void setDureeMin(Integer dureeMin) {
        this.dureeMin = dureeMin;
    }

    public BigDecimal getCoefMat() {
        return coefMat;
    }

    public void setCoefMat(BigDecimal coefMat) {
        this.coefMat = coefMat;
    }

}