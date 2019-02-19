/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openclass.gestcom.servlets;

import com.openclass.gestcom.beans.Client;
import com.openclass.gestcom.beans.Commande;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author dagy
 */
public class CreationCommande extends HttpServlet {

    /**
     * Declaration des constantes*
     */
    public static final String CHAMP_NOM = "nomClient";
    public static final String CHAMP_PRENOM = "prenomClient";
    public static final String CHAMP_ADRESSE = "adresseClient";
    public static final String CHAMP_TELEPHONE = "telephoneClient";
    public static final String CHAMP_EMAIL = "emailClient";
    public static final String CHAMP_DATE = "dateCommande";
    public static final String CHAMP_MONTANT = "montantCommande";
    public static final String CHAMP_MODE_PAIEMENT = "modePaiementCommande";
    public static final String CHAMP_STATUT_PAIEMENT = "statutPaiementCommande";
    public static final String CHAMP_MODE_LIVRAISON = "modeLivraisonCommande";
    public static final String CHAMP_STATUT_LIVRAISON = "statutLivraisonCommande";

    public static final String ATTRIB_COMMANDE = "commande";
    public static final String ATTRIB_MESSAGE = "message";
    public static final String ATTRIB_ERREUR = "erreur";

    public static final String FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";

    public static final String VUE = "/afficherCommande.jsp";

    /**
     *
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * Recuperation des donnees saisies, envoyees en tant que parametres de
         * la requete GET generee a la validation du formulaire
         *
         */
        String nom = request.getParameter(CHAMP_NOM);
        String prenom = request.getParameter(CHAMP_PRENOM);
        String adresse = request.getParameter(CHAMP_ADRESSE);
        String telephone = request.getParameter(CHAMP_TELEPHONE);
        String email = request.getParameter(CHAMP_EMAIL);

        /**
         * Recuperation de la date courrante*
         */
        DateTime dt = new DateTime();
        /**
         * Conversion de la date en String selon le format choisir*
         */
        DateTimeFormatter formatter = DateTimeFormat.forPattern(FORMAT_DATE);
        //Conversion de la date 
        String date = dt.toString(formatter);

        /**
         * Recuperation du montant*
         */
        double montant;
        try {
            montant = Double.parseDouble(request.getParameter(CHAMP_MONTANT));
        } catch (NumberFormatException e) {
            /**
             * Initialisation a -1 si le montant n'est pas un nombre correct*
             */
            montant = -1;
        }

        String modePaiement = request.getParameter(CHAMP_MODE_PAIEMENT);
        String statutPaiement = request.getParameter(CHAMP_STATUT_PAIEMENT);
        String modeLivraison = request.getParameter(CHAMP_MODE_LIVRAISON);
        String statutLivraison = request.getParameter(CHAMP_STATUT_LIVRAISON);

        String message;
        boolean erreur;

        /**
         * Initialisation du message a afficher : si un des champs obligatoire
         * du formulaire n'est pas renseigne, alors on affiche un message
         * d'erreur, sinon on affiche un message de succes
      *
         */
        if (nom.trim().isEmpty() || prenom.trim().isEmpty() || adresse.trim().isEmpty()
                || telephone.trim().isEmpty() || email.trim().isEmpty() || montant == -1
                || modePaiement.isEmpty() || modeLivraison.isEmpty()) {
            message = "Erreur vous n'avez pas rempli tous les champs obligatoires.<br><a href=\"creerCommande.jsp\">"
                    + "Cliquez ici</a> pour acceder au formulaire de creation d'une commande.";
            erreur = true;
        } else {
            message = "Commande cree avec succes !";
            erreur = false;
        }

        /**
         * Creation du bean client et initialisation avec les donnees recuperees*
         */
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setAdresse(adresse);
        client.setTelephone(telephone);
        client.setEmail(email);

        Commande commande = new Commande();
        commande.setClient(client);
        commande.setDate(date);
        commande.setMontant(montant);
        commande.setModePaiement(modePaiement);
        commande.setStatutPaiement(statutPaiement);
        commande.setModeLivraison(modeLivraison);
        commande.setStatutLivraison(statutLivraison);

        /**
         * Ajout du bean Client et du message a l'objet request*
         */
        request.setAttribute(ATTRIB_COMMANDE, commande);
        request.setAttribute(ATTRIB_MESSAGE, message);
        request.setAttribute(ATTRIB_ERREUR, erreur);

        /**
         * Transmission a la page JSP en charge de l'affichage des donnees*
         */
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    /**
     *
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
