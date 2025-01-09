import java.util.Scanner;



public class Main {


    public static void main(String[] args) {

        //Instanciation du menu
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        // Initialisation du joueur
        System.out.println("Bienvenue dans le jeu Turing Machine !");
        System.out.print("Entrez votre nom : ");
        String playerName = scanner.nextLine();
        Joueur player_1 = new Joueur(playerName);

        // Demander le nombre de vérificateurs
        System.out.print("Entrez le nombre de vérificateurs (4, 5 ou 6) : ");
        int choixNbVerificateurs = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante

        // Sélectionner un scénario aléatoire
        Scenarii scenario = selectScenario(player_1, choixNbVerificateurs);

        System.out.println("\nScénario choisi :");
        scenario.afficher_verificateurs();

        // Gestion des tours
        int maxTurns = 10;
        boolean gameWon = false;

        for (int turn = 1; turn <= maxTurns; turn++) {
            System.out.println("\n--- Tour " + turn + " ---");
            System.out.println("Vous pouvez vérifier trois vérificateurs.");

            // Vérifications
            for (int i = 0; i < 3; i++) {
                int verifierIndex = -1;
                while (true) {
                    try {
                        System.out.print("Choisissez le numéro du vérificateur (1 à " + choixNbVerificateurs + ") : ");
                        verifierIndex = scanner.nextInt() - 1; // Convertir en index (0-based)

                        if (verifierIndex >= 0 && verifierIndex < choixNbVerificateurs) {
                            break; // Sortir de la boucle si l'entrée est valide
                        } else {
                            System.out.println("Erreur : Le numéro du vérificateur doit être entre 1 et " + choixNbVerificateurs + ".");
                        }
                    } catch (Exception e) {
                        System.out.println("Erreur : Entrée invalide. Veuillez entrer un nombre entre 1 et " + choixNbVerificateurs + ".");
                        scanner.nextLine(); // Consommer la ligne incorrecte
                    }
                }

                System.out.print("Entrez votre choix (A, B ou C) : ");
                String choice = scanner.next().toUpperCase();

                boolean isValid = scenario.validateVerifier(verifierIndex, choice);
                if (isValid) {
                    System.out.println("Vérificateur validé !");
                } else {
                    System.out.println("Choix incorrect.");
                }
            }

            // Demander au joueur s'il souhaite proposer une réponse finale
            String decision;
            while (true) {
                System.out.print("Voulez-vous proposer une réponse finale (O/N) ? ");
                decision = scanner.next().toUpperCase();
                if (decision.equals("O") || decision.equals("N")) {
                    break; // Réponse valide
                } else {
                    System.out.println("Erreur : Veuillez entrer 'O' pour Oui ou 'N' pour Non.");
                }
            }


            if (decision.equals("O")) {
                // Initialisation des guesses
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

                // Vérifier les réponses avec Final_answer
                if (scenario.validateGuess(playerGuess)) {
                    System.out.println("\nFélicitations ! Vous avez trouvé la réponse correcte !");
                    gameWon = true; // La partie est terminée
                    break; // Sortir de la boucle principale
                } else {
                    System.out.println("\nRéponse incorrecte. Continuez à jouer !");
                }
            }

            System.out.println("Fin du tour.");
        }


        // Fin de la partie
        if (!gameWon) {
            System.out.println("\nDommage, vous avez atteint le nombre maximum de tours.");
            System.out.println("La réponse correcte était :");
            for (String answer : scenario.Final_answer) {
                System.out.println("- " + answer);
            }
        }

        System.out.println("\nMerci d'avoir joué !");
        scanner.close();
    }


// Méthode pour sélectionner un scénario
private static Scenarii selectScenario(Joueur player, int choixNbVerificateurs) {
    int scenarioChoisi = player.randomChoice(choixNbVerificateurs);

    switch (scenarioChoisi) {
        case 1:
            return new Cas1(4);
        case 2:
            return new Cas2(4);
        case 3:
            return new Cas3(5);
        case 4:
            return new Cas4(5);
        case 5:
            return new Cas5(6);
        case 6:
            return new Cas6(6);
        default:
            throw new IllegalArgumentException("Scénario invalide.");
    }
}
}


