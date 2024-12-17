import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        // Instance de la classe joueur
        Joueur player_1 = new Joueur("Franck");

        // TEST : Initialiser des hypothèses
        player_1.guess = new int[]{1, 3, 5};
        player_1.displayGuesses();

        // Instance de la classe Cas1
        Cas1 cas_1 = new Cas1(4);
        Cas2 cas_2 = new Cas2(4);

        Cas3 cas_3 = new Cas3(5);
        Cas4 cas_4 = new Cas4(5);

        Cas5 cas_5 = new Cas5(6);
        Cas6 cas_6 = new Cas6(6);


        // Nombre de vérificateurs pour le test
        int choix_nb_verificateurs = 5;

        // Appeler randomChoice via l'instance de Joueur
        int scenarioChoisi = player_1.randomChoice(choix_nb_verificateurs);

        // Afficher les résultats
        System.out.println("Nb_verif scenar 1 : " + cas_1.nb_verificateurs);
        System.out.println("ID DU SCENAR 1 : " + cas_1.getID());

        cas_1.afficher_verificateurs();
        cas_2.afficher_verificateurs();
        cas_3.afficher_verificateurs();
        cas_4.afficher_verificateurs();
        cas_5.afficher_verificateurs();
        cas_6.afficher_verificateurs();


        // Récupérer le nom du joueur et l'afficher
        System.out.println(player_1.getName());

        // Afficher le scénario choisi
        System.out.println("Scénario choisi : " + scenarioChoisi);


        // Choisir un scénario aléatoire
        int choixNbVerificateurs = 4; // Exemple avec 4 vérificateurs
        scenarioChoisi = player_1.randomChoice(choixNbVerificateurs);

        // Sélectionner le scénario
        Scenarii scenario;
        switch (scenarioChoisi) {
            case 1:
                scenario = new Cas1(4);
                break;
            case 2:
                scenario = new Cas2(4);
                break;
            case 3:
                scenario = new Cas3(5);
                break;
            case 4:
                scenario = new Cas4(5);
                break;
            case 5:
                scenario = new Cas5(6);
                break;
            case 6:
                scenario = new Cas6(6);
                break;
            default:
                throw new IllegalArgumentException("Scénario invalide.");
        }

        // Lancer l'interface graphique avec le scénario sélectionné
        Scenarii finalScenario = scenario;
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Interface gameInterface = new Interface(finalScenario.verfificateurs, finalScenario.Final_answer);
                gameInterface.setVisible(true);
            }
        });




    }
}
