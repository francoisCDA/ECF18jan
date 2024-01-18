package org.example.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "resultat")
public class Resultat {
    @EmbeddedId
    private ResultatId id;

    @MapsId("idMatiere")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_matiere", nullable = false)
    private Matiere idMatiere;

    @MapsId("idEtud")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_etud", nullable = false)
    private Etudiant idEtud;

    @Column(name = "note", precision = 3, scale = 1)
    private BigDecimal note;

    @Column(name = "commentaire_note", length = 150)
    private String commentaireNote;

    public ResultatId getId() {
        return id;
    }

    public void setId(ResultatId id) {
        this.id = id;
    }

    public Matiere getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Matiere idMatiere) {
        this.idMatiere = idMatiere;
    }

    public Etudiant getIdEtud() {
        return idEtud;
    }

    public void setIdEtud(Etudiant idEtud) {
        this.idEtud = idEtud;
    }

    public BigDecimal getNote() {
        return note;
    }

    public void setNote(BigDecimal note) {
        this.note = note;
    }

    public String getCommentaireNote() {
        return commentaireNote;
    }

    public void setCommentaireNote(String commentaireNote) {
        this.commentaireNote = commentaireNote;
    }

}