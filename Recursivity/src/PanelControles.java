import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.IntConsumer;

/**
 * PanelControles.java
 * Minimalist bottom panel:
 *   - Text field to enter the level
 *   - Draw button (also responds to Enter)
 *   - Inline error message if the input is invalid
 */

public class PanelControles extends JPanel {
    private final JTextField campoNivel;
    private final JLabel     lblError;

    public PanelControles(int nivelInicial, IntConsumer alCambiar) {
        setLayout(new FlowLayout(FlowLayout.CENTER, 14, 12));
        setBackground(Tema.FONDO_PANEL);
        setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Tema.BORDE));

        // Label
        JLabel lbl = new JLabel("Recursion level:");
        lbl.setFont(new Font("Monospaced", Font.BOLD, 13));
        lbl.setForeground(new Color(0xA8C4DC));

        // Text field
        campoNivel = new JTextField(String.valueOf(nivelInicial), 4);
        campoNivel.setFont(new Font("Monospaced", Font.BOLD, 20));
        campoNivel.setBackground(new Color(0x0F1923));
        campoNivel.setForeground(new Color(0x06B6D4));
        campoNivel.setCaretColor(new Color(0x06B6D4));
        campoNivel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Tema.BORDE, 1),
                BorderFactory.createEmptyBorder(4, 8, 4, 8)
        ));
        campoNivel.setHorizontalAlignment(JTextField.CENTER);

        // Button
        JButton btnDibujar = new JButton("Draw ▶");
        btnDibujar.setFont(new Font("Monospaced", Font.BOLD, 13));
        btnDibujar.setBackground(new Color(0x1E3A5F));
        btnDibujar.setForeground(new Color(0x06B6D4));
        btnDibujar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0x06B6D4), 1),
                BorderFactory.createEmptyBorder(6, 14, 6, 14)
        ));
        btnDibujar.setFocusPainted(false);
        btnDibujar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Error message
        lblError = new JLabel(" ");
        lblError.setFont(new Font("Monospaced", Font.ITALIC, 11));
        lblError.setForeground(new Color(0xFF4444));

        // Shared action (button and Enter)
        Runnable accion = () -> {
            try {
                int nivel = Integer.parseInt(campoNivel.getText().trim());
                if (nivel < 0) {
                    lblError.setText("⚠ Level must be 0 or greater.");
                    return;
                }
                lblError.setText(" ");
                alCambiar.accept(nivel);
            } catch (NumberFormatException ex) {
                lblError.setText("⚠ Enter a valid integer.");
            }
        };

        btnDibujar.addActionListener((ActionEvent e) -> accion.run());
        campoNivel.addActionListener((ActionEvent e) -> accion.run());

        // Assemble
        add(lbl);
        add(campoNivel);
        add(btnDibujar);
        add(lblError);
    }
}
