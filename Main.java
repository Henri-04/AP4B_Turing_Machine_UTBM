import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Instancier le contrôleur du menu
        MenuController menuController = new MenuController();

        // Ouvrir le menu
        new Menu(menuController);

        // Attendre que les données soient disponibles dans le MenuController
        while (menuController.getJoueurs().isEmpty() || menuController.getNombreVerificateurs() == 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Récupérer les données depuis le MenuController
        List<List<String>> joueurs = menuController.getJoueurs();
        int nombreVerificateurs = menuController.getNombreVerificateurs();

        // Créer une instance de Game et lancer la partie
        Game game = new Game(joueurs, nombreVerificateurs);
        game.start();


    }
}
