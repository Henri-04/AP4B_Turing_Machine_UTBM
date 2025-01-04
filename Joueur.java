
import java.util.Random;

public class Joueur {


    private String name;
    private int guess_this_turn;
    public int[] guess; // Tableau des hypothèses du joueur

    // Constructeur
    public Joueur(String name) {
        this.name = name;
        this.guess = new int[3];
        this.guess_this_turn = 0;
    }

    // Méthode pour récupérer le nom du joueur
    public String getName() {
        return name;
    }

    // Méthode pour afficher les hypothèses
    public void displayGuesses() {
        System.out.print("Hypothèses du joueur : ");
        for (int g : guess) {
            System.out.print(g + " ");
        }
        System.out.println();
    }

    // Méthode pour choisir un scénario aléatoire
    public int randomChoice(int choix_nb_verificateurs) {
        Random random = new Random();

        // Choisir en fonction du nombre de vérificateurs
        if (choix_nb_verificateurs == 4) {
            return random.nextInt(2) + 1; // Génère 1 ou 2
        } else if (choix_nb_verificateurs == 5) {
            return random.nextInt(2) + 3; // Génère 3 ou 4
        } else if (choix_nb_verificateurs == 6) {
            return random.nextInt(2) + 5; // Génère 5 ou 6
        } else {
            throw new IllegalArgumentException("Nombre de vérificateurs invalide : " + choix_nb_verificateurs);
        }
    }
}
