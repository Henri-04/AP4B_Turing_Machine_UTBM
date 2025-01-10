import javax.swing.*;
import java.awt.*;

public class FeuilleNotes extends JFrame {

    private String playerName; // Nom du joueur
    private int currentTurn;   // Numéro de tour

    public FeuilleNotes(String playerName) {
        this.playerName = playerName;
        this.currentTurn = currentTurn;

        // Configuration de la fenêtre principale
        setTitle("Feuille de Notes - " + playerName);
        setSize(818, 635);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null); // Utilisation d'un layout null pour positionner manuellement les composants

        // --- Panneau supérieur (Nom et numéro de tour) ---
        JLabel playerLabel = new JLabel(playerName);
        playerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        playerLabel.setBounds(615, 2, 200, 30); // Position haut droite
        add(playerLabel);


        // --- Panneau central (Image de fond avec checkboxes et menus déroulants) ---
        BackgroundPanel centralPanel = new BackgroundPanel("feuillenotes.png");
        centralPanel.setBounds(0, 0, 800, 600); // Couvrir toute la fenêtre
        centralPanel.setLayout(null); // Positionnement manuel pour les checkboxes et menus déroulants

        // Ajouter les checkboxes aux positions spécifiques
        int[][] checkboxPositions = {
                {490, 105}, {539, 105}, {588, 105}, {637, 105}, {686, 105}, {735, 105}, // Ligne 1
                {490, 129}, {539, 129}, {588, 129}, {637, 129}, {686, 129}, {735, 129}, // Ligne 2
                {490, 153}, {539, 153}, {588, 153}, {637, 153}, {686, 153}, {735, 153}, // Ligne 3
                {490, 176}, {539, 176}, {588, 176}, {637, 176}, {686, 176}, {735, 176}, // Ligne 4
                {490, 200}, {539, 200}, {588, 200}, {637, 200}, {686, 200}, {735, 200}, // Ligne 5
                {490, 224}, {539, 224}, {588, 224}, {637, 224}, {686, 224}, {735, 224}, // Ligne 6
                {490, 248}, {539, 248}, {588, 248}, {637, 248}, {686, 248}, {735, 248}, // Ligne 7
                {490, 270}, {539, 270}, {588, 270}, {637, 270}, {686, 270}, {735, 270}, // Ligne 8
        };

        for (int i = 0; i < checkboxPositions.length; i++) {
            JCheckBox checkBox = new JCheckBox();
            checkBox.setBounds(checkboxPositions[i][0], checkboxPositions[i][1], 20, 20); // Position et taille
            checkBox.setOpaque(false); // Rendre les checkboxes transparentes
            centralPanel.add(checkBox);
        }

        // Options pour les menus déroulants
        String[] lieux = {"Axone", "Foyer Belfort", "MDE Sevenans", "La Poudrière", "Foyer Montbéliard"};
        String[] organisateurs = {"AE", "SkiUT", "BDS", "CrunchTime", "Gala"};
        String[] effectifs = {"30", "75", "120", "200", "350"};

        // Ajouter les menus déroulants
        for (int i = 0; i < 9; i++) {
            // Colonne 1 : Lieux
            JComboBox<String> lieuxDropdown = new JComboBox<>(lieux);
            lieuxDropdown.setBounds(120, 89 + i * 24, 70, 18); // Plus condensé
            centralPanel.add(lieuxDropdown);

            // Colonne 2 : Organisateurs
            JComboBox<String> organisateursDropdown = new JComboBox<>(organisateurs);
            organisateursDropdown.setBounds(205, 89 + i * 24, 70, 18); // Aligné à droite
            centralPanel.add(organisateursDropdown);

            // Colonne 3 : Effectifs
            JComboBox<String> effectifsDropdown = new JComboBox<>(effectifs);
            effectifsDropdown.setBounds(290, 89 + i * 24, 70, 18); // Aligné à droite
            centralPanel.add(effectifsDropdown);
        }

        // --- Ajouter des zones de texte en bas de la feuille ---
        addTextZones(centralPanel);

        add(centralPanel);
    }

    // Méthode pour ajouter les zones de texte
    private void addTextZones(JPanel centralPanel) {
        // Positions pour les 6 zones de texte
        int[][] textZonePositions = {
                {100, 325, 300, 50}, {480, 325, 300, 50}, {100, 415, 300, 50},
                {480, 415, 300, 50}, {100, 510, 300, 50}, {480, 510, 300, 50}
        };

        for (int i = 0; i < 6; i++) {
            JTextField textField = new JTextField();
            textField.setBounds(textZonePositions[i][0], textZonePositions[i][1],
                    textZonePositions[i][2], textZonePositions[i][3]);
            textField.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
            textField.setBackground(new Color(245, 255, 245)); // Fond clair
            textField.setBorder(BorderFactory.createLineBorder(new Color(180, 220, 180), 1)); // Bordure verte
            centralPanel.add(textField);
        }
    }

    // Classe interne pour dessiner l'image en arrière-plan
    private static class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            try {
                // Charger l'image à partir des ressources du projet
                backgroundImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
            } catch (Exception e) {
                System.err.println("Erreur : Impossible de charger l'image " + imagePath);
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
