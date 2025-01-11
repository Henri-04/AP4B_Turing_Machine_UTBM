import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Instancier le contrôleur du menu
        MenuController menuController = new MenuController();

        // Ouvrir le menu (fenêtre)
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

        // Créer le "modèle" : Game
        Game game = new Game(joueurs, nombreVerificateurs);

        // Créer le "contrôleur" : GameController
        GameController gameController = new GameController(game, joueurs);

        // Créer la "vue" : Plateau (en lui passant le contrôleur)
        new Plateau(gameController);

        // *** Plus besoin d'appeler game.start(),
        //     car toute l’interface et la logique passent désormais
        //     par le Plateau + GameController.
    }
}
