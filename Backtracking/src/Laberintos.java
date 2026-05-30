// File: Laberintos.java
// Contains all the mazes for the lab.
// 0 = free | 1 = wall | 2 = exit
public class Laberintos {
    public static int[][] obtener(int size) {

        // ── CHALLENGE 1 ── 5x5 Maze
        if (size == 5) {
            return new int[][] {
                    {0, 1, 0, 0, 0},
                    {0, 1, 0, 1, 0},
                    {0, 0, 0, 1, 0},
                    {1, 1, 0, 1, 0},
                    {0, 0, 0, 0, 2}
            };
        }

        // ── CHALLENGE 1 ── 10x10 Maze
        if (size == 10) {
            return new int[][] {
                    {0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                    {0, 1, 0, 1, 1, 0, 1, 0, 1, 0},
                    {0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
                    {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                    {0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                    {0, 1, 1, 1, 1, 0, 1, 0, 0, 0},
                    {0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                    {1, 1, 1, 0, 1, 1, 1, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                    {0, 1, 1, 1, 1, 0, 0, 0, 0, 2}
            };
        }

        // ── CHALLENGE 1 ── 20x20 Maze
        if (size == 20) {
            int[][] m = new int[20][20];
            for (int i = 0; i < 20; i++)
                for (int j = 0; j < 20; j++)
                    m[i][j] = (i % 2 == 1 && j % 3 != 2) ? 1 : 0;
            m[0][0]   = 0;
            m[19][19] = 2;
            return m;
        }

        // ── CHALLENGE 3 ── Impossible maze (blocked exit)
        if (size == -1) {
            return new int[][] {
                    {0, 1, 0, 0, 0, 0},
                    {0, 1, 0, 1, 1, 0},
                    {0, 0, 0, 0, 1, 0},
                    {1, 1, 1, 0, 1, 1},
                    {0, 0, 0, 0, 1, 1},
                    {0, 1, 1, 1, 1, 2}
            };
        }

        // ── DEFAULT ── 6x6 Maze (original from the teacher)
        return new int[][] {
                {0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {1, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 2}
        };
    }
}
