

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World");
        Joueur player_1 = new Joueur("Franck", 0);



        player_1.guess = new int[]{1, 3, 5};
        player_1.displayGuesses();

        Scenarii scenario_1 = new Scenarii();

        System.out.println("Nb_verif scenar 1 : " + scenario_1.nb_verificateurs);
        System.out.println("ID DU SCENAR 1 : " + scenario_1.getID());

        for (int i = 0; i < scenario_1.verfificateurs.length; i++) {
            System.out.println("Règle " + (i + 1) + " : " + scenario_1.verfificateurs[i]);
        }




        //récuperer le nom et l'afficher
        System.out.println(player_1.getName());



    }
}
