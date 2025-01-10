import java.util.List;
import java.util.Scanner;

public class Game {

    // Champs privés
    private int currentTour; // Tour actuel
    private final int maxTurns = 10; // Nombre maximum de tours
    private List<List<String>> joueurs; // Liste des joueurs
    private int nombreVerificateurs; // Nombre de vérificateurs
    private Scenarii scenario; // Scénario actuel
    private boolean gameWon; // État de la partie (gagnée ou non)

    // Constructeur
    public Game(List<List<String>> joueurs, int nombreVerificateurs) {
        this.joueurs = joueurs;
        this.nombreVerificateurs = nombreVerificateurs;
        this.currentTour = 1; // Commence au tour 1
        this.gameWon = false;

        // Sélectionner un scénario pour le premier joueur
        Joueur firstPlayer = new Joueur(joueurs.get(0).get(1));
        this.scenario = Scenarii.selectScenario(firstPlayer, nombreVerificateurs);
    }

    // Méthode pour lancer la partie
    public void start() {
        System.out.println("\nScénario choisi :");
        scenario.afficher_verificateurs();

        Scanner scanner = new Scanner(System.in);

        // Boucle principale de la partie
        while (!gameWon && currentTour <= maxTurns) {
            System.out.println("\n--- Tour " + currentTour + " ---");
            System.out.println("Vous pouvez vérifier trois vérificateurs.");

            // Vérifications
            for (int i = 0; i < 3; i++) {
                int verifierIndex = selectVerifier(scanner);
                String choice = getVerifierChoice(scanner);

                boolean isValid = scenario.validateVerifier(verifierIndex, choice);
                if (isValid) {
                    System.out.println("Vérificateur validé !");
                } else {
                    System.out.println("Choix incorrect.");
                }
            }

            // Demander si le joueur veut proposer une réponse finale
            if (promptFinalGuess(scanner)) {
                break; // Quitter la boucle principale si le jeu est gagné
            }

            nextTurn();
        }

        endGame();
        scanner.close();
    }

    // Sélectionner un vérificateur
    private int selectVerifier(Scanner scanner) {
        int verifierIndex = -1;
        while (true) {
            try {
                System.out.print("Choisissez le numéro du vérificateur (1 à " + nombreVerificateurs + ") : ");
                verifierIndex = scanner.nextInt() - 1;

                if (verifierIndex >= 0 && verifierIndex < nombreVerificateurs) {
                    break;
                } else {
                    System.out.println("Erreur : Le numéro du vérificateur doit être entre 1 et " + nombreVerificateurs + ".");
                }
            } catch (Exception e) {
                System.out.println("Erreur : Entrée invalide. Veuillez entrer un nombre entre 1 et " + nombreVerificateurs + ".");
                scanner.nextLine(); // Consommer la ligne incorrecte
            }
        }
        return verifierIndex;
    }

    // Obtenir le choix du vérificateur
    private String getVerifierChoice(Scanner scanner) {
        System.out.print("Entrez votre choix (A, B ou C) : ");
        return scanner.next().toUpperCase();
    }

    // Demander une hypothèse finale
    private boolean promptFinalGuess(Scanner scanner) {
        String decision;
        while (true) {
            System.out.print("Voulez-vous proposer une réponse finale (O/N) ? ");
            decision = scanner.next().toUpperCase();
            if (decision.equals("O") || decision.equals("N")) {
                break;
            } else {
                System.out.println("Erreur : Veuillez entrer 'O' pour Oui ou 'N' pour Non.");
            }
        }

        if (decision.equals("O")) {
            return validateFinalGuess(scanner);
        }
        return false;
    }

    // Valider une hypothèse finale
    private boolean validateFinalGuess(Scanner scanner) {
        String[] playerGuess = new String[3];

        // Demander le lieu
        System.out.print("Lieu (Axone, Foyer Belfort, MDE Sevenans, La Poudrière, Foyer Montbéliard) : ");
        playerGuess[0] = scanner.nextLine();
        playerGuess[0] = scanner.nextLine();

        // Demander l'organisateur
        System.out.print("Organisateur (AE, SkiUT, BDS, CrunchTime, Gala) : ");
        playerGuess[1] = scanner.nextLine();

        // Demander le nombre d'invités
        System.out.print("Nombre d'invités (30, 75, 120, 200, 350) : ");
        playerGuess[2] = scanner.nextLine();

        if (scenario.validateGuess(playerGuess)) {
            System.out.println("\nFélicitations ! Vous avez trouvé la réponse correcte !");
            gameWon = true;
            return true;
        } else {
            System.out.println("\nRéponse incorrecte. Continuez à jouer !");
        }
        return false;
    }

    // Passer au tour suivant
    private void nextTurn() {
        if (currentTour < maxTurns) {
            currentTour++;
        } else {
            System.out.println("\nDommage, vous avez atteint le nombre maximum de tours.");
        }
    }

    // Fin de la partie
    private void endGame() {
        if (!gameWon) {
            System.out.println("\nDommage, vous avez atteint le nombre maximum de tours.");
            System.out.println("La réponse correcte était :");
            for (String answer : scenario.Final_answer) {
                System.out.println("- " + answer);
            }
        }
        System.out.println("\nMerci d'avoir joué !");
    }
}
