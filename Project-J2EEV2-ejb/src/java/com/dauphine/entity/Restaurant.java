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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "restaurant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restaurant.findAll", query = "SELECT r FROM Restaurant r")
    , @NamedQuery(name = "Restaurant.findByResId", query = "SELECT r FROM Restaurant r WHERE r.resId = :resId")
    , @NamedQuery(name = "Restaurant.findByResNom", query = "SELECT r FROM Restaurant r WHERE r.resNom = :resNom")
    , @NamedQuery(name = "Restaurant.findByResNbCouvert", query = "SELECT r FROM Restaurant r WHERE r.resNbCouvert = :resNbCouvert")
    , @NamedQuery(name = "Restaurant.findByResAdresse", query = "SELECT r FROM Restaurant r WHERE r.resAdresse = :resAdresse")
    , @NamedQuery(name = "Restaurant.findByResNumeroTel", query = "SELECT r FROM Restaurant r WHERE r.resNumeroTel = :resNumeroTel")
    , @NamedQuery(name = "Restaurant.findByResEmail", query = "SELECT r FROM Restaurant r WHERE r.resEmail = :resEmail")
    , @NamedQuery(name = "Restaurant.findByResCodePostal", query = "SELECT r FROM Restaurant r WHERE r.resCodePostal = :resCodePostal")
    , @NamedQuery(name = "Restaurant.findByResVille", query = "SELECT r FROM Restaurant r WHERE r.resVille = :resVille")
    , @NamedQuery(name = "Restaurant.findByResDateInscription", query = "SELECT r FROM Restaurant r WHERE r.resDateInscription = :resDateInscription")
    , @NamedQuery(name = "Restaurant.findByResNbImg", query = "SELECT r FROM Restaurant r WHERE r.resNbImg = :resNbImg")})
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "res_id")
    private Integer resId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "res_nom")
    private String resNom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "res_nb_couvert")
    private int resNbCouvert;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "res_adresse")
    private String resAdresse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "res_numero_tel")
    private int resNumeroTel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "res_email")
    private String resEmail;
    @Column(name = "res_code_postal")
    private Integer resCodePostal;
    @Size(max = 254)
    @Column(name = "res_ville")
    private String resVille;
    @Basic(optional = false)
    @NotNull
    @Column(name = "res_date_inscription")
    @Temporal(TemporalType.DATE)
    private Date resDateInscription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "res_nb_img")
    private int resNbImg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notRestoId")
    private Collection<Notation> notationCollection;
    @JoinColumn(name = "res_uspro_id", referencedColumnName = "uspro_id")
    @ManyToOne(optional = false)
    private UtilisateurProfessionnel resUsproId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuResId")
    private Collection<Menu> menuCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "histRestoId")
    private Collection<HistoriqueReservation> historiqueReservationCollection;

    public Restaurant() {
    }

    public Restaurant(Integer resId) {
        this.resId = resId;
    }

    public Restaurant(Integer resId, String resNom, int resNbCouvert, String resAdresse, int resNumeroTel, String resEmail, Date resDateInscription, int resNbImg) {
        this.resId = resId;
        this.resNom = resNom;
        this.resNbCouvert = resNbCouvert;
        this.resAdresse = resAdresse;
        this.resNumeroTel = resNumeroTel;
        this.resEmail = resEmail;
        this.resDateInscription = resDateInscription;
        this.resNbImg = resNbImg;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public String getResNom() {
        return resNom;
    }

    public void setResNom(String resNom) {
        this.resNom = resNom;
    }

    public int getResNbCouvert() {
        return resNbCouvert;
    }

    public void setResNbCouvert(int resNbCouvert) {
        this.resNbCouvert = resNbCouvert;
    }

    public String getResAdresse() {
        return resAdresse;
    }

    public void setResAdresse(String resAdresse) {
        this.resAdresse = resAdresse;
    }

    public int getResNumeroTel() {
        return resNumeroTel;
    }

    public void setResNumeroTel(int resNumeroTel) {
        this.resNumeroTel = resNumeroTel;
    }

    public String getResEmail() {
        return resEmail;
    }

    public void setResEmail(String resEmail) {
        this.resEmail = resEmail;
    }

    public Integer getResCodePostal() {
        return resCodePostal;
    }

    public void setResCodePostal(Integer resCodePostal) {
        this.resCodePostal = resCodePostal;
    }

    public String getResVille() {
        return resVille;
    }

    public void setResVille(String resVille) {
        this.resVille = resVille;
    }

    public Date getResDateInscription() {
        return resDateInscription;
    }

    public void setResDateInscription(Date resDateInscription) {
        this.resDateInscription = resDateInscription;
    }

    public int getResNbImg() {
        return resNbImg;
    }

    public void setResNbImg(int resNbImg) {
        this.resNbImg = resNbImg;
    }

    @XmlTransient
    public Collection<Notation> getNotationCollection() {
        return notationCollection;
    }

    public void setNotationCollection(Collection<Notation> notationCollection) {
        this.notationCollection = notationCollection;
    }

    public UtilisateurProfessionnel getResUsproId() {
        return resUsproId;
    }

    public void setResUsproId(UtilisateurProfessionnel resUsproId) {
        this.resUsproId = resUsproId;
    }

    @XmlTransient
    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
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
        hash += (resId != null ? resId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurant)) {
            return false;
        }
        Restaurant other = (Restaurant) object;
        if ((this.resId == null && other.resId != null) || (this.resId != null && !this.resId.equals(other.resId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dauphine.entity.Restaurant[ resId=" + resId + " ]";
    }
    
}
