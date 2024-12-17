import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame {

    private JTextArea notesArea;   // Feuille de notes pour le joueur
    private JTextArea verificateursArea; // Affichage des vérificateurs
    private JButton verifierButton; // Bouton pour vérifier les réponses
    private JTextField guessField1, guessField2, guessField3; // Champs de saisie des réponses

    private String[] finalAnswer;  // Réponse finale du scénario

    // Constructeur
    public Interface(String[] verificateurs, String[] finalAnswer) {
        this.finalAnswer = finalAnswer;

        // Configuration de la fenêtre principale
        setTitle("Turing Machine - Plateau & Feuille de Notes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- Panneau Plateau (Vérificateurs) ---
        JPanel plateauPanel = new JPanel(new BorderLayout());
        verificateursArea = new JTextArea();
        verificateursArea.setEditable(false);
        verificateursArea.setText("Vérificateurs :\n");
        for (String verificateur : verificateurs) {
            verificateursArea.append(verificateur + "\n\n");
        }
        plateauPanel.add(new JScrollPane(verificateursArea), BorderLayout.CENTER);
        plateauPanel.setBorder(BorderFactory.createTitledBorder("Plateau de jeu"));

        // --- Panneau Feuille de Notes ---
        JPanel notesPanel = new JPanel(new BorderLayout());
        notesArea = new JTextArea(10, 30);
        notesPanel.add(new JScrollPane(notesArea), BorderLayout.CENTER);
        notesPanel.setBorder(BorderFactory.createTitledBorder("Feuille de Notes"));

        // --- Champs de saisie des hypothèses ---
        JPanel inputPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Vos Hypothèses"));
        guessField1 = new JTextField();
        guessField2 = new JTextField();
        guessField3 = new JTextField();
        inputPanel.add(new JLabel("Lieu :"));
        inputPanel.add(guessField1);
        inputPanel.add(new JLabel("Organisateur :"));
        inputPanel.add(guessField2);
        inputPanel.add(new JLabel("Nb Invités :"));
        inputPanel.add(guessField3);

        // --- Bouton Vérifier ---
        verifierButton = new JButton("Vérifier");
        verifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verifierReponse();
            }
        });
        inputPanel.add(verifierButton);

        // --- Ajouter les panneaux ---
        add(plateauPanel, BorderLayout.WEST);
        add(notesPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
    }

    // Méthode pour vérifier la réponse du joueur
    private void verifierReponse() {
        String reponse1 = guessField1.getText();
        String reponse2 = guessField2.getText();
        String reponse3 = guessField3.getText();

        if (reponse1.equalsIgnoreCase(finalAnswer[0]) &&
                reponse2.equalsIgnoreCase(finalAnswer[1]) &&
                reponse3.equalsIgnoreCase(finalAnswer[2])) {
            JOptionPane.showMessageDialog(this, "Félicitations ! Réponses correctes !", "Victoire", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Mauvaise réponse. Réessayez !", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Méthode principale pour tester l'interface
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Exemple avec un scénario existant (Cas1 par exemple)
                Cas1 cas1 = new Cas1(4);
                Interface gameInterface = new Interface(cas1.verfificateurs, cas1.Final_answer);
                gameInterface.setVisible(true);
            }
        });
    }
}
