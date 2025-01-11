import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe "Vue" (dans le pattern MVC) qui gère l'interface graphique du plateau.
 * Elle s'appuie sur un GameController pour la logique de validation, changement de joueur, etc.
 */
public class Plateau extends JPanel {

    private GameController gameController;           // Le contrôleur (MVC)
    private Image backgroundImage;

    // Stocke tous les JRadioButton des vérificateurs, afin de savoir lequel est coché
    private List<JRadioButton> verifierRadioButtons;

    // ComboBox pour l'hypothèse finale
    private JComboBox<String> lieuxComboBox;
    private JComboBox<String> organisateursComboBox;
    private JComboBox<String> effectifsComboBox;

    // Quelques labels pour l'affichage du joueur, du tour et du nombre de tests restants
    private JLabel headerLabel;
    private JLabel verifierCountLabel;

    // Référence à la fenêtre qui contient ce plateau
    private JFrame frame;

    // --- Palette de couleurs pour différencier les panneaux de vérificateurs ---
    private final Color[] panelColors = {
            new Color(255, 228, 225), // Rose clair
            new Color(240, 255, 240), // Vert clair
            new Color(224, 255, 255), // Bleu clair
            new Color(255, 250, 205), // Jaune clair
            new Color(245, 245, 245), // Gris clair
            new Color(255, 240, 245)  // Violet clair
    };

    /**
     * Constructeur du Plateau (la Vue).
     * @param gameController L'instance de GameController (Contrôleur) à utiliser.
     */
    public Plateau(GameController gameController) {
        this.gameController = gameController;

        // Création de la fenêtre
        frame = new JFrame("Plateau - MVC");
        frame.setSize(1280, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // On applique un layout absolu sur CE JPanel
        setLayout(null);

        // Charger l'image de fond (si le fichier "background.png" existe)
        loadBackground();

        // Initialise la liste qui contiendra les JRadioButton des vérificateurs
        verifierRadioButtons = new ArrayList<>();

        // 1) Créer et ajouter le panneau d'en-tête (Tour X | À Joueur Y de jouer)
        createHeaderPanel();

        // 2) Créer et ajouter le label "Tests restants"
        createVerifierCountPanel();

        // 3) Créer et ajouter les panneaux "Vérificateurs"
        createVerificateurs();

        // 4) Créer et ajouter le panneau "Hypothèse finale" (3 ComboBox)
        createHypothesisPanel();

        // 5) Créer et ajouter le panneau de boutons ("Tester vérificateur" et "Tester code final")
        createTestPanel();

        // Ajouter ce panneau (Plateau) à la fenêtre et l'afficher
        frame.add(this);
        frame.setVisible(true);
    }

    // -------------------------------------------------------------------------
    // Méthodes de création des différents panneaux
    // -------------------------------------------------------------------------

    /**
     * Charge l'image de fond "background.png" si elle existe.
     */
    private void loadBackground() {
        try {
            backgroundImage = new ImageIcon("background.png").getImage();
        } catch (Exception e) {
            backgroundImage = null;
        }
    }

    /**
     * Panneau d'en-tête, affichant "Tour X | À Joueur Y de jouer"
     */
    private void createHeaderPanel() {
        headerLabel = new JLabel(getHeaderText());
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setForeground(new Color(33, 150, 243));

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(headerLabel, BorderLayout.CENTER);

        // Positionnement absolu
        headerPanel.setBounds(440, 20, 400, 80);
        add(headerPanel);
    }

    /**
     * Génère le texte qui s'affiche dans le header
     * (ex. "Tour 1 | À Dupont de jouer" ).
     */
    private String getHeaderText() {
        int turn = gameController.getCurrentTurn();
        String playerName = gameController.getCurrentPlayerName();
        return "Tour " + turn + " | À " + playerName + " de jouer";
    }

    /**
     * Panneau pour afficher "Tests restants : N"
     */
    private void createVerifierCountPanel() {
        verifierCountLabel = new JLabel("Tests restants : " + gameController.getTestRestantsParTour());
        verifierCountLabel.setFont(new Font("Arial", Font.BOLD, 12));
        verifierCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        verifierCountLabel.setForeground(new Color(255, 165, 0));

        JPanel verifierCountPanel = new JPanel(new BorderLayout());
        verifierCountPanel.add(verifierCountLabel, BorderLayout.CENTER);
        verifierCountPanel.setBounds(480, 560, 170, 40);
        verifierCountPanel.setBackground(new Color(245, 245, 245));
        verifierCountPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true));

        add(verifierCountPanel);
    }

    /**
     * Crée et positionne les panneaux "Vérificateurs" en fonction des textes
     * récupérés via le contrôleur.
     */
    private void createVerificateurs() {
        // Récupérer les textes des vérificateurs depuis le contrôleur
        String[] verificateursText = gameController.getVerificateursText();
        int nombreVerificateurs = verificateursText.length;

        // Coordonnées pré-définies pour 6 vérificateurs (pour un plateau 1280x800)
        int[][] coordinates = {
                { 55, 145, 450, 125 },   // Vérificateur 1
                {770, 145, 450, 125 },   // Vérificateur 2
                { 25, 280, 450, 125 },   // Vérificateur 3
                {785, 280, 475, 125 },   // Vérificateur 4
                { 55, 415, 450, 125 },   // Vérificateur 5
                {770, 415, 450, 125 }    // Vérificateur 6
        };

        // ButtonGroup => pour qu'un seul vérificateur puisse être coché à la fois
        ButtonGroup verifierGroup = new ButtonGroup();

        // On crée un panneau par vérificateur
        for (int i = 0; i < nombreVerificateurs; i++) {
            JPanel panel = createVerificateurPanel(
                    verifierGroup,
                    i + 1,
                    verificateursText[i]
            );
            panel.setBounds(
                    coordinates[i][0],
                    coordinates[i][1],
                    coordinates[i][2],
                    coordinates[i][3]
            );
            add(panel);
        }
    }

    /**
     * Crée un panneau (JPanel) pour un vérificateur donné.
     * @param verifierGroup le ButtonGroup auquel rattacher le JRadioButton
     * @param verificateurNumber le numéro du vérificateur (1-based)
     * @param verifierFullText le texte complet (avec 3 lignes) du vérificateur
     */
    private JPanel createVerificateurPanel(ButtonGroup verifierGroup,
                                           int verificateurNumber,
                                           String verifierFullText) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(panelColors[verificateurNumber - 1]);  // Couleur de fond

        // Bandeau du haut, avec le label "Tester ce vérificateur X" + le radio
        JPanel topLine = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topLine.setBackground(panelColors[verificateurNumber - 1]);

        JLabel label = new JLabel("Tester ce vérificateur " + verificateurNumber + " :");
        label.setFont(new Font("Sans-Serif", Font.PLAIN, 16));

        // Le bouton radio
        JRadioButton radio = new JRadioButton();
        radio.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        verifierGroup.add(radio);
        verifierRadioButtons.add(radio);

        topLine.add(label);
        topLine.add(radio);

        // Panneau pour les 3 lignes de critères
        JPanel criteriaPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        criteriaPanel.setBackground(panelColors[verificateurNumber - 1]);

        String[] lignes = verifierFullText.split("\n");
        for (int i = 0; i < Math.min(3, lignes.length); i++) {
            JLabel critere = new JLabel(lignes[i]);
            critere.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
            criteriaPanel.add(critere);
        }

        // Assemblage du panneau
        panel.add(topLine, BorderLayout.NORTH);
        panel.add(criteriaPanel, BorderLayout.CENTER);

        // Bordure avec un titre
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                "Vérificateur " + verificateurNumber + " :",
                0, 0, new Font("Sans-Serif", Font.BOLD, 16))
        );

        return panel;
    }

    /**
     * Panneau pour l'hypothèse finale (3 comboBox : lieu, organisateur, effectif).
     */
    private void createHypothesisPanel() {
        JPanel hypothesisPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JLabel hypothesisLabel = new JLabel("Hypothèse :");
        hypothesisLabel.setFont(new Font("Sans-Serif", Font.BOLD, 16));

        // Valeurs possibles
        String[] lieux = {"Axone", "Foyer Belfort", "MDE Sevenans", "La Poudrière", "Foyer Montbéliard"};
        String[] organisateurs = {"AE", "SkiUT", "BDS", "CrunchTime", "Gala"};
        String[] effectifs = {"30", "75", "120", "200", "350"};

        // Création des ComboBox
        lieuxComboBox = new JComboBox<>(lieux);
        lieuxComboBox.setFont(new Font("Sans-Serif", Font.PLAIN, 14));

        organisateursComboBox = new JComboBox<>(organisateurs);
        organisateursComboBox.setFont(new Font("Sans-Serif", Font.PLAIN, 14));

        effectifsComboBox = new JComboBox<>(effectifs);
        effectifsComboBox.setFont(new Font("Sans-Serif", Font.PLAIN, 14));

        // Assemblage
        hypothesisPanel.add(hypothesisLabel);
        hypothesisPanel.add(new JLabel("Lieux"));
        hypothesisPanel.add(lieuxComboBox);
        hypothesisPanel.add(new JLabel("Organisateur"));
        hypothesisPanel.add(organisateursComboBox);
        hypothesisPanel.add(new JLabel("Effectif"));
        hypothesisPanel.add(effectifsComboBox);

        // Positionnement
        hypothesisPanel.setBounds(420, 660, 480, 80);
        add(hypothesisPanel);
    }

    /**
     * Panneau pour les boutons "Tester vérificateur" et "Tester code final".
     */
    private void createTestPanel() {
        JPanel testPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton testVerifierButton = new JButton("Tester vérificateur");
        testVerifierButton.setFont(new Font("Sans-Serif", Font.BOLD, 16));

        // Au clic, on fait la logique "Tester vérificateur"
        testVerifierButton.addActionListener(e -> onTestVerifier());

        JButton testCodeButton = new JButton("Tester code final");
        testCodeButton.setFont(new Font("Sans-Serif", Font.BOLD, 16));

        // Au clic, on fait la logique "Tester code final"
        testCodeButton.addActionListener(e -> onTestCodeFinal());

        // Assemblage
        testPanel.add(testVerifierButton);
        testPanel.add(testCodeButton);

        // Positionnement
        testPanel.setBounds(420, 600, 480, 50);
        add(testPanel);
    }

    // -------------------------------------------------------------------------
    // Méthodes "action" appelées lors des clics sur les boutons
    // -------------------------------------------------------------------------

    /**
     * Action au clic sur "Tester vérificateur".
     */
    private void onTestVerifier() {
        int selectedIndex = getSelectedVerifierIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Veuillez sélectionner un vérificateur.",
                    "Aucun vérificateur",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Ouvrir une petite fenêtre pour choisir A/B/C
        JDialog dialog = new JDialog(frame, "Vérificateur " + (selectedIndex + 1), true);
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout());

        // Panel principal dans la boîte de dialogue
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel label = new JLabel("Choisissez un critère :");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        // Boutons radio A, B, C
        JRadioButton radioA = new JRadioButton("Critère A");
        JRadioButton radioB = new JRadioButton("Critère B");
        JRadioButton radioC = new JRadioButton("Critère C");
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioA);
        bg.add(radioB);
        bg.add(radioC);

        panel.add(radioA);
        panel.add(radioB);
        panel.add(radioC);

        // Bouton "Valider"
        JButton ok = new JButton("Valider");
        ok.addActionListener(ev -> {
            // Vérifier lequel est coché
            String choice = null;
            if (radioA.isSelected()) choice = "A";
            if (radioB.isSelected()) choice = "B";
            if (radioC.isSelected()) choice = "C";

            if (choice == null) {
                JOptionPane.showMessageDialog(
                        dialog,
                        "Veuillez cocher A, B ou C.",
                        "Choix requis",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            // Appel au contrôleur
            boolean valid = gameController.testVerifier(selectedIndex, choice);

            // Affichage du résultat
            if (valid) {
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

            dialog.dispose();
            refreshUI(); // Mettre à jour l'affichage (joueur courant, tests restants, etc.)
        });

        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(ok, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }

    /**
     * Action au clic sur "Tester code final".
     */
    private void onTestCodeFinal() {
        // Récupérer le choix dans chacune des comboBox
        String lieu = (String) lieuxComboBox.getSelectedItem();
        String orga = (String) organisateursComboBox.getSelectedItem();
        String eff  = (String) effectifsComboBox.getSelectedItem();

        String[] guess = { lieu, orga, eff };

        boolean correct = gameController.testFinalCode(guess);
        if (correct) {
            // Le joueur a gagné => on affiche la fenêtre de victoire
            showVictoryWindow();
        } else {
            // Échec => message d'erreur + passage au prochain joueur
            JOptionPane.showMessageDialog(
                    this,
                    "Échec, votre code est incorrect.",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE
            );
            refreshUI(); // Mise à jour de l'affichage
        }
    }

    // -------------------------------------------------------------------------
    // Méthodes utilitaires
    // -------------------------------------------------------------------------

    /**
     * Retrouve l'index du vérificateur sélectionné (ou -1 si rien n'est coché).
     */
    private int getSelectedVerifierIndex() {
        for (int i = 0; i < verifierRadioButtons.size(); i++) {
            if (verifierRadioButtons.get(i).isSelected()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Met à jour l'affichage du header (joueur, tour) et du label "tests restants".
     */
    private void refreshUI() {
        headerLabel.setText(getHeaderText());
        verifierCountLabel.setText(
                "Tests restants : " + gameController.getTestRestantsParTour()
        );
    }

    /**
     * Ouvre une fenêtre de victoire (lorsqu'un joueur a trouvé le code final).
     */
    private void showVictoryWindow() {
        JFrame victoryFrame = new JFrame("Victoire !");
        victoryFrame.setSize(400, 200);
        victoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        victoryFrame.setResizable(false);
        victoryFrame.setLayout(new BorderLayout());

        JLabel victoryLabel = new JLabel("Bravo, vous avez remporté la partie !");
        victoryLabel.setFont(new Font("Arial", Font.BOLD, 16));
        victoryLabel.setHorizontalAlignment(SwingConstants.CENTER);

        victoryFrame.add(victoryLabel, BorderLayout.CENTER);

        // Bouton "Quitter"
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton quitButton = new JButton("Quitter");
        quitButton.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        quitButton.addActionListener(e -> {
            // Ferme complètement l'application
            System.exit(0);
        });

        buttonPanel.add(quitButton);
        victoryFrame.add(buttonPanel, BorderLayout.SOUTH);

        // Centre la fenêtre sur l'écran
        victoryFrame.setLocationRelativeTo(null);
        victoryFrame.setVisible(true);
    }

    // -------------------------------------------------------------------------
    // Surcharger paintComponent pour dessiner l'image de fond
    // -------------------------------------------------------------------------
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Fond en blanc
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Dessiner l'image de fond si elle existe
        if (backgroundImage != null) {
            double scaleFactor = 0.085; // à ajuster selon la taille souhaitée
            int imageWidth = (int) (backgroundImage.getWidth(this) * scaleFactor);
            int imageHeight = (int) (backgroundImage.getHeight(this) * scaleFactor);
            int x = (getWidth() - imageWidth) / 2;
            int y = (getHeight() - imageHeight) / 2;
            g.drawImage(backgroundImage, x, y, imageWidth, imageHeight, this);
        }
    }
}
