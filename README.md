# ProjetMonIMC — Application web J2EE

## 1. Présentation du projet

ProjetMonIMC est une application web développée en Java EE permettant
de gérer une liste de patients et de calculer automatiquement leur
Indice de Masse Corporelle (IMC).

L'application permet à l'utilisateur d'effectuer des opérations
de gestion des patients depuis une interface web.

## 2. Objectifs du projet

- Mettre en pratique la programmation Java côté serveur.
- Comprendre le fonctionnement des Servlets et des JSP.
- Développer une application web dynamique.
- Calculer l'Indice de Masse Corporelle.
- Réaliser les opérations de gestion des patients.

## 3. Technologies utilisées

- Java
- Java EE / Jakarta EE
- Servlets
- JSP (JavaServer Pages)
- HTML et CSS
- Apache Tomcat
- Eclipse IDE

## 4. Fonctionnalités

- Affichage de la liste des patients.
- Ajout d'un nouveau patient.
- Modification des informations d'un patient.
- Suppression d'un patient.
- Calcul de l'IMC à partir du poids et de la taille.

## 5. Formule de calcul de l'IMC

IMC = Poids (kg) / Taille² (m)

## 6. Principaux fichiers

- `MonIMC.java` : classe Java de calcul ou de gestion de l'IMC.
- `PatientServlet.java` : traitement des requêtes web.
- `accueil.jsp` : interface d'accueil.
- `new_patient.jsp` : formulaire de création d'un patient.
- `modifier.jsp` : formulaire de modification d'un patient.
- `style.css` : mise en forme de l'interface.
- `web.xml` : configuration de l'application web.

## 7. Installation et exécution

1. Cloner ou télécharger le dépôt GitHub.
2. Importer le projet dans Eclipse.
3. Vérifier la configuration du serveur Apache Tomcat.
4. Configurer les dépendances nécessaires.
5. Déployer l'application sur Tomcat.
6. Ouvrir l'application dans un navigateur.

Les étapes exactes dépendent de la structure du projet et
de la version de Java EE ou Jakarta EE utilisée.

## 8. Auteur

Projet réalisé dans le cadre d'un apprentissage de J2EE.

## 9. Dépôt GitHub

https://github.com/saermarone08/ProjetMonIMC
