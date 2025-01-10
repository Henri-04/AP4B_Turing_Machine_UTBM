import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Menu {
    private MenuController menuController; // Référence au MenuController
    private JPanel nomsPanel;
    private JTextField[] nameFields;
    private JRadioButton verifButton4, verifButton5, verifButton6;
    private JFrame frame;

    // Constructeur de la classe Menu
    public Menu(MenuController menuController) {
        this.menuController = menuController;

        // -- Création et paramétrage de la fenêtre principale --
        frame = new JFrame("Menu - Turing Machine");
        frame.setSize(600, 500);  // Taille augmentée pour tout afficher aisément
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(230, 230, 230));

        // ----------------- Panneau du haut : message de bienvenue + bouton "Voir les règles" -----------------
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setOpaque(false);

        // Label de bienvenue
        JLabel welcomeLabel = new JLabel("Bienvenue sur le jeu Machine de Turbergue !");
        welcomeLabel.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Bouton "Voir les règles"
        JButton voirReglesButton = new JButton("Voir les règles");
        voirReglesButton.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        voirReglesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Action du bouton "Voir les règles"
        voirReglesButton.addActionListener(e -> {
            // Créer une grande fenêtre pour afficher les règles
            JFrame rulesFrame = new JFrame("Règles du jeu");
            rulesFrame.setSize(600, 400); // Taille assez grande pour y mettre les règles
            rulesFrame.setLocationRelativeTo(frame); // S'ouvre centrée par rapport au menu

            // Pour l'instant, un label générique
            JLabel rulesLabel = new JLabel("Voici les règles", SwingConstants.CENTER);
            rulesLabel.setFont(new Font("Sans-Serif", Font.BOLD, 16));

            // On ajoute ce label dans la fenêtre
            rulesFrame.add(rulesLabel, BorderLayout.CENTER);

            // Rendre visible
            rulesFrame.setVisible(true);
        });

        // Ajout au topPanel
        topPanel.add(Box.createVerticalStrut(10));  // Marges
        topPanel.add(welcomeLabel);
        topPanel.add(Box.createVerticalStrut(5));
        topPanel.add(voirReglesButton);
        topPanel.add(Box.createVerticalStrut(10));

        // ----------------- Panneau central : Choix du nombre de joueurs, saisie des noms, choix verificateurs -----------------
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 1, 5, 5));
        centerPanel.setOpaque(false);

        // 1) Panel du choix du nombre de joueurs
        JPanel radioPanel = new JPanel(new FlowLayout());
        radioPanel.setOpaque(false);
        JLabel label = new JLabel("Choix du nombre de joueurs :");
        label.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        label.setForeground(Color.BLACK);

        JRadioButton radioButton1 = new JRadioButton("1");
        JRadioButton radioButton2 = new JRadioButton("2");
        JRadioButton radioButton3 = new JRadioButton("3");
        JRadioButton radioButton4 = new JRadioButton("4");

        // Personnalisation visuelle
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

        // Grouper les boutons radio
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        group.add(radioButton4);

        // Listener pour savoir combien de champs nom afficher
        ActionListener updateNameFields = e -> {
            int count = Integer.parseInt(((JRadioButton) e.getSource()).getText());
            updateNameFields(count);
        };
        radioButton1.addActionListener(updateNameFields);
        radioButton2.addActionListener(updateNameFields);
        radioButton3.addActionListener(updateNameFields);
        radioButton4.addActionListener(updateNameFields);

        // Ajout au panel
        radioPanel.add(label);
        radioPanel.add(radioButton1);
        radioPanel.add(radioButton2);
        radioPanel.add(radioButton3);
        radioPanel.add(radioButton4);

        // 2) Panel pour les champs de noms
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

        verifButton4.setBackground(new Color(255, 165, 0)); // Orange
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

        // On ajoute ces 3 sous-panneaux dans le centerPanel
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

        quitButton.setBackground(new Color(192, 192, 192)); // Gris clair
        quitButton.setForeground(Color.BLACK);

        startButton.setBackground(new Color(135, 206, 250)); // Bleu ciel
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

    // Méthode pour mettre à jour les champs de texte en fonction du nombre de joueurs
    private void updateNameFields(int count) {
        nomsPanel.removeAll();  // Nettoie les anciens champs
        nameFields = new JTextField[count];

        for (int i = 0; i < count; i++) {
            JTextField field = new JTextField(10);  // Largeur de 10 colonnes
            field.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
            field.setBackground(new Color(135, 206, 250)); // Bleu ciel
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

    // Méthode pour lancer la partie et transmettre les données au MenuController
    private void lancerPartie() {
        // Récupération des noms de joueurs
        List<List<String>> joueurs = new ArrayList<>();
        for (int i = 0; i < nameFields.length; i++) {
            List<String> joueur = new ArrayList<>();
            joueur.add(String.valueOf(i + 1));     // ID du joueur
            joueur.add(nameFields[i].getText());  // Nom du joueur
            joueurs.add(joueur);
        }

        // Acquisition du nombre de vérificateurs
        int nombreVerificateurs = verifButton4.isSelected() ? 4 :
                verifButton5.isSelected() ? 5 : 6;

        // Transmettre les données au MenuController
        menuController.setJoueurs(joueurs);
        menuController.setNombreVerificateurs(nombreVerificateurs);

        // Fermer le menu
        frame.dispose();

        // Lancer les interfaces Plateau et Feuille de Notes
        lancerPlateauEtFeuilles(joueurs, nombreVerificateurs);
    }

    // Méthode pour lancer le Plateau et les Feuilles de Notes
    private void lancerPlateauEtFeuilles(List<List<String>> joueurs, int nombreVerificateurs) {
        // 1) Créer le Game
        Game game = new Game(joueurs, nombreVerificateurs);

        // 2) Récupérer le scénario
        Scenarii scenario = game.getScenario();

        // 3) Appeler le constructeur de Plateau avec scenario
        Plateau plateau = new Plateau(joueurs, nombreVerificateurs, scenario);

        // 4) Lancer une Feuille de Notes pour chaque joueur
        for (List<String> joueur : joueurs) {
            String nomJoueur = joueur.get(1);
            FeuilleNotes feuilleNotes = new FeuilleNotes(nomJoueur, 1);
            feuilleNotes.setVisible(true);
        }
    }
}
