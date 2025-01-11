import java.util.ArrayList;
import java.util.List;

/**
 * Contrôleur du menu (pattern MVC) :
 * stocke et expose la liste des joueurs et le nombre de vérificateurs choisis.
 */
public class MenuController {

    private List<List<String>> joueurs; // Liste des joueurs
    private int nombreVerificateurs;   // Nombre de vérificateurs

    public MenuController() {
        joueurs = new ArrayList<>();
        nombreVerificateurs = 0;
    }

    // Méthode pour définir les joueurs
    public void setJoueurs(List<List<String>> joueurs) {
        this.joueurs = joueurs;
    }

    // Méthode pour récupérer la liste de joueurs
    public List<List<String>> getJoueurs() {
        return joueurs;
    }

    // Méthode pour définir le nombre de vérificateurs
    public void setNombreVerificateurs(int nombreVerificateurs) {
        this.nombreVerificateurs = nombreVerificateurs;
    }

    // Méthode pour récupérer le nombre de vérificateurs
    public int getNombreVerificateurs() {
        return nombreVerificateurs;
    }
}
