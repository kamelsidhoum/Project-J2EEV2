/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dauphine.bean;


import com.dauphine.entity.Utilisateurparticulier;
import com.dauphine.bean.IGestionUserParticulier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Stark
 */
@Stateless
public class GestionUserParticulier implements IGestionUserParticulier{

    
    
    @PersistenceContext
    private EntityManager em;
    
    
    
    @Override
    public void add(String nom, String prenom, String numTel, String email, String password) {
        
        Utilisateurparticulier usrParticulier = new Utilisateurparticulier();


        usrParticulier.setUsparMail(email);
        usrParticulier.setUsparMotPasse(password);
        usrParticulier.setUsparNom(nom);
        usrParticulier.setUsparPrenom(prenom);
        usrParticulier.setUsparNumeroTel(numTel);
        Date date = new Date();
        usrParticulier.setUsparId(1);
        usrParticulier.setUsparDate(date);

        em.persist(usrParticulier);

    }

    

    // Add b0usiness logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Utilisateurparticulier> getUtilisateurByEmail(String email) {
        Query q = em.createNamedQuery("Utilisateurparticulier.findByUsparMail");
        q.setParameter("usparMail", email);
        return q.getResultList();    }
}
