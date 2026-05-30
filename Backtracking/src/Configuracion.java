// File: Configuracion.java
// Centralizes the parameters of all challenges.
// Only change here to change the behavior.
public class Configuracion {

    // CHALLENGE 1 — Maze size
    // Valid values: 5 | 6 | 10 | 20 | -1 (impossible)
    public static int TAMANIO = 20;

    // CHALLENGE 2 — Exploration order
    // Valid values: "ORIGINAL" | "RIGHT" | "DOWN"
    public static String ORDEN = "ORIGINAL";

    // CHALLENGE 5 — Manhattan distance heuristic
    // Valid values: false | true
    public static boolean HEURISTICA = false;

}
