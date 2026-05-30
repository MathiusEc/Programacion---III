import javax.swing.*;
import java.awt.*;

/**
 * PanelDibujo.java
 * Custom JPanel that acts as the fractal's "canvas".
 *
 * Responsibilities:
 *   1. Calculate the vertices of the main triangle
 *      according to the current size of the panel.
 *   2. Delegate the drawing to AlgoritmoSierpinski.
 *   3. Display the level annotation on the screen.
 *
 * It does not contain recursion logic or UI controls.
 */
public class PanelDibujo extends JPanel {
    private int nivel;
    private final AlgoritmoSierpinski algoritmo;

    /**
     * @param nivelInicial Recursion level when the window is opened
     */
    public PanelDibujo(int nivelInicial) {
        this.nivel     = nivelInicial;
        this.algoritmo = new AlgoritmoSierpinski();
        setBackground(Tema.FONDO);
    }

    /** Changes the recursion level and redraws. */
    public void setNivel(int nivel) {
        this.nivel = nivel;
        repaint();
    }

    //  PAINTING
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Calculate the 3 vertices of the main triangle
        // centered and with a margin proportional to the panel size
        Point[] vertices = calcularVertices();
        Point a = vertices[0];   // top
        Point b = vertices[1];   // bottom-left
        Point c = vertices[2];   // bottom-right

        // Delegate the recursive drawing to the algorithm
        algoritmo.dibujar(g2, nivel, a, b, c);
    }

    /**
     * Calculates the vertices A (top), B (bottom-left), C (bottom-right)
     * adapted to the current size of the panel.
     */
    private Point[] calcularVertices() {
        int w = getWidth();
        int h = getHeight();

        // The triangle occupies ~88% of the panel with a uniform margin
        int margen   = (int)(Math.min(w, h) * 0.06);
        int lado     = (int)(Math.min(w - margen * 2,
                (h - margen * 2) * 2.0 / Math.sqrt(3)));
        int alturaT  = (int)(lado * Math.sqrt(3) / 2.0);

        int cx    = w / 2;
        int baseY = (h + alturaT) / 2 - margen / 2;

        return new Point[]{
                new Point(cx,            baseY - alturaT),   // A
                new Point(cx - lado / 2, baseY),             // B
                new Point(cx + lado / 2, baseY)              // C
        };
    }
}
