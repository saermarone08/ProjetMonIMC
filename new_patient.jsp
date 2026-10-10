<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouveau patient</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <fieldset>
        <legend>Création d'un patient</legend>

        <c:if test="${not empty erreur}">
            <p style="color: red;">${erreur}</p>
        </c:if>

        <form class="fiche" action="PatientServlet" method="post">
        <input type="hidden" name="action" value="ajouter">
            <p>
                <label for="nom">Nom :</label>
                <input type="text" id="nom" name="nom" required>
            </p>
            <p>
                <label for="prenom">Prénom :</label>
                <input type="text" id="prenom" name="prenom" required>
            </p>
            <p>
                <label for="masse">Masse (kg) :</label>
                <input type="number" id="masse" name="masse"
                       step="0.1" min="1" required>
            </p>
            <p>
                <label for="taille">Taille (m) :</label>
                <input type="number" id="taille" name="taille"
                       step="0.01" min="0.3" max="2.5" required>
            </p>

            <button type="submit" class="bouton">Enregistrer</button>
            <button type="reset" class="bouton bouton-gris">Réinitialiser</button>
            <a class="bouton bouton-gris" href="PatientServlet">Annuler</a>
        </form>
    </fieldset>
</body>
</html>