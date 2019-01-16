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
@Table(name = "historiqueReservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoriqueReservation.findAll", query = "SELECT h FROM HistoriqueReservation h")
    , @NamedQuery(name = "HistoriqueReservation.findByHistId", query = "SELECT h FROM HistoriqueReservation h WHERE h.histId = :histId")
    , @NamedQuery(name = "HistoriqueReservation.findByHistDate", query = "SELECT h FROM HistoriqueReservation h WHERE h.histDate = :histDate")
    , @NamedQuery(name = "HistoriqueReservation.findByHistHeure", query = "SELECT h FROM HistoriqueReservation h WHERE h.histHeure = :histHeure")
    , @NamedQuery(name = "HistoriqueReservation.findByHistnbPersonne", query = "SELECT h FROM HistoriqueReservation h WHERE h.histnbPersonne = :histnbPersonne")})
public class HistoriqueReservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hist_id")
    private Integer histId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hist_date")
    @Temporal(TemporalType.DATE)
    private Date histDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "hist_heure")
    private String histHeure;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hist_nbPersonne")
    private int histnbPersonne;
    @JoinColumn(name = "hist_resa_id", referencedColumnName = "resa_id")
    @ManyToOne(optional = false)
    private Reservation histResaId;
    @JoinColumn(name = "hist_resto_id", referencedColumnName = "res_id")
    @ManyToOne(optional = false)
    private Restaurant histRestoId;
    @JoinColumn(name = "hist_userpro_id", referencedColumnName = "uspro_id")
    @ManyToOne(optional = false)
    private UtilisateurProfessionnel histUserproId;
    @JoinColumn(name = "hist_userpar_id", referencedColumnName = "uspar_id")
    @ManyToOne(optional = false)
    private Utilisateurparticulier histUserparId;

    public HistoriqueReservation() {
    }

    public HistoriqueReservation(Integer histId) {
        this.histId = histId;
    }

    public HistoriqueReservation(Integer histId, Date histDate, String histHeure, int histnbPersonne) {
        this.histId = histId;
        this.histDate = histDate;
        this.histHeure = histHeure;
        this.histnbPersonne = histnbPersonne;
    }

    public Integer getHistId() {
        return histId;
    }

    public void setHistId(Integer histId) {
        this.histId = histId;
    }

    public Date getHistDate() {
        return histDate;
    }

    public void setHistDate(Date histDate) {
        this.histDate = histDate;
    }

    public String getHistHeure() {
        return histHeure;
    }

    public void setHistHeure(String histHeure) {
        this.histHeure = histHeure;
    }

    public int getHistnbPersonne() {
        return histnbPersonne;
    }

    public void setHistnbPersonne(int histnbPersonne) {
        this.histnbPersonne = histnbPersonne;
    }

    public Reservation getHistResaId() {
        return histResaId;
    }

    public void setHistResaId(Reservation histResaId) {
        this.histResaId = histResaId;
    }

    public Restaurant getHistRestoId() {
        return histRestoId;
    }

    public void setHistRestoId(Restaurant histRestoId) {
        this.histRestoId = histRestoId;
    }

    public UtilisateurProfessionnel getHistUserproId() {
        return histUserproId;
    }

    public void setHistUserproId(UtilisateurProfessionnel histUserproId) {
        this.histUserproId = histUserproId;
    }

    public Utilisateurparticulier getHistUserparId() {
        return histUserparId;
    }

    public void setHistUserparId(Utilisateurparticulier histUserparId) {
        this.histUserparId = histUserparId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (histId != null ? histId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoriqueReservation)) {
            return false;
        }
        HistoriqueReservation other = (HistoriqueReservation) object;
        if ((this.histId == null && other.histId != null) || (this.histId != null && !this.histId.equals(other.histId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dauphine.entity.HistoriqueReservation[ histId=" + histId + " ]";
    }
    
}
