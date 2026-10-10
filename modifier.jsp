<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier un patient</title>
</head>
<body>
    <fieldset>
        <legend>Modification d'un patient</legend>

        <c:if test="${not empty erreur}">
            <p style="color: red;">${erreur}</p>
        </c:if>

        <form action="PatientServlet" method="post">
            <input type="hidden" name="action" value="modifier">
            <input type="hidden" name="index" value="${index}">

            <p>
                <label for="nom">Nom :</label>
                <input type="text" id="nom" name="nom" value="${fn:escapeXml(patient.nom)}" required>
            </p>
            <p>
                <label for="prenom">Prénom :</label>
                <input type="text" id="prenom" name="prenom" value="${fn:escapeXml(patient.prenom)}" required>
            </p>
            <p>
                <label for="masse">Masse (kg) :</label>
                <input type="number" id="masse" name="masse" value="${patient.masse}"
                       step="0.1" min="1" required>
            </p>
            <p>
                <label for="taille">Taille (m) :</label>
                <input type="number" id="taille" name="taille" value="${patient.taille}"
                       step="0.01" min="0.3" max="2.5" required>
            </p>

            <button type="submit">Enregistrer</button>
            <a href="PatientServlet">Annuler</a>
        </form>
    </fieldset>
</body>
</html>