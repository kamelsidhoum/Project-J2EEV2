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
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
    , @NamedQuery(name = "Menu.findByMenuId", query = "SELECT m FROM Menu m WHERE m.menuId = :menuId")
    , @NamedQuery(name = "Menu.findByMenuDateCreation", query = "SELECT m FROM Menu m WHERE m.menuDateCreation = :menuDateCreation")
    , @NamedQuery(name = "Menu.findByMenuDisponible", query = "SELECT m FROM Menu m WHERE m.menuDisponible = :menuDisponible")
    , @NamedQuery(name = "Menu.findByMenuPrix", query = "SELECT m FROM Menu m WHERE m.menuPrix = :menuPrix")
    , @NamedQuery(name = "Menu.findByMenuReduction", query = "SELECT m FROM Menu m WHERE m.menuReduction = :menuReduction")
    , @NamedQuery(name = "Menu.findByMenuNom", query = "SELECT m FROM Menu m WHERE m.menuNom = :menuNom")
    , @NamedQuery(name = "Menu.findByMenuAnnId", query = "SELECT m FROM Menu m WHERE m.menuAnnId = :menuAnnId")
    , @NamedQuery(name = "Menu.findByMenuDateAjout", query = "SELECT m FROM Menu m WHERE m.menuDateAjout = :menuDateAjout")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "menu_id")
    private Integer menuId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "menu_date_creation")
    @Temporal(TemporalType.DATE)
    private Date menuDateCreation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "menu_disponible")
    private boolean menuDisponible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "menu_prix")
    private double menuPrix;
    @Column(name = "menu_reduction")
    private Integer menuReduction;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "menu_nom")
    private String menuNom;
    @Column(name = "menu_ann_id")
    private Integer menuAnnId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "menu_date_ajout")
    @Temporal(TemporalType.DATE)
    private Date menuDateAjout;
    @OneToMany(mappedBy = "elemnMnId")
    private Collection<ElementMenu> elementMenuCollection;
    @JoinColumn(name = "menu_res_id", referencedColumnName = "res_id")
    @ManyToOne(optional = false)
    private Restaurant menuResId;

    public Menu() {
    }

    public Menu(Integer menuId) {
        this.menuId = menuId;
    }

    public Menu(Integer menuId, Date menuDateCreation, boolean menuDisponible, double menuPrix, String menuNom, Date menuDateAjout) {
        this.menuId = menuId;
        this.menuDateCreation = menuDateCreation;
        this.menuDisponible = menuDisponible;
        this.menuPrix = menuPrix;
        this.menuNom = menuNom;
        this.menuDateAjout = menuDateAjout;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Date getMenuDateCreation() {
        return menuDateCreation;
    }

    public void setMenuDateCreation(Date menuDateCreation) {
        this.menuDateCreation = menuDateCreation;
    }

    public boolean getMenuDisponible() {
        return menuDisponible;
    }

    public void setMenuDisponible(boolean menuDisponible) {
        this.menuDisponible = menuDisponible;
    }

    public double getMenuPrix() {
        return menuPrix;
    }

    public void setMenuPrix(double menuPrix) {
        this.menuPrix = menuPrix;
    }

    public Integer getMenuReduction() {
        return menuReduction;
    }

    public void setMenuReduction(Integer menuReduction) {
        this.menuReduction = menuReduction;
    }

    public String getMenuNom() {
        return menuNom;
    }

    public void setMenuNom(String menuNom) {
        this.menuNom = menuNom;
    }

    public Integer getMenuAnnId() {
        return menuAnnId;
    }

    public void setMenuAnnId(Integer menuAnnId) {
        this.menuAnnId = menuAnnId;
    }

    public Date getMenuDateAjout() {
        return menuDateAjout;
    }

    public void setMenuDateAjout(Date menuDateAjout) {
        this.menuDateAjout = menuDateAjout;
    }

    @XmlTransient
    public Collection<ElementMenu> getElementMenuCollection() {
        return elementMenuCollection;
    }

    public void setElementMenuCollection(Collection<ElementMenu> elementMenuCollection) {
        this.elementMenuCollection = elementMenuCollection;
    }

    public Restaurant getMenuResId() {
        return menuResId;
    }

    public void setMenuResId(Restaurant menuResId) {
        this.menuResId = menuResId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuId != null ? menuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.menuId == null && other.menuId != null) || (this.menuId != null && !this.menuId.equals(other.menuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dauphine.entity.Menu[ menuId=" + menuId + " ]";
    }
    
}
