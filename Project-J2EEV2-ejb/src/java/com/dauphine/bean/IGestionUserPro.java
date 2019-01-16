/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dauphine.bean;

import com.dauphine.entity.UtilisateurProfessionnel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Stark
 */
@Remote
public interface IGestionUserPro {
    public void add(String nom, String prenom, String numTel,String adresse, String mail, String mdp, String siret);
    public List<UtilisateurProfessionnel> getUserProByEmail(String email);
}
