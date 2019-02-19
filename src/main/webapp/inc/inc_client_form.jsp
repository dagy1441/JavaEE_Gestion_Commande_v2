<%-- 
    Document   : inc_client_form
    Created on : Feb 19, 2019, 1:16:36 PM
    Author     : dagy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<label for="nomClient">Nom <span class="requis">*</span></label>
<input type="text" id="nomClient" name="nomClient" value="" size="30" maxlength="30"><br/>

<label for="prenomClient">prenom <span class="requis">*</span></label>
<input type="text" id="prenomClient" name="prenomClient" value="" size="30" maxlength="30"><br/>

<label for="adresseClient">Adresse de livraison <span class="requis">*</span></label>
<input type="text" id="adresseClient" name="adresseClient" value="" size="30" maxlength="30"><br/>

<label for="telephoneClient">Numeros de telephone <span class="requis">*</span></label>
<input type="text" id="telephoneClient" name="telephoneClient" value="" size="30" maxlength="30"><br/>

<label for="emailClient">Adresse email <span class="requis">*</span></label>
<input type="text" id="emailClient" name="emailClient" value="" size="30" maxlength="60"><br/>