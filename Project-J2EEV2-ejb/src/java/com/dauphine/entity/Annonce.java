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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stark
 */
@Entity
@Table(name = "annonce")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Annonce.findAll", query = "SELECT a FROM Annonce a")
    , @NamedQuery(name = "Annonce.findByAnnId", query = "SELECT a FROM Annonce a WHERE a.annId = :annId")
    , @NamedQuery(name = "Annonce.findByAnnDateCreation", query = "SELECT a FROM Annonce a WHERE a.annDateCreation = :annDateCreation")
    , @NamedQuery(name = "Annonce.findByAnnPlaceDispo", query = "SELECT a FROM Annonce a WHERE a.annPlaceDispo = :annPlaceDispo")})
public class Annonce implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ann_id")
    private Integer annId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ann_date_creation")
    @Temporal(TemporalType.DATE)
    private Date annDateCreation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ann_place_dispo")
    private int annPlaceDispo;
    @JoinColumn(name = "ann_res_id", referencedColumnName = "resa_id")
    @ManyToOne(optional = false)
    private Reservation annResId;
    @JoinColumn(name = "ann_uspro_id", referencedColumnName = "uspro_id")
    @ManyToOne(optional = false)
    private UtilisateurProfessionnel annUsproId;

    public Annonce() {
    }

    public Annonce(Integer annId) {
        this.annId = annId;
    }

    public Annonce(Integer annId, Date annDateCreation, int annPlaceDispo) {
        this.annId = annId;
        this.annDateCreation = annDateCreation;
        this.annPlaceDispo = annPlaceDispo;
    }

    public Integer getAnnId() {
        return annId;
    }

    public void setAnnId(Integer annId) {
        this.annId = annId;
    }

    public Date getAnnDateCreation() {
        return annDateCreation;
    }

    public void setAnnDateCreation(Date annDateCreation) {
        this.annDateCreation = annDateCreation;
    }

    public int getAnnPlaceDispo() {
        return annPlaceDispo;
    }

    public void setAnnPlaceDispo(int annPlaceDispo) {
        this.annPlaceDispo = annPlaceDispo;
    }

    public Reservation getAnnResId() {
        return annResId;
    }

    public void setAnnResId(Reservation annResId) {
        this.annResId = annResId;
    }

    public UtilisateurProfessionnel getAnnUsproId() {
        return annUsproId;
    }

    public void setAnnUsproId(UtilisateurProfessionnel annUsproId) {
        this.annUsproId = annUsproId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (annId != null ? annId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Annonce)) {
            return false;
        }
        Annonce other = (Annonce) object;
        if ((this.annId == null && other.annId != null) || (this.annId != null && !this.annId.equals(other.annId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dauphine.entity.Annonce[ annId=" + annId + " ]";
    }
    
}
