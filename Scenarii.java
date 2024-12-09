abstract public class Scenarii {

    // Incrémentation de l'id commune à toutes les classes
    static int ID_COUNTER = 0;

    // PRIVATE
    private int id;

    // PROTECTED
    protected String[] verfificateurs;
    // {"Règle 1", "Regle 2",..., "Règle n"}

    // PUBLIC
    public int nb_verificateurs;
    public String[] Final_answer;
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

    // Méthode pour afficher les vérificateurs
    public void afficher_verificateurs() {
        for (int i = 0; i < this.verfificateurs.length; i++) {
            System.out.println("Règle " + (i + 1) + " :\n" + this.verfificateurs[i]);
        }
    }
}
