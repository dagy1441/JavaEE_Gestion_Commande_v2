<%-- 
    Document   : menu
    Created on : Feb 19, 2019, 1:16:53 PM
    Author     : dagy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="menu">
    <p><a href="<c:url value="/creerClient.jsp"/>">Creer un nouveau client</a></p>
    <p><a href="<c:url value="/creerCommande.jsp"/>">Creer une nouvelle Commande</a></p>
</div>