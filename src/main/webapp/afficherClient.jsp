<%-- 
    Document   : afficherClient
    Created on : Feb 19, 2019, 1:17:46 PM
    Author     : dagy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Affichage d'un client</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>"/>
    </head>
    <body>
        <c:import url="/inc/menu.jsp"/>
        <div class="corps">
            <p class="info">${message}</p>
            <c:if test="${!erreur}">
                <p>Nom : <c:out value="client.nom"/></p>
                <p>Prenom : <c:out value="client.prenom"/></p>
                <p>Adresse : <c:out value="client.adresse"/></p>
                <p>Numero de telephone : <c:out value="client.telephone"/></p>
                <p>Email : <c:out value="client.email"/></p>
            </c:if>
        </div>
    </body>
</html>
