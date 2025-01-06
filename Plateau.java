import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Plateau extends JPanel {

    private Image backgroundImage;

    // Constructeur de la fenêtre du plateau, passer en paramètre les variables utiles
    public Plateau(List<List<String>> joueurs, int nombreVerificateurs) {
        JFrame frame = new JFrame("Plateau");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Charger l'image de fond
        backgroundImage = new ImageIcon("background.png").getImage();

        // Ajouter le panneau au frame
        frame.add(this);
        frame.setVisible(true);
    }

    // Surcharger paintComponent pour dessiner l'image de fond avec marges blanches et redimensionnée
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Définir un facteur de réduction pour rendre l'image plus petite
        double scaleFactor = 0.1;  // Taille réduite à 30% de l'original

        int imageWidth = (int) (backgroundImage.getWidth(this) * scaleFactor);
        int imageHeight = (int) (backgroundImage.getHeight(this) * scaleFactor);

        // Calculer la position pour centrer l'image
        int x = (getWidth() - imageWidth) / 2;
        int y = (getHeight() - imageHeight) / 2;

        // Remplir le fond en blanc
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Dessiner l'image centrée et réduite
        g.drawImage(backgroundImage, x, y, imageWidth, imageHeight, this);
    }
}
