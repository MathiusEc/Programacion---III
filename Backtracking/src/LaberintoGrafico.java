import javax.swing.*;
import java.awt.*;

// File: LaberintoGrafico.java
// Main class. Extends JPanel to draw.
// Contains: main, state variables, constructor.
public class LaberintoGrafico extends JPanel {

    // ── CHALLENGE 1 — Counters and time ──
    int  calls       = 0;
    int  backtracks     = 0;
    long startTime;
    long endTime;

    // ── CHALLENGE 4 — Display metrics ──
    int currentDepth = 0;
    int maxDepth = 0;
    int nodesExplored   = 0;

    // ── CHALLENGE 5 — Exit position ──
    int exitRow = -1;
    int exitCol  = -1;

    // Size of each cell in pixels
    final int CELL_SIZE = 30;

    int[][] maze;

    // Constructor
    public LaberintoGrafico() {
        maze = Laberintos.obtener(Configuracion.TAMANIO);
        findExit();
    }

    // Locates the exit cell (value 2) for the heuristic
    private void findExit() {
        for (int i = 0; i < maze.length; i++)
            for (int j = 0; j < maze[0].length; j++)
                if (maze[i][j] == 2) {
                    exitRow = i;
                    exitCol  = j;
                }
    }

    public static void main(String[] args) {

        JFrame window = new JFrame("Backtracking - Maze");
        LaberintoGrafico panel = new LaberintoGrafico();

        window.add(panel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        new Thread(() -> {

            panel.startTime  = System.nanoTime();
            boolean sol   = Resolver.resolver(panel, 0, 0);
            panel.endTime     = System.nanoTime();

            System.out.println("==========================================");
            System.out.println("  MAZE " + Configuracion.TAMANIO + "x" + Configuracion.TAMANIO);
            System.out.println("  Solution      : " + sol);
            System.out.println("  Calls      : " + panel.calls);
            System.out.println("  Backtracks    : " + panel.backtracks);
            System.out.println("  Nodes         : " + panel.nodesExplored);
            System.out.println("  Max depth  : " + panel.maxDepth);
            System.out.println("  Time (ms)   : " + (panel.endTime - panel.startTime) / 1_000_000.0);
            System.out.println("  Order         : " + Configuracion.ORDEN);
            System.out.println("  Heuristic    : " + Configuracion.HEURISTICA);
            System.out.println("==========================================");

            panel.repaint();

        }).start();
    }

    // CHALLENGE 4 — Draw the board and the metrics panel
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {

                switch (maze[row][col]) {
                    case 0:  g.setColor(Color.WHITE); break; // free
                    case 1:  g.setColor(Color.BLACK); break; // wall
                    case 2:  g.setColor(Color.GREEN); break; // exit
                    case 9:  g.setColor(Color.BLUE);  break; // current path
                    case 5:  g.setColor(Color.RED);   break; // backtrack
                    default: g.setColor(Color.WHITE); break;
                }

                g.fillRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.GRAY);
                g.drawRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }

        // Metrics panel below the board
        int baseY = maze.length * CELL_SIZE;

        g.setColor(new Color(30, 30, 30));
        g.fillRect(0, baseY, getWidth(), 90);

        g.setFont(new Font("Monospaced", Font.BOLD, 13));

        g.setColor(new Color(100, 200, 255));
        g.drawString("Calls: " + calls, 10, baseY + 20);

        g.setColor(new Color(255, 120, 120));
        g.drawString("Backtracks: " + backtracks, 220, baseY + 20);

        g.setColor(new Color(120, 255, 120));
        g.drawString("Nodes: " + nodesExplored, 10, baseY + 42);

        g.setColor(new Color(255, 220, 80));
        g.drawString("Current depth: " + currentDepth, 220, baseY + 42);

        g.setColor(new Color(200, 150, 255));
        g.drawString("Max depth: " + maxDepth, 10, baseY + 64);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Monospaced", Font.PLAIN, 11));
        g.drawString("Order: " + Configuracion.ORDEN + "  Heuristic: " + Configuracion.HEURISTICA,
                10, baseY + 82);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(
                maze[0].length * CELL_SIZE,
                maze.length    * CELL_SIZE + 90
        );
    }

    // Pause for animation
    public void sleep() {
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}