<%-- 
    Document   : afficherCommande
    Created on : Feb 19, 2019, 1:18:05 PM
    Author     : dagy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Affichage d'une commande</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>"/>
    </head>
    <body>
        <c:import url="/inc/menu.jsp"/>
        <div class="corps">
            <p class="info">${message}</p>
            <c:if test="${!erreur}">
                <p>Client</p>
                <p>Nom : <c:out value="commande.client.nom"/></p>
                <p>Prenom : <c:out value="commande.client.prenom"/></p>
                <p>Adresse : <c:out value="commande.client.adresse"/></p>
                <p>Numero de telephone : <c:out value="commande.client.telephone"/></p>
                <p>Email : <c:out value="commande.client.email"/></p>
                <p>Commande</p>
                <p>Date : <c:out value="commande.date"/></p>
                <p>Montant : <c:out value="commande.montant"/></p>
                <p>Mode de paiement : <c:out value="commande.modePaiement"/></p>
                <p>Statut du paiement : <c:out value="commande.statutPaiement"/></p>
                <p>Mode de Livraison : <c:out value="commande.modeLivraison"/></p>
                <p>Statut de la Livraison : <c:out value="commande.statutLivraison"/></p>
            </c:if>
        </div>
    </body>
</html>
