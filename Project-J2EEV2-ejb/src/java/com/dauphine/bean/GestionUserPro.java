/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dauphine.bean;

import com.dauphine.entity.UtilisateurProfessionnel;
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
public class GestionUserPro implements IGestionUserPro {

    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void add(String nom, String prenom, String numTel, String adresse, String mail, String mdp, String siret) {
        UtilisateurProfessionnel userPro = new UtilisateurProfessionnel();
        
        userPro.setUsproNom(nom);
        userPro.setUsproPrenom(prenom);
        userPro.setUsproNumeroTel(numTel);
        userPro.setUsproSiret(siret);
        userPro.setUsproDate(new Date());
        userPro.setUsproMotPasse(mdp);
        userPro.setUsproMail(mail);
        userPro.setUsproAdresse(adresse);
        
        em.persist(userPro);
    }

    @Override
    public List<UtilisateurProfessionnel> getUserProByEmail(String email) {
        Query q = em.createNamedQuery("UtilisateurProfessionnel.findByUsparMail");
        q.setParameter("usparMail", email);
        return q.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
