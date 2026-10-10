package controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import modele.MonIMC;

@WebServlet("/PatientServlet")
public class PatientServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private List<MonIMC> listePatients;

    @Override
    public void init() throws ServletException {
        listePatients = new ArrayList<>();
        listePatients.add(creerPatient("DIOP", "Daouda", 70, 1.70));
        listePatients.add(creerPatient("SALL", "Moussa", 95, 1.75));
        listePatients.add(creerPatient("NDIAYE", "Awa", 50, 1.68));
    }

    // =============== Méthodes utilitaires ===============

    private MonIMC creerPatient(String nom, String prenom, double masse, double taille) {
        MonIMC patient = new MonIMC();
        patient.setNom(nom);
        patient.setPrenom(prenom);
        patient.setMasse(masse);
        patient.setTaille(taille);
        patient.calculer();
        return patient;
    }

    // Transforme un texte en nombre. Renvoie 0 si le texte est invalide.
    private double lireNombre(String texte) {
        try {
            return Double.parseDouble(texte.replace(',', '.'));
        } catch (Exception e) {
            return 0;
        }
    }

    // Lit le paramètre "index". Renvoie -1 s'il est absent ou hors de la liste.
    private int lireIndex(HttpServletRequest request) {
        try {
            int index = Integer.parseInt(request.getParameter("index"));
            if (index >= 0 && index < listePatients.size()) {
                return index;
            }
        } catch (Exception e) {
            // paramètre absent ou non numérique
        }
        return -1;
    }

    // =============== GET ===============

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("modifier".equals(action)) {
            afficherFormulaireModification(request, response);
        } else {
            request.setAttribute("patients", listePatients);
            request.getRequestDispatcher("/accueil.jsp").forward(request, response);
        }
    }

    private void afficherFormulaireModification(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int index = lireIndex(request);

        if (index == -1) {
            response.sendRedirect("PatientServlet");
            return;
        }

        request.setAttribute("patient", listePatients.get(index));
        request.setAttribute("index", index);
        request.getRequestDispatcher("/modifier.jsp").forward(request, response);
    }

    // =============== POST ===============

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        if ("supprimer".equals(action)) {
            supprimer(request, response);
        } else if ("modifier".equals(action)) {
            modifier(request, response);
        } else {
            ajouter(request, response);
        }
    }

    private void ajouter(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        double masse = lireNombre(request.getParameter("masse"));
        double taille = lireNombre(request.getParameter("taille"));

        if (masse <= 0 || taille <= 0) {
            request.setAttribute("erreur", "La masse et la taille doivent être des nombres positifs.");
            request.getRequestDispatcher("/new_patient.jsp").forward(request, response);
            return;
        }

        listePatients.add(creerPatient(nom, prenom, masse, taille));
        response.sendRedirect("PatientServlet");
    }

    private void supprimer(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int index = lireIndex(request);

        if (index != -1) {
            listePatients.remove(index);
        }

        response.sendRedirect("PatientServlet");
    }

    private void modifier(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Retrouver le patient grâce au champ caché "index"
        int index = lireIndex(request);

        if (index == -1) {
            response.sendRedirect("PatientServlet");
            return;
        }

        MonIMC patient = listePatients.get(index);

        // 2. Lire les nouvelles valeurs
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        double masse = lireNombre(request.getParameter("masse"));
        double taille = lireNombre(request.getParameter("taille"));

        // 3. Saisie invalide : retour au formulaire avec un message
        if (masse <= 0 || taille <= 0) {
            request.setAttribute("erreur", "La masse et la taille doivent être des nombres positifs.");
            request.setAttribute("patient", patient);
            request.setAttribute("index", index);
            request.getRequestDispatcher("/modifier.jsp").forward(request, response);
            return;
        }

        // 4. Mettre à jour le patient, puis recalculer
        patient.setNom(nom);
        patient.setPrenom(prenom);
        patient.setMasse(masse);
        patient.setTaille(taille);
        patient.calculer();

        // 5. Retour à la liste
        response.sendRedirect("PatientServlet");
    }
}