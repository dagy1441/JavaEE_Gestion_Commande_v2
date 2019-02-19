/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openclass.gestcom.servlets;

import com.openclass.gestcom.beans.Client;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dagy
 */
public class CreationClient extends HttpServlet {
/** Declaration des constantes**/
    public static final String CHAMP_NOM              = "nomClient";
    public static final String CHAMP_PRENOM           = "prenomClient";
    public static final String CHAMP_ADRESSE          = "adresseClient";
    public static final String CHAMP_TELEPHONE        = "telephoneClient";
    public static final String CHAMP_EMAIL            = "emailClient";
    
    public static final String ATTRIB_CLIENT          = "client";
    public static final String ATTRIB_MESSAGE         = "message";
    public static final String ATTRIB_ERREUR          = "erreur";
    
    public static final String VUE                    = "/afficherClient.jsp";
       
    /**
     * Redefinition de la methode doGet
     * @param request, 
     * @param response,
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     **/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     /**Recuperation des donnees saisies, envoyees en tant que parametres de 
      * la requete GET generee a la validation du formulaire
      **/
     String nom = request.getParameter(CHAMP_NOM);
     String prenom = request.getParameter(CHAMP_PRENOM);
     String adresse = request.getParameter(CHAMP_ADRESSE);
     String telephone = request.getParameter(CHAMP_TELEPHONE);
     String email = request.getParameter(CHAMP_EMAIL);
     
     String message;
     boolean erreur;
     
     /** 
      * Initialisation du message a afficher : si un des champs obligatoire
      * du formulaire n'est pas renseigne, alors on affiche un message d'erreur,
      * sinon on affiche un message de succes
      **/
        if (nom.trim().isEmpty() || prenom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty() || email.trim().isEmpty()) {
            message = "Erreur vous n'avez pas rempli tous les champs obligatoires.<br><a href=\"creerClient.jsp\">"
                    + "Cliquez ici</a> pour acceder au formulaire de creation d'un client.";
            erreur = true;
        } else {
            message = "Client cree avec succes !";
            erreur = false;
        }
     
        /**Creation du bean client et initialisation avec les donnees recuperees**/
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setAdresse(adresse);
        client.setTelephone(telephone);
        client.setEmail(email);
        
        /**Ajout du bean Client et du message a l'objet request**/
        request.setAttribute(ATTRIB_CLIENT, client);
        request.setAttribute(ATTRIB_MESSAGE, message);
        request.setAttribute(ATTRIB_ERREUR, erreur);
        
        /**Transmission a la page JSP en charge de l'affichage des donnees**/
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
