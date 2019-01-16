/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dauphine.bean;

import com.dauphine.entity.Utilisateurparticulier;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Stark
 */

@Remote
public interface IGestionUserParticulier {
    
    public void add(String nom, String prenom, String numTel, String email, String password);
    public List<Utilisateurparticulier> getUtilisateurByEmail(String email);
    
    
}
