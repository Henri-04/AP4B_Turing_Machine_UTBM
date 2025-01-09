import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    private JPanel nomsPanel;
    private JTextField[] nameFields;
    private JRadioButton verifButton4, verifButton5, verifButton6;
    private JFrame frame;

    // Constructeur de la classe Menu
    public Menu() {

        // Crée une fenêtre (JFrame)
        frame = new JFrame("Menu - Turing Machine");
        frame.setSize(450, 350);  // Taille ajustée
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Fermer l'application en cliquant sur la croix
        frame.setLayout(new BorderLayout());

        // Crée un panneau pour organiser les composants
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));  // 3 lignes

        // Crée un label
        JLabel label = new JLabel("Choix du nombre de joueurs :");
        label.setFont(new Font("Sans-Serif", Font.BOLD, 14));

        // Crée des boutons radio pour le choix du nombre de joueurs
        JRadioButton radioButton1 = new JRadioButton("1");
        JRadioButton radioButton2 = new JRadioButton("2");
        JRadioButton radioButton3 = new JRadioButton("3");
        JRadioButton radioButton4 = new JRadioButton("4");

        radioButton1.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        radioButton2.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        radioButton3.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        radioButton4.setFont(new Font("Sans-Serif", Font.PLAIN, 14));

        // Grouper les boutons radio pour que seulement un soit sélectionné à la fois
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        group.add(radioButton4);

        // Panel horizontal pour les boutons radio
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new FlowLayout());  // Affiche les boutons en ligne
        radioPanel.add(label);
        radioPanel.add(radioButton1);
        radioPanel.add(radioButton2);
        radioPanel.add(radioButton3);
        radioPanel.add(radioButton4);

        // Ajoute des ActionListeners pour mettre à jour les champs de noms
        ActionListener updateNameFields = e -> {
            int count = Integer.parseInt(((JRadioButton) e.getSource()).getText());
            updateNameFields(count);
        };

        radioButton1.addActionListener(updateNameFields);
        radioButton2.addActionListener(updateNameFields);
        radioButton3.addActionListener(updateNameFields);
        radioButton4.addActionListener(updateNameFields);

        // Panneau pour les champs de texte des noms
        nomsPanel = new JPanel();
        nomsPanel.setLayout(new FlowLayout());  // Champs de texte en ligne

        // Crée un panneau pour le choix du nombre de vérificateurs
        JPanel verificateurPanel = new JPanel();
        verificateurPanel.setLayout(new FlowLayout());
        JLabel verifLabel = new JLabel("Nombre de Vérificateurs :");
        verifLabel.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        verifButton4 = new JRadioButton("4");
        verifButton5 = new JRadioButton("5");
        verifButton6 = new JRadioButton("6");

        verifButton4.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        verifButton5.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        verifButton6.setFont(new Font("Sans-Serif", Font.PLAIN, 14));

        ButtonGroup verifGroup = new ButtonGroup();
        verifGroup.add(verifButton4);
        verifGroup.add(verifButton5);
        verifGroup.add(verifButton6);

        verificateurPanel.add(verifLabel);
        verificateurPanel.add(verifButton4);
        verificateurPanel.add(verifButton5);
        verificateurPanel.add(verifButton6);

        // Panneau pour les boutons Quitter et Lancer la partie
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton quitButton = new JButton("Quitter");
        JButton startButton = new JButton("Lancer la partie");

        quitButton.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        startButton.setFont(new Font("Sans-Serif", Font.BOLD, 16));

        // Action pour quitter l'application
        quitButton.addActionListener(e -> System.exit(0));

        // Action pour lancer la partie
        startButton.addActionListener(e -> lancerPartie());

        buttonPanel.add(quitButton);
        buttonPanel.add(startButton);

        // Ajoute les panneaux à la fenêtre
        panel.add(radioPanel);
        panel.add(nomsPanel);
        panel.add(verificateurPanel);

        frame.add(panel, BorderLayout.CENTER);
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
            nameFields[i] = field;
            nomsPanel.add(new JLabel("Joueur " + (i + 1) + ":")).setFont(new Font("Sans-Serif", Font.PLAIN, 14));
            nomsPanel.add(field);
        }

        nomsPanel.revalidate();
        nomsPanel.repaint();
    }

    // Méthode pour lancer la partie et transmettre les données
    private void lancerPartie() {
        List<List<String>> joueurs = new ArrayList<>();
        for (int i = 0; i < nameFields.length; i++) {
            List<String> joueur = new ArrayList<>();
            joueur.add(String.valueOf(i + 1));
            joueur.add(nameFields[i].getText());
            joueurs.add(joueur);
        }

        //Acquisition du nombre de vérificateurs
        int nombreVerificateurs = verifButton4.isSelected() ? 4 :
                verifButton5.isSelected() ? 5 : 6;

        //Instanciation du plateau
        new Plateau(joueurs, nombreVerificateurs);

        //Fermeture de la fenêtre
        frame.dispose();
    }
}
