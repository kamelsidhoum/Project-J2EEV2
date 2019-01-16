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
@Table(name = "utilisateurProfessionnel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UtilisateurProfessionnel.findAll", query = "SELECT u FROM UtilisateurProfessionnel u")
    , @NamedQuery(name = "UtilisateurProfessionnel.findByUsproId", query = "SELECT u FROM UtilisateurProfessionnel u WHERE u.usproId = :usproId")
    , @NamedQuery(name = "UtilisateurProfessionnel.findByUsproNom", query = "SELECT u FROM UtilisateurProfessionnel u WHERE u.usproNom = :usproNom")
    , @NamedQuery(name = "UtilisateurProfessionnel.findByUsproPrenom", query = "SELECT u FROM UtilisateurProfessionnel u WHERE u.usproPrenom = :usproPrenom")
    , @NamedQuery(name = "UtilisateurProfessionnel.findByUsproNumeroTel", query = "SELECT u FROM UtilisateurProfessionnel u WHERE u.usproNumeroTel = :usproNumeroTel")
    , @NamedQuery(name = "UtilisateurProfessionnel.findByUsproAdresse", query = "SELECT u FROM UtilisateurProfessionnel u WHERE u.usproAdresse = :usproAdresse")
    , @NamedQuery(name = "UtilisateurProfessionnel.findByUsproMail", query = "SELECT u FROM UtilisateurProfessionnel u WHERE u.usproMail = :usproMail")
    , @NamedQuery(name = "UtilisateurProfessionnel.findByUsproMotPasse", query = "SELECT u FROM UtilisateurProfessionnel u WHERE u.usproMotPasse = :usproMotPasse")
    , @NamedQuery(name = "UtilisateurProfessionnel.findByUsproDate", query = "SELECT u FROM UtilisateurProfessionnel u WHERE u.usproDate = :usproDate")
    , @NamedQuery(name = "UtilisateurProfessionnel.findByUsproSiret", query = "SELECT u FROM UtilisateurProfessionnel u WHERE u.usproSiret = :usproSiret")})
public class UtilisateurProfessionnel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uspro_id")
    private Integer usproId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "uspro_nom")
    private String usproNom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "uspro_prenom")
    private String usproPrenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "uspro_numero_tel")
    private String usproNumeroTel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "uspro_adresse")
    private String usproAdresse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "uspro_mail")
    private String usproMail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "uspro_mot_passe")
    private String usproMotPasse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uspro_date")
    @Temporal(TemporalType.DATE)
    private Date usproDate;
    @Size(max = 254)
    @Column(name = "uspro_siret")
    private String usproSiret;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "annUsproId")
    private Collection<Annonce> annonceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resUsproId")
    private Collection<Restaurant> restaurantCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "histUserproId")
    private Collection<HistoriqueReservation> historiqueReservationCollection;

    public UtilisateurProfessionnel() {
    }

    public UtilisateurProfessionnel(Integer usproId) {
        this.usproId = usproId;
    }

    public UtilisateurProfessionnel(Integer usproId, String usproNom, String usproPrenom, String usproNumeroTel, String usproAdresse, String usproMail, String usproMotPasse, Date usproDate) {
        this.usproId = usproId;
        this.usproNom = usproNom;
        this.usproPrenom = usproPrenom;
        this.usproNumeroTel = usproNumeroTel;
        this.usproAdresse = usproAdresse;
        this.usproMail = usproMail;
        this.usproMotPasse = usproMotPasse;
        this.usproDate = usproDate;
    }

    public Integer getUsproId() {
        return usproId;
    }

    public void setUsproId(Integer usproId) {
        this.usproId = usproId;
    }

    public String getUsproNom() {
        return usproNom;
    }

    public void setUsproNom(String usproNom) {
        this.usproNom = usproNom;
    }

    public String getUsproPrenom() {
        return usproPrenom;
    }

    public void setUsproPrenom(String usproPrenom) {
        this.usproPrenom = usproPrenom;
    }

    public String getUsproNumeroTel() {
        return usproNumeroTel;
    }

    public void setUsproNumeroTel(String usproNumeroTel) {
        this.usproNumeroTel = usproNumeroTel;
    }

    public String getUsproAdresse() {
        return usproAdresse;
    }

    public void setUsproAdresse(String usproAdresse) {
        this.usproAdresse = usproAdresse;
    }

    public String getUsproMail() {
        return usproMail;
    }

    public void setUsproMail(String usproMail) {
        this.usproMail = usproMail;
    }

    public String getUsproMotPasse() {
        return usproMotPasse;
    }

    public void setUsproMotPasse(String usproMotPasse) {
        this.usproMotPasse = usproMotPasse;
    }

    public Date getUsproDate() {
        return usproDate;
    }

    public void setUsproDate(Date usproDate) {
        this.usproDate = usproDate;
    }

    public String getUsproSiret() {
        return usproSiret;
    }

    public void setUsproSiret(String usproSiret) {
        this.usproSiret = usproSiret;
    }

    @XmlTransient
    public Collection<Annonce> getAnnonceCollection() {
        return annonceCollection;
    }

    public void setAnnonceCollection(Collection<Annonce> annonceCollection) {
        this.annonceCollection = annonceCollection;
    }

    @XmlTransient
    public Collection<Restaurant> getRestaurantCollection() {
        return restaurantCollection;
    }

    public void setRestaurantCollection(Collection<Restaurant> restaurantCollection) {
        this.restaurantCollection = restaurantCollection;
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
        hash += (usproId != null ? usproId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UtilisateurProfessionnel)) {
            return false;
        }
        UtilisateurProfessionnel other = (UtilisateurProfessionnel) object;
        if ((this.usproId == null && other.usproId != null) || (this.usproId != null && !this.usproId.equals(other.usproId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dauphine.entity.UtilisateurProfessionnel[ usproId=" + usproId + " ]";
    }
    
}
