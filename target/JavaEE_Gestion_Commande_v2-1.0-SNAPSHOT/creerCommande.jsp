<%-- 
    Document   : creerCommande
    Created on : Feb 19, 2019, 1:18:52 PM
    Author     : dagy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creation d'une commande</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <body>
        <c:import url="/inc/menu.jsp" />
        <div>
            <form method="get" action="<c:url value="/creationCommande"/>" >
                <fieldset>
                  <legend>Information du Client</legend>
                  <c:import url="/inc/inc_client_form.jsp"/>
                </fieldset>  
                <fieldset>
                    <legend>Information Commande</legend>
                    <label for="dateCommande">Date <span class="requis">*</span></label>
                    <input type="text" id="dateCommande" name="dateCommande" value="" size="30" maxlength="30" disabled><br/>

                    <label for="montantCommande">Montant <span class="requis">*</span></label>
                    <input type="text" id="montantCommande" name="montantCommande" value="" size="30" maxlength="30"><br/>

                    <label for="modePaiementCommande">Mode de paiement <span class="requis">*</span></label>
                    <input type="text" id="modePaiementCommande" name="modePaiementCommande" value="" size="30" maxlength="30"><br/>

                    <label for="statutPaiementCommande">Statut du Paiement<span class="requis">*</span></label>
                    <input type="text" id="statutPaiementCommande" name="statutPaiementCommande" value="" size="30" maxlength="30"><br/>

                    <label for="modeLivraisonCommande">mode de Livraison <span class="requis">*</span></label>
                    <input type="text" id="modeLivraisonCommande" name="modeLivraisonCommande" value="" size="30" maxlength="30"><br/>
                    
                    <label for="statutLivraisonCommande">statut de la Livraison <span class="requis">*</span></label>
                    <input type="text" id="statutLivraisonCommande" name="statutLivraisonCommande" value="" size="30" maxlength="30"><br/>
                    
                </fieldset>
                <input type="submit" value="Valider"/>
                <input type="reset" value="Remetre a zero" /> <br/>
            </form>
        </div>
    </body>
</html>
