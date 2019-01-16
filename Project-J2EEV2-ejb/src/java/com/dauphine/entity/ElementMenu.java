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
@Table(name = "elementMenu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ElementMenu.findAll", query = "SELECT e FROM ElementMenu e")
    , @NamedQuery(name = "ElementMenu.findByElemnId", query = "SELECT e FROM ElementMenu e WHERE e.elemnId = :elemnId")
    , @NamedQuery(name = "ElementMenu.findByElemnNom", query = "SELECT e FROM ElementMenu e WHERE e.elemnNom = :elemnNom")
    , @NamedQuery(name = "ElementMenu.findByElemnPrix", query = "SELECT e FROM ElementMenu e WHERE e.elemnPrix = :elemnPrix")
    , @NamedQuery(name = "ElementMenu.findByElemnDisponibilite", query = "SELECT e FROM ElementMenu e WHERE e.elemnDisponibilite = :elemnDisponibilite")
    , @NamedQuery(name = "ElementMenu.findByElemnDate", query = "SELECT e FROM ElementMenu e WHERE e.elemnDate = :elemnDate")})
public class ElementMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "elemn_id")
    private Integer elemnId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "elemn_nom")
    private String elemnNom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "elemn_prix")
    private double elemnPrix;
    @Basic(optional = false)
    @NotNull
    @Column(name = "elemn_disponibilite")
    private boolean elemnDisponibilite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "elemn_date")
    @Temporal(TemporalType.DATE)
    private Date elemnDate;
    @JoinColumn(name = "elemn_mn_id", referencedColumnName = "menu_id")
    @ManyToOne
    private Menu elemnMnId;
    @JoinColumn(name = "elemn_res_id", referencedColumnName = "resa_id")
    @ManyToOne(optional = false)
    private Reservation elemnResId;

    public ElementMenu() {
    }

    public ElementMenu(Integer elemnId) {
        this.elemnId = elemnId;
    }

    public ElementMenu(Integer elemnId, String elemnNom, double elemnPrix, boolean elemnDisponibilite, Date elemnDate) {
        this.elemnId = elemnId;
        this.elemnNom = elemnNom;
        this.elemnPrix = elemnPrix;
        this.elemnDisponibilite = elemnDisponibilite;
        this.elemnDate = elemnDate;
    }

    public Integer getElemnId() {
        return elemnId;
    }

    public void setElemnId(Integer elemnId) {
        this.elemnId = elemnId;
    }

    public String getElemnNom() {
        return elemnNom;
    }

    public void setElemnNom(String elemnNom) {
        this.elemnNom = elemnNom;
    }

    public double getElemnPrix() {
        return elemnPrix;
    }

    public void setElemnPrix(double elemnPrix) {
        this.elemnPrix = elemnPrix;
    }

    public boolean getElemnDisponibilite() {
        return elemnDisponibilite;
    }

    public void setElemnDisponibilite(boolean elemnDisponibilite) {
        this.elemnDisponibilite = elemnDisponibilite;
    }

    public Date getElemnDate() {
        return elemnDate;
    }

    public void setElemnDate(Date elemnDate) {
        this.elemnDate = elemnDate;
    }

    public Menu getElemnMnId() {
        return elemnMnId;
    }

    public void setElemnMnId(Menu elemnMnId) {
        this.elemnMnId = elemnMnId;
    }

    public Reservation getElemnResId() {
        return elemnResId;
    }

    public void setElemnResId(Reservation elemnResId) {
        this.elemnResId = elemnResId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (elemnId != null ? elemnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ElementMenu)) {
            return false;
        }
        ElementMenu other = (ElementMenu) object;
        if ((this.elemnId == null && other.elemnId != null) || (this.elemnId != null && !this.elemnId.equals(other.elemnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dauphine.entity.ElementMenu[ elemnId=" + elemnId + " ]";
    }
    
}
