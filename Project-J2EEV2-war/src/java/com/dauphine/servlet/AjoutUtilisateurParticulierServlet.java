/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dauphine.servlet;

import com.dauphine.bean.IGestionUserParticulier;
import java.io.IOException;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Stark
 */
public class AjoutUtilisateurParticulierServlet extends HttpServlet {

    @EJB
    IGestionUserParticulier gestUser;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String mail = request.getParameter("email");
            String mdp = request.getParameter("mdp");
            String numTel = request.getParameter("phone");

            System.out.println("-------------------------->" + nom + " " + prenom + " " + mail + " " + mdp + " " + numTel);
            
            gestUser.add(nom, prenom, numTel, mail, prenom);
            }
        catch(EJBException e){
             @SuppressWarnings("ThrowableResultIgnored")
        Exception cause = e.getCausedByException();
        if (cause instanceof ConstraintViolationException) {
            @SuppressWarnings("ThrowableResultIgnored")
            ConstraintViolationException cve = (ConstraintViolationException) e.getCausedByException();
            for (Iterator<ConstraintViolation<?>> it = cve.getConstraintViolations().iterator(); it.hasNext();) {
                ConstraintViolation<? extends Object> v = it.next();
                System.err.println(v);
                System.err.println("==>>"+v.getMessage());
            }
        }
        }
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

}
