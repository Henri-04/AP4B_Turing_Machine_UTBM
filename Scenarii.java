import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
abstract public class Scenarii {

    // Incrémentation de l'id commune à toutes les classes
    static int ID_COUNTER = 0;

    // PRIVATE
    private int id;


    // PROTECTED
    protected String[] verfificateurs;  // Vérificateurs mélangés
    protected String[] correctChoices; // Réponses correctes après mélange
    protected String[] Final_answer;   // Réponses finales attenduesègle 1", "Regle 2",..., "Règle n"}

    // PUBLIC
    public int nb_verificateurs;

    // {"Axone", "AE", "150"}

    // TEST
    public int getID() {
        return this.id;
    }

    // Constructeur
    public Scenarii(int nb_verificateurs) {
        this.id = ++ID_COUNTER;
        this.nb_verificateurs = nb_verificateurs;
        this.verfificateurs = new String[nb_verificateurs]; // Initialisation avec la taille spécifiée
        this.Final_answer = new String[nb_verificateurs];
    }
    // Melanger les critères

    public Map<String, String> melangerCritèresEtReponses(String verificateur, String correctChoice) {
        String[] lignes = verificateur.split("\n");
        List<String> liste = new ArrayList<>(List.of(lignes));
        Collections.shuffle(liste); // Mélange des critères

        // Réattribuer les identifiants (A, B, C)
        StringBuilder verificateurMélangé = new StringBuilder();
        Map<String, String> critèreEtRéponse = new HashMap<>();
        char identifiant = 'A';
        for (String ligne : liste) {
            verificateurMélangé.append("• Critère ").append(identifiant).append(" : ").append(ligne.substring(ligne.indexOf(':') + 2)).append("\n");

            // Si cette ligne contenait la réponse correcte, mettre à jour le mapping
            if (ligne.contains(correctChoice)) {
                critèreEtRéponse.put("correctChoice", String.valueOf(identifiant));
            }
            identifiant++;
        }

        critèreEtRéponse.put("verificateur", verificateurMélangé.toString().trim());
        return critèreEtRéponse;
    }



    // Méthode pour valider une hypothèse
    public boolean validateGuess(String[] playerGuess) {
        for (int i = 0; i < Final_answer.length; i++) {
            if (!Final_answer[i].equals(playerGuess[i])) {
                return false; // Une des hypothèses est incorrecte
            }
        }
        return true; // Toutes les hypothèses sont correctes
    }

    // Méthode pour afficher tous les vérificateurs
    public void afficher_verificateurs() {
        for (int i = 0; i < this.verfificateurs.length; i++) {
            System.out.println("Règle " + (i + 1) + " :\n" + this.verfificateurs[i]);
        }
    }
    // Méthode pour valider un vérificateur
    public boolean validateVerifier(int verifierIndex, String choice) {
        if (verifierIndex < 0 || verifierIndex >= verfificateurs.length) {
            System.out.println("Vérificateur invalide !");
            return false;
        }

        // Récupérer le vérificateur et le critère correspondant au choix
        String verifier = verfificateurs[verifierIndex];
        String correctChoice = getCorrectChoice(verifierIndex);

        // Vérifier si le choix du joueur correspond à la réponse attendue
        return choice.equalsIgnoreCase(correctChoice);
    }
    // Méthode pour récupérer la réponse correcte d'un vérificateur
    private String getCorrectChoice(int verifierIndex) {
        switch (verifierIndex) {
            case 0: return "B"; // Exemple : réponse correcte pour le vérificateur 1
            case 1: return "A"; // Exemple : réponse correcte pour le vérificateur 2
            case 2: return "C"; // Exemple : réponse correcte pour le vérificateur 3
            case 3: return "A"; // Exemple : réponse correcte pour le vérificateur 4
            case 4: return "B"; // Exemple : réponse correcte pour le vérificateur 5
            default: throw new IllegalArgumentException("Index du vérificateur invalide.");
        }
    }

}


