public class Game {

    // Champs privés
    private int scenario; // scénario
    private int currentTour; // Représente le tour actuel
    private Joueur player;   // Le joueur actuel

    // Constructeur
    public Game(Joueur joueur) {
        this.player = joueur;  // Initialise le joueur
        this.scenario = 0;  //
        this.currentTour = 0;  // Initialise le tour actuel

    }
}
