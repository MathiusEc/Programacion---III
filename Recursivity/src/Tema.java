import java.awt.*;

/**
 * Tema.java
 * Visual constants shared throughout the application.
 *
 * Centralizing colors here avoids repeating them in each class
 * and makes changing the theme a single edit.
 */

public class Tema {
    // Background and border colors
    public static final Color FONDO         = new Color(0x0F1923);
    public static final Color FONDO_PANEL   = new Color(0x1A2636);
    public static final Color BORDE         = new Color(0x1E3A5F);

    /**
     * Palette by recursion level.
     * Index 0 = base case (deepest level of the stack).
     * Each higher index corresponds to a level closer to the root.
     *
     *   NIVEL_COLORES[0]  → orange    (base case)
     *   NIVEL_COLORES[1]  → cyan       (level 1)
     *   NIVEL_COLORES[2]  → navy blue(level 2)
     *   NIVEL_COLORES[3]  → violet    (level 3)
     *   NIVEL_COLORES[4]  → emerald  (level 4)
     *   NIVEL_COLORES[5]  → amber      (level 5)
     */
    public static final Color[] NIVEL_COLORES = {
            new Color(0xFF6B35),   // orange   – level 0
            new Color(0x06B6D4),   // cyan      – level 1
            new Color(0x1E3A5F),   // blue      – level 2
            new Color(0x7C3AED),   // violet   – level 3
            new Color(0x059669),   // emerald – level 4
            new Color(0xF59E0B),   // amber     – level 5
    };

    /** Returns the color for the given level (with index protection). */
    public static Color colorDeNivel(int nivel) {
        int idx = Math.min(Math.abs(nivel), NIVEL_COLORES.length - 1);
        return NIVEL_COLORES[idx];
    }

    // Private constructor: this class only has static constants.
    private Tema() {}
}
