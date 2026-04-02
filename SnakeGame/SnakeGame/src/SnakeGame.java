import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener {

    static final int WIDTH = 600;
    static final int HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int DELAY = 100;

    final int x[] = new int[WIDTH * HEIGHT / UNIT_SIZE];
    final int y[] = new int[WIDTH * HEIGHT / UNIT_SIZE];

    int bodyParts = 6;
    int applesEaten;
    int highScore = 0;

    int appleX;
    int appleY;

    char direction = 'R';
    boolean running = false;
    boolean started = false;

    Timer timer;
    Random random;

    public SnakeGame() {
        random = new Random();
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        loadHighScore();
    }

    public void startGame() {
        bodyParts = 6;
        applesEaten = 0;
        direction = 'R';
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!started) {
            drawStartScreen(g);
        } else if (running) {
            drawGame(g);
        } else {
            gameOver(g);
        }
    }

    public void drawStartScreen(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        drawCentered(g, "SNAKE", HEIGHT / 3);

        g.setFont(new Font("Arial", Font.PLAIN, 20));
        drawCentered(g, "Presiona SPACE para comenzar", HEIGHT / 2);
    }

    public void drawGame(Graphics g) {
        // comida
        g.setColor(Color.red);
        g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

        // serpiente
        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) {
                g.setColor(Color.green);
            } else {
                g.setColor(new Color(0, 150, 0));
            }
            g.fillRoundRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE, 10, 10);
        }

        // score
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + applesEaten, 10, 25);
        g.drawString("High Score: " + highScore, 10, 50);
    }

    public void newApple() {
        appleX = random.nextInt(WIDTH / UNIT_SIZE) * UNIT_SIZE;
        appleY = random.nextInt(HEIGHT / UNIT_SIZE) * UNIT_SIZE;
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U': y[0] -= UNIT_SIZE; break;
            case 'D': y[0] += UNIT_SIZE; break;
            case 'L': x[0] -= UNIT_SIZE; break;
            case 'R': x[0] += UNIT_SIZE; break;
        }
    }

    public void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            bodyParts++;
            applesEaten++;

            Toolkit.getDefaultToolkit().beep(); // sonido simple

            newApple();
        }
    }

    public void checkCollisions() {
        for (int i = bodyParts; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                running = false;
            }
        }

        if (x[0] < 0 || x[0] >= WIDTH || y[0] < 0 || y[0] >= HEIGHT) {
            running = false;
        }

        if (!running) {
            timer.stop();
            saveHighScore();
        }
    }

    public void gameOver(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        drawCentered(g, "GAME OVER", HEIGHT / 2);

        g.setFont(new Font("Arial", Font.PLAIN, 20));
        drawCentered(g, "Score: " + applesEaten, HEIGHT / 2 + 40);
        drawCentered(g, "Presiona R para reiniciar", HEIGHT / 2 + 80);
    }

    public void drawCentered(Graphics g, String text, int y) {
        FontMetrics metrics = g.getFontMetrics();
        int x = (WIDTH - metrics.stringWidth(text)) / 2;
        g.drawString(text, x, y);
    }

    public void saveHighScore() {
        if (applesEaten > highScore) {
            highScore = applesEaten;
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("highscore.dat"))) {
            out.writeInt(highScore);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadHighScore() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("highscore.dat"))) {
            highScore = in.readInt();
        } catch (IOException e) {
            highScore = 0;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_SPACE:
                    if (!started) {
                        started = true;
                        startGame();
                    }
                    break;
                case KeyEvent.VK_R:
                    if (!running && started) {
                        startGame();
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') direction = 'L';
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') direction = 'R';
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') direction = 'U';
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') direction = 'D';
                    break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Mejorado");
        SnakeGame game = new SnakeGame();

        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}