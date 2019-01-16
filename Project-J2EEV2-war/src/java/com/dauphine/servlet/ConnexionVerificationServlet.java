/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dauphine.servlet;

import com.dauphine.bean.IGestionUserParticulier;
import com.dauphine.bean.IGestionUserPro;
import com.dauphine.entity.UtilisateurProfessionnel;
import com.dauphine.entity.Utilisateurparticulier;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Stark
 */
public class ConnexionVerificationServlet extends HttpServlet {

    @EJB
    IGestionUserParticulier gestUserPart;
    
    @EJB
    IGestionUserPro gestUserPro;
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");
        String type = request.getParameter("type");
        
        if(email != null && mdp != null){
            if(type.contains("client")){
                if(validationEmail(email)){
                    
                }
            }
        }
        else{
            if(email != null){
                 response.setContentType("application/json");
                 PrintWriter out = response.getWriter();
                 List<?> listUser;
                 JsonObjectBuilder json;
                if(type.contains("client")){
                    listUser = getUtilisateurparticulierByMail(email);
                }
                else{
                    listUser = getUtilisateurProByMail(email);
                }
                if(listUser.size() >= 1 ){
                    json = Json.createObjectBuilder().add("verification", "true");
                }
                else{
                    json = Json.createObjectBuilder().add("verification", "false");                    
                }
                out.print(json);
            }
        }
    }

    public List<Utilisateurparticulier> getUtilisateurparticulierByMail(String email){
        return gestUserPart.getUtilisateurByEmail(email);    
    }
  
    public List<UtilisateurProfessionnel> getUtilisateurProByMail(String email){
        return gestUserPro.getUserProByEmail(email);
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    /** 
     * Code emprunté sur OpenClassRoom
    *  Valide l'email saisi 
    */
    private boolean validationEmail( String email ){
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            return false;
        }
        return true;
    }

    /**
     * Code emprunté sur OpenClassRoom
     * Valide le mot de passe saisi.
     */
    private boolean validationMotDePasse( String motDePasse){
        if ( motDePasse != null ) {
            if ( motDePasse.length() < 3 ) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
    
    
    
}
