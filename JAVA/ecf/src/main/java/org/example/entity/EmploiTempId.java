package org.example.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmploiTempId implements Serializable {
    private static final long serialVersionUID = -6309987091364862382L;
    @Column(name = "id_matiere", nullable = false)
    private Integer idMatiere;

    @Column(name = "id_classe", nullable = false)
    private Integer idClasse;

    public Integer getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Integer idMatiere) {
        this.idMatiere = idMatiere;
    }

    public Integer getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Integer idClasse) {
        this.idClasse = idClasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EmploiTempId entity = (EmploiTempId) o;
        return Objects.equals(this.idMatiere, entity.idMatiere) &&
                Objects.equals(this.idClasse, entity.idClasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMatiere, idClasse);
    }

}