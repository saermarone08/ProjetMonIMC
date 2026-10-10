<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1>Liste des patients</h1>

    <table>
        <thead>
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Masse (kg)</th>
                <th>Taille (m)</th>
                <th>IMC</th>
                <th>Interprétation</th>
                <th>Opérations</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="patient" items="${patients}" varStatus="statut">
                <tr>
                    <td><c:out value="${patient.nom}"/></td>
                    <td><c:out value="${patient.prenom}"/></td>
                    <td><fmt:formatNumber value="${patient.masse}" maxFractionDigits="1"/></td>
                    <td><fmt:formatNumber value="${patient.taille}" minFractionDigits="2" maxFractionDigits="2"/></td>
                    <td><fmt:formatNumber value="${patient.imc}" minFractionDigits="2" maxFractionDigits="2"/></td>
                    <td class="${patient.imc >= 18.5 and patient.imc < 25 ? 'normal' : 'alerte'}">
                        ${patient.interpretation}
                    </td>
                    <td>
                        <a class="bouton" href="PatientServlet?action=modifier&index=${statut.index}">Modifier</a>

                        <form action="PatientServlet" method="post" style="display: inline;">
                            <input type="hidden" name="action" value="supprimer">
                            <input type="hidden" name="index" value="${statut.index}">
                            <button type="submit" class="bouton bouton-danger"
                                    onclick="return confirm('Supprimer ce patient ?');">Supprimer</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>

            <c:if test="${empty patients}">
                <tr>
                    <td colspan="7">Aucun patient enregistré.</td>
                </tr>
            </c:if>
        </tbody>
    </table>

    <p><a class="bouton" href="new_patient.jsp">Ajouter un patient</a></p>
</body>
</html>