import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Plateau extends JPanel {

    private Image backgroundImage;

    // Constructeur de la fenêtre du plateau
    public Plateau(List<List<String>> joueurs, int nombreVerificateurs) {
        JFrame frame = new JFrame("Plateau");
        frame.setSize(1080, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Charger l'image de fond
        try {
            backgroundImage = new ImageIcon("background.png").getImage();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Erreur : Impossible de charger l'image de fond.",
                    "Erreur de chargement", JOptionPane.ERROR_MESSAGE);
            backgroundImage = null;
        }

        // Définir un layout absolu pour permettre le positionnement des éléments
        setLayout(null);

        // Ajouter un panneau de vérificateur
        //TODO : mettre dans une boucle pour créer N panneaux + critères aléatoires
        JPanel controlsPanel = createVerificateurPannel();

        // Positionner et dimensionner le panneau
        controlsPanel.setBounds(680, 190, 250, 125);
        add(controlsPanel);

        // Ajouter le panneau au frame
        frame.add(this);
        frame.setVisible(true);
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


    // Méthode de création du panneau de vérificateur (appelée par le constructeur)
    private JPanel createVerificateurPannel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Ligne 1 : Vérificateur + RadioButton
        JPanel verificateurPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel verifierLabel = new JLabel("Tester ce vérificateur :");

        JRadioButton verifierRadioButton = new JRadioButton();

        verificateurPanel.add(verifierLabel);
        verificateurPanel.add(verifierRadioButton);

        // Ligne 2 : Critères alignés en colonne
        JPanel criteriaPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        JLabel critere1 = new JLabel("Critère 1:");
        JLabel critere2 = new JLabel("Critère 2:");
        JLabel critere3 = new JLabel("Critère 3:");
        criteriaPanel.add(critere1);
        criteriaPanel.add(critere2);
        criteriaPanel.add(critere3);

        // Ajouter les composants au panneau principal
        panel.add(verificateurPanel, BorderLayout.NORTH);
        panel.add(criteriaPanel, BorderLayout.CENTER);

        // Ajouter une bordure pour distinguer visuellement
        panel.setBorder(BorderFactory.createTitledBorder("Vérificateur 1 :"));

        return panel;
    }
}
