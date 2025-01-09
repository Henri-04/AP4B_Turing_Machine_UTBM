import javax.swing.*;
import java.awt.*;
import java.util.List;


//TODO : passer en argument de la fonction de création des verificateurs le numéro, le texte des critères (map)
//TODO : jpannel tester un verificateur (JList)
//TODO : tester un code final

public class Plateau extends JPanel {

    private Image backgroundImage;
    private JLabel headerLabel; // Label pour afficher le tour et le joueur


    // Constructeur de la fenêtre du plateau
    public Plateau(List<List<String>> joueurs, int nombreVerificateurs) {

        //Creation de la fenêtre
        JFrame frame = new JFrame("Plateau");

        //Parametrage de la fenêtre
        frame.setSize(1080, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Charger l'image de fond
        loadBackground();


        // Définir un layout absolu pour permettre le positionnement des éléments
        setLayout(null);

        // Ajouter le panneau pour afficher le tour et le joueur
        createHeaderPanel(joueurs.get(0).get(1), 1); // Exemple : Joueur 1, Tour 1

        // Ajouter le panneau au frame
        frame.add(this);
        frame.setVisible(true);



        // Creation et ajout au panneau des verificateurs
        createVerificateurs(nombreVerificateurs);


        // Ajouter le panneau au frame
        frame.add(this);
        frame.setVisible(true);
    }

    //Chargement de l'arrière plan et gestion des exceptions
    private void loadBackground(){
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

        if (backgroundImage != null) {
            double scaleFactor = 0.085; // Taille réduite à 10%
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
    //créer le panneau d'en tete
    private void createHeaderPanel(String playerName, int currentTurn) {
        // Crée un panneau en haut pour afficher le tour et le joueur
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBounds(0, 0, 1080, 50); // Pleine largeur et hauteur 50

        // Crée un label pour le tour et le joueur
        headerLabel = new JLabel("Tour : " + currentTurn + " | Joueur : " + playerName);
        headerLabel.setFont(new Font("Sans-Serif", Font.BOLD, 20)); // Taille augmentée pour un impact visuel

        // Ajoutez le label au panneau
        headerPanel.add(headerLabel);

        // Ajoutez une bordure au panneau pour le distinguer (optionnel)
        headerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // Ajoutez le panneau au plateau
        add(headerPanel);
    }


    // Méthode pour mettre à jour l'en-tête
    public void updateHeader(String playerName, int currentTurn) {
        headerLabel.setText("Tour : " + currentTurn + " | Joueur : " + playerName);
    }


    //Creation du bon nombre de verificateurs aux bons endroits
    private void createVerificateurs(int nombreVerificateurs) {
        // Coordonnées pour chaque vérificateur
        int[][] coordinates = {

                {120, 145, 250, 125},  // Vérificateur 1
                {720, 145, 250, 125}, // Vérificateur 2
                {90, 280, 250, 125},  // Vérificateur 3
                {750, 280, 250, 125}, // Vérificateur 4
                {120, 415, 250, 125},   // Vérificateur 5
                {720, 415, 250, 125}   // Vérificateur 6
        };

        // Création d'un ButtonGroup pour regrouper les boutons radio
        ButtonGroup verifierGroup = new ButtonGroup();

        // Créer et positionner les panneaux en fonction du nombre de vérificateurs
        for (int i = 0; i < nombreVerificateurs; i++) {
            JPanel controlsPanel = createVerificateurPannel(verifierGroup, i + 1);
            controlsPanel.setBounds(
                    coordinates[i][0], // x
                    coordinates[i][1], // y
                    coordinates[i][2], // width
                    coordinates[i][3]  // height
            );
            add(controlsPanel); // Ajouter au conteneur
        }
    }

    //Creation d'un seul panneau Verificateur
    private JPanel createVerificateurPannel(ButtonGroup verifierGroup, int verificateurNumber) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Ligne 1 : Vérificateur + RadioButton
        JPanel verificateur = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel verifierLabel = new JLabel("Tester ce vérificateur " + verificateurNumber + " :");
        verifierLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 16)); // Police moderne plus légère

        JRadioButton verifierRadioButton = new JRadioButton();
        verifierRadioButton.setFont(new Font("Sans-Serif", Font.PLAIN, 14)); // Police adaptée pour les boutons
        verifierGroup.add(verifierRadioButton); // Ajouter le bouton au ButtonGroup

        verificateur.add(verifierLabel);
        verificateur.add(verifierRadioButton);

        // Ligne 2 : Critères alignés en colonne
        JPanel criteriaPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        JLabel critere1 = new JLabel("Critère 1:");
        JLabel critere2 = new JLabel("Critère 2:");
        JLabel critere3 = new JLabel("Critère 3:");

        critere1.setFont(new Font("Sans-Serif", Font.PLAIN, 14)); // Critères avec une taille de police standard
        critere2.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        critere3.setFont(new Font("Sans-Serif", Font.PLAIN, 14));

        criteriaPanel.add(critere1);
        criteriaPanel.add(critere2);
        criteriaPanel.add(critere3);

        // Ajouter les composants au panneau principal
        panel.add(verificateur, BorderLayout.NORTH);
        panel.add(criteriaPanel, BorderLayout.CENTER);

        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                "Vérificateur " + verificateurNumber + " :",
                0, 0, new Font("Sans-Serif", Font.BOLD, 16))); // Bordure avec titre en gras

        return panel;
    }
}