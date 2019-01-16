/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dauphine.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stark
 */
@Entity
@Table(name = "notation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notation.findAll", query = "SELECT n FROM Notation n")
    , @NamedQuery(name = "Notation.findByNotId", query = "SELECT n FROM Notation n WHERE n.notId = :notId")
    , @NamedQuery(name = "Notation.findByNotNote", query = "SELECT n FROM Notation n WHERE n.notNote = :notNote")
    , @NamedQuery(name = "Notation.findByNotCommentaire", query = "SELECT n FROM Notation n WHERE n.notCommentaire = :notCommentaire")
    , @NamedQuery(name = "Notation.findByNotDate", query = "SELECT n FROM Notation n WHERE n.notDate = :notDate")
    , @NamedQuery(name = "Notation.findByNotHeure", query = "SELECT n FROM Notation n WHERE n.notHeure = :notHeure")})
public class Notation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "not_id")
    private Integer notId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "not_note")
    private int notNote;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "not_commentaire")
    private String notCommentaire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "not_date")
    @Temporal(TemporalType.DATE)
    private Date notDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "not_heure")
    private String notHeure;
    @JoinColumn(name = "not_resto_id", referencedColumnName = "res_id")
    @ManyToOne(optional = false)
    private Restaurant notRestoId;
    @JoinColumn(name = "not_usrPart_id", referencedColumnName = "uspar_id")
    @ManyToOne(optional = false)
    private Utilisateurparticulier notusrPartid;

    public Notation() {
    }

    public Notation(Integer notId) {
        this.notId = notId;
    }

    public Notation(Integer notId, int notNote, String notCommentaire, Date notDate, String notHeure) {
        this.notId = notId;
        this.notNote = notNote;
        this.notCommentaire = notCommentaire;
        this.notDate = notDate;
        this.notHeure = notHeure;
    }

    public Integer getNotId() {
        return notId;
    }

    public void setNotId(Integer notId) {
        this.notId = notId;
    }

    public int getNotNote() {
        return notNote;
    }

    public void setNotNote(int notNote) {
        this.notNote = notNote;
    }

    public String getNotCommentaire() {
        return notCommentaire;
    }

    public void setNotCommentaire(String notCommentaire) {
        this.notCommentaire = notCommentaire;
    }

    public Date getNotDate() {
        return notDate;
    }

    public void setNotDate(Date notDate) {
        this.notDate = notDate;
    }

    public String getNotHeure() {
        return notHeure;
    }

    public void setNotHeure(String notHeure) {
        this.notHeure = notHeure;
    }

    public Restaurant getNotRestoId() {
        return notRestoId;
    }

    public void setNotRestoId(Restaurant notRestoId) {
        this.notRestoId = notRestoId;
    }

    public Utilisateurparticulier getNotusrPartid() {
        return notusrPartid;
    }

    public void setNotusrPartid(Utilisateurparticulier notusrPartid) {
        this.notusrPartid = notusrPartid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notId != null ? notId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notation)) {
            return false;
        }
        Notation other = (Notation) object;
        if ((this.notId == null && other.notId != null) || (this.notId != null && !this.notId.equals(other.notId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dauphine.entity.Notation[ notId=" + notId + " ]";
    }
    
}
