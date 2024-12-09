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


    }
}
