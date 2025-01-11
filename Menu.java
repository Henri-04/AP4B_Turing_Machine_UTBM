import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Menu (Vue du menu) dans le pattern MVC.
 * S'appuie sur un MenuController pour stocker/récupérer les données de configuration (joueurs, nb vérificateurs).
 */
public class Menu {
    private MenuController menuController; // Contrôleur du menu

    private JPanel nomsPanel;
    private JTextField[] nameFields;

    private JRadioButton verifButton4, verifButton5, verifButton6;
    private JFrame frame;

    // Constructeur de la classe Menu
    public Menu(MenuController menuController) {
        this.menuController = menuController;

        // -- Création et paramétrage de la fenêtre principale --
        frame = new JFrame("Menu - UTBMachine");
        frame.setSize(600, 500);  // Taille augmentée
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(230, 230, 230));

        // ----------------- Panneau du haut : message de bienvenue + bouton "Voir les règles" -----------------
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setOpaque(false);

        // Label de bienvenue
        JLabel welcomeLabel = new JLabel("Bienvenue sur le jeu UTBMachine !");
        welcomeLabel.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Bouton "Voir les règles"
        JButton voirReglesButton = new JButton("Voir les règles");
        voirReglesButton.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        voirReglesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Action du bouton "Voir les règles" : ouvrir une fenêtre affichant un texte explicatif
        voirReglesButton.addActionListener(e -> {
            JFrame rulesFrame = new JFrame("Règles du jeu");
            rulesFrame.setSize(1300, 600); // Grande taille pour y mettre un texte complet
            rulesFrame.setLocationRelativeTo(frame);

            String rulesText = "<html><div style='text-align: center;'>"
                    + "Bienvenue dans le jeu UTBMachine ! Voici une description des règles pour vous familiariser avec le jeu avant de commencer.<br><br>"
                    + "<b>But du jeu :</b><br>"
                    + "Votre objectif est de déterminer les informations sur la prochaine soirée UTBM, pour vous permettre d'y accéder en tant que VIP. "
                    + "En analysant les indices donnés par des vérificateurs, vous devrez déduire les réponses correctes pour trois éléments clés :<br>"
                    + "<ul>"
                    + "<li>Le lieu</li>"
                    + "<li>L’organisateur</li>"
                    + "<li>Le nombre d’invités</li>"
                    + "</ul>"
                    + "Puis, vous devrez formuler une hypothèse finale pour ces trois éléments.<br><br>"
                    + "<b>Règles et Conseils :</b><br><br>"
                    + "<b>- Limite de Tours :</b><br>"
                    + "Vous avez un nombre limité de 10 tours pour trouver la solution. Planifiez vos actions et utilisez les vérificateurs efficacement !<br><br>"
                    + "<b>- Indices en Cascade :</b><br>"
                    + "Les indices des vérificateurs peuvent être liés entre eux. Par exemple, un critère peut dépendre de votre hypothèse pour un autre élément.<br><br>"
                    + "<b>- Gagner ou Perdre :</b><br>"
                    + "Vous gagnez si votre hypothèse finale est correcte.<br>"
                    + "Si vous atteignez le dernier tour sans formuler la bonne hypothèse, la partie est perdue, et la solution vous sera révélée."
                    + "</div></html>";

            JLabel rulesLabel = new JLabel(rulesText, SwingConstants.CENTER);
            rulesLabel.setFont(new Font("Sans-Serif", Font.BOLD, 16));

            rulesFrame.add(rulesLabel, BorderLayout.CENTER);
            rulesFrame.setVisible(true);
        });

        // Ajout dans le topPanel
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(welcomeLabel);
        topPanel.add(Box.createVerticalStrut(5));
        topPanel.add(voirReglesButton);
        topPanel.add(Box.createVerticalStrut(10));

        // ----------------- Panneau central : Choix du nombre de joueurs, saisie des noms, choix vérificateurs -----------------
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 1, 5, 5));
        centerPanel.setOpaque(false);

        // 1) Panel pour le choix du nombre de joueurs
        JPanel radioPanel = new JPanel(new FlowLayout());
        radioPanel.setOpaque(false);
        JLabel label = new JLabel("Choix du nombre de joueurs :");
        label.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        label.setForeground(Color.BLACK);

        JRadioButton radioButton1 = new JRadioButton("1");
        JRadioButton radioButton2 = new JRadioButton("2");
        JRadioButton radioButton3 = new JRadioButton("3");
        JRadioButton radioButton4 = new JRadioButton("4");

        radioButton1.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        radioButton2.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        radioButton3.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        radioButton4.setFont(new Font("Sans-Serif", Font.PLAIN, 14));

        radioButton1.setForeground(Color.BLACK);
        radioButton2.setForeground(Color.BLACK);
        radioButton3.setForeground(Color.BLACK);
        radioButton4.setForeground(Color.BLACK);

        radioButton1.setOpaque(false);
        radioButton2.setOpaque(false);
        radioButton3.setOpaque(false);
        radioButton4.setOpaque(false);

        // Groupe pour n'en sélectionner qu'un
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        group.add(radioButton4);

        // Listener pour savoir combien de joueurs (donc combien de champs de nom)
        ActionListener updateNameFields = e -> {
            int count = Integer.parseInt(((JRadioButton) e.getSource()).getText());
            updateNameFields(count);
        };
        radioButton1.addActionListener(updateNameFields);
        radioButton2.addActionListener(updateNameFields);
        radioButton3.addActionListener(updateNameFields);
        radioButton4.addActionListener(updateNameFields);

        radioPanel.add(label);
        radioPanel.add(radioButton1);
        radioPanel.add(radioButton2);
        radioPanel.add(radioButton3);
        radioPanel.add(radioButton4);

        // 2) Panel pour les champs de noms (créés dynamiquement par updateNameFields)
        nomsPanel = new JPanel(new FlowLayout());
        nomsPanel.setOpaque(false);

        // 3) Panel pour le choix du nombre de vérificateurs
        JPanel verificateurPanel = new JPanel(new FlowLayout());
        verificateurPanel.setOpaque(false);

        JLabel verifLabel = new JLabel("Nombre de Vérificateurs :");
        verifLabel.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        verifLabel.setForeground(Color.BLACK);

        verifButton4 = new JRadioButton("4");
        verifButton5 = new JRadioButton("5");
        verifButton6 = new JRadioButton("6");

        verifButton4.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        verifButton5.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        verifButton6.setFont(new Font("Sans-Serif", Font.PLAIN, 14));

        verifButton4.setForeground(Color.BLACK);
        verifButton5.setForeground(Color.BLACK);
        verifButton6.setForeground(Color.BLACK);

        verifButton4.setBackground(new Color(255, 165, 0));
        verifButton5.setBackground(new Color(255, 165, 0));
        verifButton6.setBackground(new Color(255, 165, 0));

        ButtonGroup verifGroup = new ButtonGroup();
        verifGroup.add(verifButton4);
        verifGroup.add(verifButton5);
        verifGroup.add(verifButton6);

        verificateurPanel.add(verifLabel);
        verificateurPanel.add(verifButton4);
        verificateurPanel.add(verifButton5);
        verificateurPanel.add(verifButton6);

        // Ajout des 3 sous-panneaux dans le centerPanel
        centerPanel.add(radioPanel);
        centerPanel.add(nomsPanel);
        centerPanel.add(verificateurPanel);

        // ----------------- Panneau du bas : boutons Quitter et Lancer la partie -----------------
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);

        JButton quitButton = new JButton("Quitter");
        JButton startButton = new JButton("Lancer la partie");

        quitButton.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        startButton.setFont(new Font("Sans-Serif", Font.BOLD, 16));

        quitButton.setBackground(new Color(192, 192, 192));
        quitButton.setForeground(Color.BLACK);

        startButton.setBackground(new Color(135, 206, 250));
        startButton.setForeground(Color.BLACK);

        // Action pour quitter l'application
        quitButton.addActionListener(e -> System.exit(0));

        // Action pour lancer la partie
        startButton.addActionListener(e -> lancerPartie());

        buttonPanel.add(quitButton);
        buttonPanel.add(startButton);

        // ----------------- Insertion des différents panneaux dans la fenêtre -----------------
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Affiche la fenêtre
        frame.setVisible(true);
    }

    /**
     * Met à jour le panel des noms en fonction du nombre de joueurs.
     */
    private void updateNameFields(int count) {
        nomsPanel.removeAll();
        nameFields = new JTextField[count];

        for (int i = 0; i < count; i++) {
            JTextField field = new JTextField(10);
            field.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
            field.setBackground(new Color(135, 206, 250));
            field.setForeground(Color.BLACK);

            nameFields[i] = field;

            JLabel nameLabel = new JLabel("Joueur " + (i + 1) + ":");
            nameLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
            nameLabel.setForeground(Color.BLACK);

            nomsPanel.add(nameLabel);
            nomsPanel.add(field);
        }

        nomsPanel.revalidate();
        nomsPanel.repaint();
    }

    /**
     * Récupère les infos saisies (noms des joueurs, nb de vérificateurs)
     * et met à jour le MenuController, puis lance le plateau et les feuilles de notes.
     */
    private void lancerPartie() {
        // 1) Récupération des noms de joueurs
        List<List<String>> joueurs = new ArrayList<>();
        if (nameFields != null) {
            for (int i = 0; i < nameFields.length; i++) {
                List<String> joueur = new ArrayList<>();
                joueur.add(String.valueOf(i + 1));     // ID du joueur
                joueur.add(nameFields[i].getText());  // Nom du joueur
                joueurs.add(joueur);
            }
        }

        // 2) Acquisition du nombre de vérificateurs
        int nombreVerificateurs = 0;
        if (verifButton4.isSelected()) {
            nombreVerificateurs = 4;
        } else if (verifButton5.isSelected()) {
            nombreVerificateurs = 5;
        } else if (verifButton6.isSelected()) {
            nombreVerificateurs = 6;
        }

        // 3) Stocker ces données dans le MenuController
        menuController.setJoueurs(joueurs);
        menuController.setNombreVerificateurs(nombreVerificateurs);

        // 4) Fermer la fenêtre du menu
        frame.dispose();

        // 5) Lancer le plateau et les feuilles de notes
        lancerPlateauEtFeuilles(joueurs, nombreVerificateurs);
    }

    /**
     * Crée le Game, le GameController, le Plateau, et lance une FeuilleNotes pour chaque joueur.
     */
    private void lancerPlateauEtFeuilles(List<List<String>> joueurs, int nombreVerificateurs) {
        // 1) Créer le Game (modèle)
        Game game = new Game(joueurs, nombreVerificateurs);

        // 2) Créer le GameController (contrôleur)
        GameController gameController = new GameController(game, joueurs);

        // 3) Créer la vue Plateau
        new Plateau(gameController);

        // 4) Lancer une Feuille de Notes pour chaque joueur
        for (List<String> joueur : joueurs) {
            String nomJoueur = joueur.get(1);
            FeuilleNotes feuilleNotes = new FeuilleNotes(nomJoueur);
            feuilleNotes.setVisible(true);
        }
    }
}
