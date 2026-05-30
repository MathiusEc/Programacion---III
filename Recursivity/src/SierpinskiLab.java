import javax.swing.*;
import java.awt.*;

public class SierpinskiLab extends JFrame {
    private static final int VENTANA_W = 960;
    private static final int VENTANA_H = 720;
    private static final int PANEL_H   = 660;
    private static final int CTRL_H    = 60;

    private static final int NIVEL_INICIAL = 3;

    //  CONSTRUCTOR
    public SierpinskiLab() {
        setTitle("Laboratorio: Triángulo de Sierpinski — Recursividad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(VENTANA_W, VENTANA_H);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Tema.FONDO);
        setLayout(new BorderLayout());

        // Crear paneles
        PanelDibujo panelDibujo = new PanelDibujo(NIVEL_INICIAL);
        panelDibujo.setPreferredSize(new Dimension(VENTANA_W, PANEL_H));

        // El slider en PanelControles llama a panelDibujo.setNivel()
        // mediante un lambda: ninguna de las dos clases conoce a la otra
        PanelControles panelControles = new PanelControles(
                NIVEL_INICIAL,
                panelDibujo::setNivel          // callback: IntConsumer
        );
        panelControles.setPreferredSize(new Dimension(VENTANA_W, CTRL_H));

        // Ensamblar ventana
        add(panelDibujo,    BorderLayout.CENTER);
        add(panelControles, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SierpinskiLab().setVisible(true));
    }
}