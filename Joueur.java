public class Joueur {

    // Constructeur
    public Joueur(String name, int guess_per_turn)
    {
        this.name = name;           // Initialise le nom
        this.guess = new int[3]; // Initialise le tableau des suppositions avec une taille fixe de 3
        this.guess_per_turn = 0;
    }


    // Champs privés
    private String name; // Nom du joueur

    // Champs publics
    public int[] guess; // Tableau des suppositions du joueur (taille fixe de 3)
    private int guess_per_turn;



    // Getter pour le nom du joueur
    public String getName() {
        return name;
    }

    // Setter pour le nom du joueur
    public void setName(String name) {
        this.name = name;
    }

    // Méthode pour afficher les suppositions du joueur
    public void displayGuesses() {
        System.out.print("Guesses: ");
        for (int g : guess) {
            System.out.print(g + " ");
        }
        System.out.println();
    }
}
