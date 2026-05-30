// File: Resolver.java
// Main backtracking algorithm.
// Integrates: Challenge 1 (counters), Challenge 2 (order),
//          Challenge 4 (depth), Challenge 5 (heuristic)
public class Resolver {

    public static boolean resolver(LaberintoGrafico panel, int row, int col) {

        panel.repaint();
        panel.sleep();

        // Out of bounds
        if (row < 0 || col < 0 ||
                row >= panel.maze.length ||
                col  >= panel.maze[0].length) {
            return false;
        }

        // Wall or already visited
        if (panel.maze[row][col] == 1 ||
                panel.maze[row][col] == 9 ||
                panel.maze[row][col] == 5) {
            return false;
        }

        // CHALLENGE 1 — count valid calls
        panel.calls++;

        // CHALLENGE 4 — update depth
        panel.currentDepth++;
        if (panel.currentDepth > panel.maxDepth)
            panel.maxDepth = panel.currentDepth;

        // Exit found
        if (panel.maze[row][col] == 2) {
            panel.currentDepth--;
            return true;
        }

        // Mark cell as part of the current path
        panel.maze[row][col] = 9;

        // CHALLENGE 4 — count explored nodes
        panel.nodesExplored++;

        panel.repaint();
        panel.sleep();

        // CHALLENGE 2 + CHALLENGE 5 — get directions
        int[][] dirs = getDirections(panel, row, col);

        for (int[] d : dirs) {
            if (resolver(panel, row + d[0], col + d[1])) {
                panel.currentDepth--;
                return true;
            }
        }

        // CHALLENGE 1 — count backtracks
        panel.backtracks++;

        // Visual backtracking
        panel.maze[row][col] = 5;

        panel.repaint();
        panel.sleep();

        panel.currentDepth--;
        return false;
    }

    // CHALLENGE 2 — Configurable exploration order
    // CHALLENGE 5 — Manhattan distance heuristic
    private static int[][] getDirections(LaberintoGrafico panel, int row, int col) {

        // {deltaRow, deltaCol}
        int[][] original = {{-1,0},{0,1},{1,0},{0,-1}}; // up, right, down, left
        int[][] right  = {{0,1},{1,0},{-1,0},{0,-1}}; // right first
        int[][] down    = {{1,0},{0,1},{-1,0},{0,-1}}; // down first

        int[][] base;
        switch (Configuracion.ORDEN) {
            case "DERECHA": base = right; break;
            case "ABAJO":   base = down;   break;
            default:        base = original; break;
        }

        // CHALLENGE 5 — reorder by Manhattan distance to the exit
        if (Configuracion.HEURISTICA && panel.exitRow >= 0) {
            int[][] dirs = base.clone();
            java.util.Arrays.sort(dirs, (a, b) -> {
                int dA = Math.abs((row + a[0]) - panel.exitRow)
                        + Math.abs((col  + a[1]) - panel.exitCol);
                int dB = Math.abs((row + b[0]) - panel.exitRow)
                        + Math.abs((col  + b[1]) - panel.exitCol);
                return Integer.compare(dA, dB);
            });
            return dirs;
        }

        return base;
    }
}
