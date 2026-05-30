import java.awt.*;

/**
 * AlgoritmoSierpinski.java
 *
 * Contains ONLY the recursive logic of the fractal.
 * It knows nothing about windows, panels, or controls.
 *
 * Single responsibility: given a Graphics2D and a level,
 * it recursively draws the Sierpinski Triangle.
 *
 * Algorithm structure
 *
 *   BASE CASE (level == 0)
 *     → Draws the filled triangle and returns.
 *        The stack stops here.
 *
 *   RECURSIVE CASE (level > 0)
 *     1. Calculate 3 midpoints (M1, M2, M3).
 *     2. Draw the central hole with the color of the current level
 *        (allows visualizing the depth of the LIFO stack).
 *     3. Make three recursive calls with level-1:
 *          - upper subtriangle   (A,  M1, M3)
 *          - bottom-left subtriangle    (M1, B,  M2)
 *          - bottom-right subtriangle    (M3, M2, C )
 */

public class AlgoritmoSierpinski {

    /**
     * Public entry point. Configures antialiasing
     * and triggers the first recursive call.
     *
     * @param g2    Graphics context where it is drawn
     * @param nivel Initial recursion depth
     * @param a     Top vertex of the triangle
     * @param b     Bottom-left vertex
     * @param c     Bottom-right vertex
     */
    public void dibujar(Graphics2D g2, int nivel,
                        Point a, Point b, Point c) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        sierpinski(g2, nivel, a, b, c);
    }

    //  PRIVATE RECURSIVE METHOD
    private void sierpinski(Graphics2D g2, int nivel,
                            Point a, Point b, Point c) {

        // BASE CASE
        if (nivel == 0) {
            Color color = Tema.NIVEL_COLORES[0];   // orange

            int[] xs = { a.x, b.x, c.x };
            int[] ys = { a.y, b.y, c.y };

            g2.setColor(color);
            g2.fillPolygon(xs, ys, 3);

            g2.setColor(color.brighter().darker());
            g2.setStroke(new BasicStroke(0.8f));
            g2.drawPolygon(xs, ys, 3);
            return;   // <── stops recursion
        }

        // RECURSIVE CASE

        // Step 1: calculate the 3 midpoints
        //   M1 = middle of A-B (left side)
        //   M2 = middle of B-C (bottom side)
        //   M3 = middle of C-A (right side)
        Point m1 = puntoMedio(a, b);
        Point m2 = puntoMedio(b, c);
        Point m3 = puntoMedio(c, a);

        // Step 2: mark the central hole with the level color
        //         → the color reveals the depth of the LIFO stack
        dibujarHueco(g2, m1, m2, m3, nivel);

        // Step 3: three recursive calls with level - 1
        sierpinski(g2, nivel - 1, a,  m1, m3);   // upper subtriangle
        sierpinski(g2, nivel - 1, m1, b,  m2);   // bottom-left subtriangle
        sierpinski(g2, nivel - 1, m3, m2, c );   // bottom-right subtriangle
    }

    //  HELPER METHODS

    /**
     * Returns the midpoint between P and Q.
     */
    private Point puntoMedio(Point p, Point q) {
        return new Point((p.x + q.x) / 2,
                (p.y + q.y) / 2);
    }

    /**
     * Draws the central "hole" triangle with the level's color.
     * The color changes per level, which visualizes the LIFO traversal
     * of the recursive call stack.
     */
    private void dibujarHueco(Graphics2D g2,
                              Point m1, Point m2, Point m3,
                              int nivel) {
        int[] xs = { m1.x, m2.x, m3.x };
        int[] ys = { m1.y, m2.y, m3.y };

        // Fill with the background to create the visual "hole"
        g2.setColor(Tema.FONDO);
        g2.fillPolygon(xs, ys, 3);

        // Border with the color of the current level
        g2.setColor(Tema.colorDeNivel(nivel).darker());
        g2.setStroke(new BasicStroke(0.6f));
        g2.drawPolygon(xs, ys, 3);
    }


    //  STATIC UTILITIES (stateless, reusable)

    /** Calculates how many triangles are drawn for a level N → 3^N */
    public static long contarTriangulos(int nivel) {
        return (long) Math.pow(3, nivel);
    }

    /** Calculates the total number of recursive calls → Σ 3^i (i=0..nivel) */
    public static long contarLlamadas(int nivel) {
        long total = 0;
        for (int i = 0; i <= nivel; i++) {
            total += (long) Math.pow(3, i);
        }
        return total;
    }
}
