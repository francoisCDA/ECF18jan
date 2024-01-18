package org.example.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ResultatId implements Serializable {
    private static final long serialVersionUID = -1885676760540516565L;
    @Column(name = "id_matiere", nullable = false)
    private Integer idMatiere;

    @Column(name = "id_etud", nullable = false)
    private Integer idEtud;

    public Integer getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Integer idMatiere) {
        this.idMatiere = idMatiere;
    }

    public Integer getIdEtud() {
        return idEtud;
    }

    public void setIdEtud(Integer idEtud) {
        this.idEtud = idEtud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ResultatId entity = (ResultatId) o;
        return Objects.equals(this.idMatiere, entity.idMatiere) &&
                Objects.equals(this.idEtud, entity.idEtud);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMatiere, idEtud);
    }

}