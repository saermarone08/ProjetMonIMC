package modele;

import java.io.Serializable;

public class MonIMC implements Serializable {

    private static final long serialVersionUID = 1L;

    // ----- Attributs privés -----
    private String nom;
    private String prenom;
    private String interpretation;
    private double masse;   // en kilogrammes
    private double taille;  // en mètres
    private double imc;

    // ----- Constructeur sans argument -----
    public MonIMC() {
    }

    // ----- Méthode de calcul -----
    public void calculer() {
        // Sécurité : on ne divise jamais par zéro
        if (taille <= 0) {
            imc = 0;
            interpretation = "Taille invalide";
            return;
        }

        // Formule : masse / taille²
        double resultat = masse / (taille * taille);

        // Arrondi à 2 chiffres après la virgule
        imc = Math.round(resultat * 100.0) / 100.0;

        // Choix de la catégorie
        if (imc < 18.5) {
            interpretation = "Insuffisance pondérale";
        } else if (imc < 25) {
            interpretation = "Corpulence normale";
        } else if (imc < 30) {
            interpretation = "Surpoids";
        } else if (imc < 35) {
            interpretation = "Obésité modérée";
        } else if (imc < 40) {
            interpretation = "Obésité sévère";
        } else {
            interpretation = "Obésité morbide";
        }
    }

    // ----- Getters et setters -----
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getMasse() {
        return masse;
    }

    public void setMasse(double masse) {
        this.masse = masse;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }
}