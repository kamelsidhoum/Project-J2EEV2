/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dauphine.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stark
 */
@Entity
@Table(name = "utilisateurparticulier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateurparticulier.findAll", query = "SELECT u FROM Utilisateurparticulier u")
    , @NamedQuery(name = "Utilisateurparticulier.findByUsparId", query = "SELECT u FROM Utilisateurparticulier u WHERE u.usparId = :usparId")
    , @NamedQuery(name = "Utilisateurparticulier.findByUsparNom", query = "SELECT u FROM Utilisateurparticulier u WHERE u.usparNom = :usparNom")
    , @NamedQuery(name = "Utilisateurparticulier.findByUsparPrenom", query = "SELECT u FROM Utilisateurparticulier u WHERE u.usparPrenom = :usparPrenom")
    , @NamedQuery(name = "Utilisateurparticulier.findByUsparNumeroTel", query = "SELECT u FROM Utilisateurparticulier u WHERE u.usparNumeroTel = :usparNumeroTel")
    , @NamedQuery(name = "Utilisateurparticulier.findByUsparMail", query = "SELECT u FROM Utilisateurparticulier u WHERE u.usparMail = :usparMail")
    , @NamedQuery(name = "Utilisateurparticulier.findByUsparMotPasse", query = "SELECT u FROM Utilisateurparticulier u WHERE u.usparMotPasse = :usparMotPasse")
    , @NamedQuery(name = "Utilisateurparticulier.findByUsparDate", query = "SELECT u FROM Utilisateurparticulier u WHERE u.usparDate = :usparDate")})
public class Utilisateurparticulier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uspar_id")
    private Integer usparId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "uspar_nom")
    private String usparNom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "uspar_prenom")
    private String usparPrenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "uspar_numero_tel")
    private String usparNumeroTel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "uspar_mail")
    private String usparMail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "uspar_mot_passe")
    private String usparMotPasse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uspar_date")
    @Temporal(TemporalType.DATE)
    private Date usparDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notusrPartid")
    private Collection<Notation> notationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resaUsparId")
    private Collection<Reservation> reservationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "histUserparId")
    private Collection<HistoriqueReservation> historiqueReservationCollection;

    public Utilisateurparticulier() {
    }

    public Utilisateurparticulier(Integer usparId) {
        this.usparId = usparId;
    }

    public Utilisateurparticulier(Integer usparId, String usparNom, String usparPrenom, String usparNumeroTel, String usparMail, String usparMotPasse, Date usparDate) {
        this.usparId = usparId;
        this.usparNom = usparNom;
        this.usparPrenom = usparPrenom;
        this.usparNumeroTel = usparNumeroTel;
        this.usparMail = usparMail;
        this.usparMotPasse = usparMotPasse;
        this.usparDate = usparDate;
    }

    public Integer getUsparId() {
        return usparId;
    }

    public void setUsparId(Integer usparId) {
        this.usparId = usparId;
    }

    public String getUsparNom() {
        return usparNom;
    }

    public void setUsparNom(String usparNom) {
        this.usparNom = usparNom;
    }

    public String getUsparPrenom() {
        return usparPrenom;
    }

    public void setUsparPrenom(String usparPrenom) {
        this.usparPrenom = usparPrenom;
    }

    public String getUsparNumeroTel() {
        return usparNumeroTel;
    }

    public void setUsparNumeroTel(String usparNumeroTel) {
        this.usparNumeroTel = usparNumeroTel;
    }

    public String getUsparMail() {
        return usparMail;
    }

    public void setUsparMail(String usparMail) {
        this.usparMail = usparMail;
    }

    public String getUsparMotPasse() {
        return usparMotPasse;
    }

    public void setUsparMotPasse(String usparMotPasse) {
        this.usparMotPasse = usparMotPasse;
    }

    public Date getUsparDate() {
        return usparDate;
    }

    public void setUsparDate(Date usparDate) {
        this.usparDate = usparDate;
    }

    @XmlTransient
    public Collection<Notation> getNotationCollection() {
        return notationCollection;
    }

    public void setNotationCollection(Collection<Notation> notationCollection) {
        this.notationCollection = notationCollection;
    }

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    @XmlTransient
    public Collection<HistoriqueReservation> getHistoriqueReservationCollection() {
        return historiqueReservationCollection;
    }

    public void setHistoriqueReservationCollection(Collection<HistoriqueReservation> historiqueReservationCollection) {
        this.historiqueReservationCollection = historiqueReservationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usparId != null ? usparId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateurparticulier)) {
            return false;
        }
        Utilisateurparticulier other = (Utilisateurparticulier) object;
        if ((this.usparId == null && other.usparId != null) || (this.usparId != null && !this.usparId.equals(other.usparId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dauphine.entity.Utilisateurparticulier[ usparId=" + usparId + " ]";
    }
    
}
