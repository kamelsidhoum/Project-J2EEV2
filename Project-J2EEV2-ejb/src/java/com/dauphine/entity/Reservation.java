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
@Table(name = "reservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r")
    , @NamedQuery(name = "Reservation.findByResaId", query = "SELECT r FROM Reservation r WHERE r.resaId = :resaId")
    , @NamedQuery(name = "Reservation.findByResaDate", query = "SELECT r FROM Reservation r WHERE r.resaDate = :resaDate")
    , @NamedQuery(name = "Reservation.findByResaHoraire", query = "SELECT r FROM Reservation r WHERE r.resaHoraire = :resaHoraire")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "resa_id")
    private Integer resaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resa_date")
    @Temporal(TemporalType.DATE)
    private Date resaDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "resa_horaire")
    private String resaHoraire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "annResId")
    private Collection<Annonce> annonceCollection;
    @JoinColumn(name = "resa_uspar_id", referencedColumnName = "uspar_id")
    @ManyToOne(optional = false)
    private Utilisateurparticulier resaUsparId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "elemnResId")
    private Collection<ElementMenu> elementMenuCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "histResaId")
    private Collection<HistoriqueReservation> historiqueReservationCollection;

    public Reservation() {
    }

    public Reservation(Integer resaId) {
        this.resaId = resaId;
    }

    public Reservation(Integer resaId, Date resaDate, String resaHoraire) {
        this.resaId = resaId;
        this.resaDate = resaDate;
        this.resaHoraire = resaHoraire;
    }

    public Integer getResaId() {
        return resaId;
    }

    public void setResaId(Integer resaId) {
        this.resaId = resaId;
    }

    public Date getResaDate() {
        return resaDate;
    }

    public void setResaDate(Date resaDate) {
        this.resaDate = resaDate;
    }

    public String getResaHoraire() {
        return resaHoraire;
    }

    public void setResaHoraire(String resaHoraire) {
        this.resaHoraire = resaHoraire;
    }

    @XmlTransient
    public Collection<Annonce> getAnnonceCollection() {
        return annonceCollection;
    }

    public void setAnnonceCollection(Collection<Annonce> annonceCollection) {
        this.annonceCollection = annonceCollection;
    }

    public Utilisateurparticulier getResaUsparId() {
        return resaUsparId;
    }

    public void setResaUsparId(Utilisateurparticulier resaUsparId) {
        this.resaUsparId = resaUsparId;
    }

    @XmlTransient
    public Collection<ElementMenu> getElementMenuCollection() {
        return elementMenuCollection;
    }

    public void setElementMenuCollection(Collection<ElementMenu> elementMenuCollection) {
        this.elementMenuCollection = elementMenuCollection;
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
        hash += (resaId != null ? resaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.resaId == null && other.resaId != null) || (this.resaId != null && !this.resaId.equals(other.resaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dauphine.entity.Reservation[ resaId=" + resaId + " ]";
    }
    
}
