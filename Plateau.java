import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Plateau extends JPanel {

    private Image backgroundImage;
    private JLabel headerLabel; // Label pour afficher le tour et le joueur
    private String[] verificateursText; // Contient les N textes de vérificateurs
    private Scenarii scenario;  // Pour pouvoir valider un vérificateur
    private List<JRadioButton> verifierRadioButtons = new ArrayList<>(); // Pour repérer lequel est coché

    JLabel verifierCountLabel = new JLabel(); //Affichage du nombre de tests restants
    private int testRestants = 3;//Nombre de tests restants au commencement du tour

    // Constructeur de la fenêtre du plateau
    public Plateau(List<List<String>> joueurs, int nombreVerificateurs, Scenarii scenario) {

        // Creation de la fenêtre
        JFrame frame = new JFrame("Plateau");

        // Paramètres de la fenêtre
        frame.setSize(1080, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Charger l'image de fond
        loadBackground();

        // Définir un layout absolu pour ce JPanel
        setLayout(null);

        // On stocke le scenario
        this.scenario = scenario;
        // On stocke les textes de tous les vérificateurs
        this.verificateursText = scenario.verfificateurs;

        // Affichage du nombre de tests restants
        displayTestsRestants(testRestants);

        // Ajouter le panneau d'en-tête (nom du 1er joueur, tour 1)
        createHeaderPanel(joueurs.get(0).get(1), 1);

        // Panneau pour l’hypothèse finale
        createHypothesisPanel();

        // Créer et positionner les panneaux vérificateurs
        createVerificateurs(nombreVerificateurs);

        // Panneau boutons "Tester vérificateur" & "Tester code final"
        createTestPanel();

        // Ajouter ce JPanel au frame et rendre visible
        frame.add(this);
        frame.setVisible(true);
    }

    //Affichage du nombre de tests restants
    private void displayTestsRestants(int x) {

        verifierCountLabel.setText("Nombre de tests restants :" + x);
        verifierCountLabel.setFont(new Font("Arial", Font.BOLD, 12));
        verifierCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        verifierCountLabel.setForeground(new Color(33, 150, 243));

        JPanel verifierCountPanel = new JPanel(new BorderLayout());
        verifierCountPanel.add(verifierCountLabel, BorderLayout.CENTER);
        verifierCountPanel.setBounds(365, 560, 170, 40);
        verifierCountPanel.setBackground(new Color(245, 245, 245));
        verifierCountPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true));

        add(verifierCountPanel);
    }

    // Charger l'image de fond
    private void loadBackground() {
        try {
            backgroundImage = new ImageIcon("background.png").getImage();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur : Impossible de charger l'image de fond.",
                    "Erreur de chargement", JOptionPane.ERROR_MESSAGE);
            backgroundImage = null;
        }
    }

    // Surcharger paintComponent pour dessiner l'image de fond
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Remplir le fond en blanc
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Dessiner l'image si elle est chargée
        if (backgroundImage != null) {
            double scaleFactor = 0.085; // Réduire l'image
            int imageWidth = (int) (backgroundImage.getWidth(this) * scaleFactor);
            int imageHeight = (int) (backgroundImage.getHeight(this) * scaleFactor);
            int x = (getWidth() - imageWidth) / 2;
            int y = (getHeight() - imageHeight) / 2;
            g.drawImage(backgroundImage, x, y, imageWidth, imageHeight, this);
        } else {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 18));
            String message = "Image de fond introuvable.";
            int messageWidth = g.getFontMetrics().stringWidth(message);
            g.drawString(message, (getWidth() - messageWidth) / 2, getHeight() / 2);
        }
    }

    // Créer le panneau d'en-tête
    private void createHeaderPanel(String playerName, int currentTurn) {
        // Titre pour le tour
        JLabel turnLabel = new JLabel("Tour " + currentTurn);
        turnLabel.setFont(new Font("Arial", Font.BOLD, 18));
        turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
        turnLabel.setForeground(new Color(33, 150, 243));

        // Texte avant
        JLabel preTextLabel = new JLabel("À ");
        preTextLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        preTextLabel.setForeground(new Color(100, 100, 100));

        // Nom du joueur
        JLabel playerNameLabel = new JLabel(playerName);
        playerNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        playerNameLabel.setForeground(new Color(244, 67, 54));

        // Texte après
        JLabel postTextLabel = new JLabel(" de jouer");
        postTextLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        postTextLabel.setForeground(new Color(100, 100, 100));

        // Panneau horizontal pour l'info joueur
        JPanel playerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        playerPanel.setBackground(new Color(245, 245, 245));
        playerPanel.add(preTextLabel);
        playerPanel.add(playerNameLabel);
        playerPanel.add(postTextLabel);

        // Panneau principal
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(turnLabel, BorderLayout.NORTH);
        headerPanel.add(playerPanel, BorderLayout.CENTER);
        headerPanel.setBackground(new Color(250, 250, 250));
        headerPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 20, 10, 20),
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true)
        ));

        // Positionner
        headerPanel.setBounds(340, 20, 400, 80);
        add(headerPanel);
    }

    // Mettre à jour l'en-tête (si tu veux faire évoluer en temps réel)
    public void updateHeader(String playerName, int currentTurn) {
        if (headerLabel != null) {
            headerLabel.setText("Tour : " + currentTurn + " | Joueur : " + playerName);
        }
    }

    // Créer les panneaux vérificateurs
    private void createVerificateurs(int nombreVerificateurs) {

        // Coordonnées pour chaque vérificateur
        int[][] coordinates = {
                {120, 145, 250, 125},  // Vérificateur 1
                {720, 145, 250, 125},  // Vérificateur 2
                {90,  280, 250, 125},  // Vérificateur 3
                {750, 280, 250, 125},  // Vérificateur 4
                {120, 415, 250, 125},  // Vérificateur 5
                {720, 415, 250, 125}   // Vérificateur 6
        };

        // Un seul groupe => une seule sélection
        ButtonGroup verifierGroup = new ButtonGroup();

        for (int i = 0; i < nombreVerificateurs; i++) {
            JPanel controlsPanel = createVerificateurPannel(verifierGroup, i + 1, verificateursText[i]);
            controlsPanel.setBounds(coordinates[i][0], coordinates[i][1],
                    coordinates[i][2], coordinates[i][3]);
            add(controlsPanel);
        }
    }

    // Palette de couleurs pour les vérificateurs
    private final Color[] panelColors = {
            new Color(255, 228, 225), // Rose clair
            new Color(240, 255, 240), // Vert clair
            new Color(224, 255, 255), // Bleu clair
            new Color(255, 250, 205), // Jaune clair
            new Color(245, 245, 245), // Gris clair
            new Color(255, 240, 245)  // Violet clair
    };

    // Crée un panneau pour un vérificateur (avec un JRadioButton)
    private JPanel createVerificateurPannel(ButtonGroup verifierGroup,
                                            int verificateurNumber,
                                            String verifierFullText) {
        // Panneau principal
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(panelColors[verificateurNumber - 1]);

        // Ligne du titre + radio
        JPanel verificateur = new JPanel(new FlowLayout(FlowLayout.LEFT));
        verificateur.setBackground(panelColors[verificateurNumber - 1]);

        JLabel verifierLabel = new JLabel("Tester ce vérificateur " + verificateurNumber + " :");
        verifierLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 16));

        JRadioButton verifierRadioButton = new JRadioButton();
        verifierRadioButton.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        verifierGroup.add(verifierRadioButton);
        // On stocke le JRadioButton dans la liste
        verifierRadioButtons.add(verifierRadioButton);

        verificateur.add(verifierLabel);
        verificateur.add(verifierRadioButton);

        // Ligne des critères (3 lignes)
        JPanel criteriaPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        criteriaPanel.setBackground(panelColors[verificateurNumber - 1]);
        String[] lignes = verifierFullText.split("\n");

        if (lignes.length >= 3) {
            JLabel critere1 = new JLabel(lignes[0]);
            JLabel critere2 = new JLabel(lignes[1]);
            JLabel critere3 = new JLabel(lignes[2]);
            critere1.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
            critere2.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
            critere3.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
            criteriaPanel.add(critere1);
            criteriaPanel.add(critere2);
            criteriaPanel.add(critere3);
        } else {
            // Au cas où il y aurait moins de 3 lignes, on évite de planter
            for (String line : lignes) {
                JLabel critere = new JLabel(line);
                critere.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
                criteriaPanel.add(critere);
            }
        }

        // Assemblage
        panel.add(verificateur, BorderLayout.NORTH);
        panel.add(criteriaPanel, BorderLayout.CENTER);

        // Bordure avec le titre "Vérificateur X"
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                "Vérificateur " + verificateurNumber + " :",
                0, 0, new Font("Sans-Serif", Font.BOLD, 16))
        );

        return panel;
    }

    // Panneau des boutons "Tester vérificateur" et "Tester code final"
    private void createTestPanel() {
        JPanel testPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton testVerifierButton = new JButton("Tester vérificateur");
        testVerifierButton.setFont(new Font("Sans-Serif", Font.BOLD, 16));

        // Listener sur "Tester vérificateur"
        testVerifierButton.addActionListener(e -> {

            //Gestion des tours
            if (testRestants == 0) {

                //Paser au tour suivant -> à coder
                testRestants = 4;
                //Coder ici tour suivant
            }
            testRestants = testRestants -1;

            System.out.println(testRestants);//Test console

            displayTestsRestants(testRestants);







            //Gestion des verifications
            int selectedVerifierIndex = getSelectedVerifierIndex();
            if (selectedVerifierIndex == -1) {
                JOptionPane.showMessageDialog(
                        this,
                        "Veuillez sélectionner un vérificateur.",
                        "Aucun vérificateur",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            // Ouvrir la fenêtre de choix A/B/C
            openVerifierChoiceDialog(selectedVerifierIndex);
        });

        JButton testCodeButton = new JButton("Tester code final");
        testCodeButton.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        // Tu pourras ajouter ici un listener pour proposer la validation finale (lieu, organisateur, etc.)

        testPanel.add(testVerifierButton);
        testPanel.add(testCodeButton);

        // Position du panneau
        testPanel.setBounds(300, 600, 480, 50);
        add(testPanel);
    }

    // Méthode pour créer le panneau des hypothèses avec menus déroulants
    private void createHypothesisPanel() {
        JPanel hypothesisPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JLabel hypothesisLabel = new JLabel("Hypothèse :");
        hypothesisLabel.setFont(new Font("Sans-Serif", Font.BOLD, 16));

        // Options pour les menus déroulants
        String[] lieux = {"Axone", "Foyer Belfort", "MDE Sevenans", "La Poudrière", "Foyer Montbéliard"};
        String[] organisateurs = {"AE", "SkiUT", "BDS", "CrunchTime", "Gala"};
        String[] effectifs = {"30", "75", "120", "200", "350"};

        // Création des menus déroulants avec leurs labels
        JLabel lieuxLabel = new JLabel("Lieux");
        lieuxLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        JComboBox<String> lieuxComboBox = new JComboBox<>(lieux);
        lieuxComboBox.setFont(new Font("Sans-Serif", Font.PLAIN, 14));

        JLabel organisateursLabel = new JLabel("Organisateur");
        organisateursLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        JComboBox<String> organisateursComboBox = new JComboBox<>(organisateurs);
        organisateursComboBox.setFont(new Font("Sans-Serif", Font.PLAIN, 14));

        JLabel effectifsLabel = new JLabel("Effectif");
        effectifsLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        JComboBox<String> effectifsComboBox = new JComboBox<>(effectifs);
        effectifsComboBox.setFont(new Font("Sans-Serif", Font.PLAIN, 14));

        // Ajout des composants
        hypothesisPanel.add(hypothesisLabel);
        hypothesisPanel.add(lieuxLabel);
        hypothesisPanel.add(lieuxComboBox);
        hypothesisPanel.add(organisateursLabel);
        hypothesisPanel.add(organisateursComboBox);
        hypothesisPanel.add(effectifsLabel);
        hypothesisPanel.add(effectifsComboBox);

        hypothesisPanel.setBounds(300, 660, 480, 80);
        add(hypothesisPanel);
    }

    // Récupérer l'index du vérificateur coché
    private int getSelectedVerifierIndex() {
        for (int i = 0; i < verifierRadioButtons.size(); i++) {
            if (verifierRadioButtons.get(i).isSelected()) {
                return i; // on renvoie l’index
            }
        }
        return -1; // rien n’est coché
    }

    // Ouvrir une petite fenêtre pour choisir A/B/C
    private void openVerifierChoiceDialog(int verifierIndex) {
        // Fenêtre modale
        JDialog dialog = new JDialog(
                SwingUtilities.getWindowAncestor(this),
                "Vérificateur " + (verifierIndex + 1),
                Dialog.ModalityType.APPLICATION_MODAL
        );
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel label = new JLabel("Choisissez un critère :");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(label);

        // 3 boutons radio : A, B, C
        JRadioButton radioA = new JRadioButton("Critère A");
        JRadioButton radioB = new JRadioButton("Critère B");
        JRadioButton radioC = new JRadioButton("Critère C");

        ButtonGroup group = new ButtonGroup();
        group.add(radioA);
        group.add(radioB);
        group.add(radioC);

        mainPanel.add(radioA);
        mainPanel.add(radioB);
        mainPanel.add(radioC);

        // Bouton de validation
        JButton okButton = new JButton("Valider");
        okButton.addActionListener(e -> {
            // Vérifier le choix
            String choice = null;
            if (radioA.isSelected()) {
                choice = "A";
            } else if (radioB.isSelected()) {
                choice = "B";
            } else if (radioC.isSelected()) {
                choice = "C";
            } else {
                JOptionPane.showMessageDialog(
                        dialog,
                        "Veuillez cocher A, B ou C.",
                        "Choix requis",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            // Vérifier la validité via le scénario
            boolean isValid = scenario.validateVerifier(verifierIndex, choice);
            if (isValid) {
                JOptionPane.showMessageDialog(
                        dialog,
                        "Vérificateur validé !",
                        "Succès",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                        dialog,
                        "Choix incorrect !",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE
                );
            }
            dialog.dispose(); // fermer la fenêtre
        });

        dialog.add(mainPanel, BorderLayout.CENTER);
        dialog.add(okButton, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }
}
