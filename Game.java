import java.util.List;

public class Game {

    // Champs privés
    private List<List<String>> joueurs;    // Liste des joueurs
    private int nombreVerificateurs;       // Nombre de vérificateurs
    private Scenarii scenario;             // Scénario actuel

    // Constructeur
    public Game(List<List<String>> joueurs, int nombreVerificateurs) {
        this.joueurs = joueurs;
        this.nombreVerificateurs = nombreVerificateurs;

        // Sélectionner un scénario pour le premier joueur
        Joueur firstPlayer = new Joueur(joueurs.get(0).get(1));
        this.scenario = Scenarii.selectScenario(firstPlayer, nombreVerificateurs);
    }

    // Getter sur le scénario, pour que le contrôleur puisse valider
    public Scenarii getScenario() {
        return scenario;
    }

    // Tu peux ajouter d'autres méthodes si nécessaires
    // Mais la logique de tours, testRestants, etc., est désormais dans GameController
}
