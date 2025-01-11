import java.util.List;

public class GameController {

    private Game game;                    // Le "Modèle"
    private List<List<String>> joueurs;   // La liste des joueurs (vient du menu)
    private int currentPlayerIndex;       // Index du joueur courant
    private int currentTurn;              // Tour courant
    private int testRestantsParTour;      // Nombre de tests autorisés par tour (ex. 3)

    public GameController(Game game, List<List<String>> joueurs) {
        this.game = game;                        // Le modèle (contient le scénario)
        this.joueurs = joueurs;                  // Noms des joueurs
        this.currentPlayerIndex = 0;             // Commence au joueur 0
        this.currentTurn = 1;                    // Tour n°1
        this.testRestantsParTour = 3;            // Exemple : 3 tests par tour
    }

    // --- Getters pour la Vue (Plateau) --- //

    /** Retourne le texte de chaque vérificateur (pour l'affichage). */
    public String[] getVerificateursText() {
        return game.getScenario().verfificateurs;
    }

    /** Retourne le nom du joueur courant. */
    public String getCurrentPlayerName() {
        return joueurs.get(currentPlayerIndex).get(1);
    }

    /** Retourne le numéro du tour courant. */
    public int getCurrentTurn() {
        return currentTurn;
    }

    /** Retourne combien de tests il reste (par tour) */
    public int getTestRestantsParTour() {
        return testRestantsParTour;
    }

    // --- Méthodes appelées par la Vue (Plateau) --- //

    /**
     * Méthode appelée quand on clique sur "Tester vérificateur".
     * @param verifierIndex index du vérificateur sélectionné
     * @param choice 'A', 'B' ou 'C'
     * @return true si c'est le bon choix, false sinon
     */
    public boolean testVerifier(int verifierIndex, String choice) {
        boolean isValid = game.getScenario().validateVerifier(verifierIndex, choice);

        // Gérer la décrémentation des tests restants pour ce tour
        testRestantsParTour--;
        if (testRestantsParTour <= 0) {
            passerAuProchainJoueur();
        }

        return isValid;
    }

    /**
     * Méthode appelée quand on clique sur "Tester code final" (lieu, orga, effectif).
     * @param guess tableau {lieu, organisateur, effectif}
     * @return true si code final correct, false sinon
     */
    public boolean testFinalCode(String[] guess) {
        boolean correct = game.getScenario().validateGuess(guess);
        if (correct) {
            // Le joueur gagne. (Dans l'exemple, on ferme le jeu côté Vue.)
            return true;
        } else {
            // Code incorrect => on passe au prochain joueur + prochain tour si nécessaire
            testRestantsParTour = testRestantsParTour - 1;
            if (testRestantsParTour <= 0) {
                passerAuProchainJoueur();
            }
            return false;
        }
    }

    // --- Logique d'enchaînement de tours et joueurs --- //

    private void passerAuProchainJoueur() {
        // Réinitialiser testRestantsParTour à 3 pour le nouveau joueur
        this.testRestantsParTour = 3;

        // Passer au joueur suivant
        currentPlayerIndex = (currentPlayerIndex + 1) % joueurs.size();

        // Si on revient au joueur 0, c'est qu'un nouveau tour commence
        if (currentPlayerIndex == 0) {
            currentTurn++;
        }
    }
}
