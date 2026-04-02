// Import necessary libraries for GUI components, graphics, event handling, file I/O, and random number generation
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;

/**
 * SnakeGame: A classic Snake game implemented in Java using Swing and AWT
 * The player controls a snake to eat apples, growing longer with each apple consumed.
 * The game ends if the snake hits itself or the walls.
 * Extends JPanel to provide a drawing canvas and implements ActionListener for game loop timing
 */
public class SnakeGame extends JPanel implements ActionListener {

    // ===== GAME CONSTANTS =====
    // These values define the game window dimensions and grid unit size
    static final int WIDTH = 600;              // Window width in pixels
    static final int HEIGHT = 600;             // Window height in pixels
    static final int UNIT_SIZE = 25;           // Size of each grid square (for snake segments and apple)
    static final int DELAY = 100;              // Game loop update interval in milliseconds (10 updates per second)

    // ===== SNAKE POSITION ARRAYS =====
    // Store the X and Y coordinates of each snake segment
    // Maximum possible segments: (600*600) / (25*25) = 576 segments
    final int x[] = new int[WIDTH * HEIGHT / UNIT_SIZE];
    final int y[] = new int[WIDTH * HEIGHT / UNIT_SIZE];

    // ===== GAME STATE VARIABLES =====
    int bodyParts = 6;              // Current number of snake segments (starts with 6)
    int applesEaten;                // Counter for apples eaten in current game
    int highScore = 0;              // Highest score achieved (loaded from file)

    // ===== APPLE POSITION =====
    int appleX;                     // X coordinate of the apple
    int appleY;                     // Y coordinate of the apple

    // ===== DIRECTION AND GAME STATUS =====
    char direction = 'R';           // Current snake direction: 'R'(Right), 'L'(Left), 'U'(Up), 'D'(Down)
    boolean running = false;        // Flag: true if game is currently active
    boolean started = false;        // Flag: true if player has started the game (not on start screen)

    // ===== GAME TIMER AND UTILITIES =====
    Timer timer;                    // Timer that triggers the game loop at regular intervals
    Random random;                  // Random number generator for apple placement

    /**
     * Constructor: Initialize the game panel with visual settings and load saved high score
     * This method is called when SnakeGame object is created
     */
    public SnakeGame() {
        // Create random number generator instance
        random = new Random();

        // Set the preferred window size to 600x600 pixels
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // Set background color to black
        this.setBackground(Color.black);

        // Allow this panel to receive keyboard input (focus)
        this.setFocusable(true);

        // Register the custom key listener to detect arrow keys and other inputs
        this.addKeyListener(new MyKeyAdapter());

        // Load the previously saved high score from file (or default to 0)
        loadHighScore();
    }

    /**
     * startGame(): Initialize and start a new game
     * Resets all game variables to their initial state and starts the game loop
     * This method is called when the player presses SPACE or R
     */
    public void startGame() {
        // Reset snake to initial length of 6 segments
        bodyParts = 6;

        // Reset apple counter to 0 for new game
        applesEaten = 0;

        // Set initial direction to RIGHT
        direction = 'R';

        // Generate a random position for the first apple
        newApple();

        // Set the game running flag to true so game loop executes
        running = true;

        // Create and start the game timer that triggers actionPerformed() every DELAY milliseconds
        timer = new Timer(DELAY, this);
        timer.start();
    }

    /**
     * paintComponent(Graphics g): Main rendering method called by Swing whenever screen needs refresh
     * This method decides what to draw based on the current game state
     * It's automatically called when repaint() is invoked
     */
    public void paintComponent(Graphics g) {
        // Call parent class's paintComponent to clear the panel
        super.paintComponent(g);

        // Check game state and draw appropriate screen
        if (!started) {
            // Player hasn't pressed SPACE yet - show start screen
            drawStartScreen(g);
        } else if (running) {
            // Game is active - draw game elements (snake, apple, scores)
            drawGame(g);
        } else {
            // Game ended - show game over screen
            gameOver(g);
        }
    }

    /**
     * drawStartScreen(Graphics g): Display the initial game menu
     * Shows the game title and instructions to start
     */
    public void drawStartScreen(Graphics g) {
        // Set text color to white
        g.setColor(Color.white);

        // Set large bold font for title
        g.setFont(new Font("Arial", Font.BOLD, 40));

        // Draw "SNAKE" title centered at 1/3 down the screen
        drawCentered(g, "SNAKE", HEIGHT / 3);

        // Set smaller regular font for instructions
        g.setFont(new Font("Arial", Font.PLAIN, 20));

        // Draw instruction text centered at middle of screen
        drawCentered(g, "Presiona SPACE para comenzar", HEIGHT / 2);
    }

    /**
     * drawGame(Graphics g): Render all active game elements during gameplay
     * Draws the apple, snake body, and current scores on screen
     */
    public void drawGame(Graphics g) {
        // ===== DRAW APPLE =====
        // Set apple color to red
        g.setColor(Color.red);

        // Draw apple as a circle (fillOval creates a circle when width equals height)
        g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

        // ===== DRAW SNAKE BODY =====
        // Loop through each segment of the snake
        for (int i = 0; i < bodyParts; i++) {
            // First segment (head) is bright green
            if (i == 0) {
                g.setColor(Color.green);
            } else {
                // Body segments are darker green for visual distinction
                g.setColor(new Color(0, 150, 0));
            }

            // Draw each segment as a rounded rectangle for smooth appearance
            // Parameters: x, y, width, height, arcWidth, arcHeight (for rounded corners)
            g.fillRoundRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE, 10, 10);
        }

        // ===== DRAW SCORE INFORMATION =====
        // Set text color to white for visibility on black background
        g.setColor(Color.white);

        // Set bold font for score display
        g.setFont(new Font("Arial", Font.BOLD, 20));

        // Draw current score at top-left (10 pixels from left, 25 pixels from top)
        g.drawString("Score: " + applesEaten, 10, 25);

        // Draw high score below current score
        g.drawString("High Score: " + highScore, 10, 50);
    }

    /**
     * newApple(): Generate a random position for a new apple on the grid
     * Uses random coordinates that align with the grid unit size
     * This ensures the apple always appears centered on a grid square
     */
    public void newApple() {
        // Generate random X coordinate:
        // - random.nextInt(WIDTH / UNIT_SIZE) gives 0 to 23 (600/25 = 24 possible positions)
        // - Multiply by UNIT_SIZE to get actual pixel coordinate (always multiple of 25)
        appleX = random.nextInt(WIDTH / UNIT_SIZE) * UNIT_SIZE;

        // Generate random Y coordinate using same logic
        appleY = random.nextInt(HEIGHT / UNIT_SIZE) * UNIT_SIZE;
    }

    /**
     * move(): Update snake position each game tick
     * Shifts all body segments forward and moves head in the current direction
     * This creates the illusion of the snake moving while maintaining its structure
     */
    public void move() {
        // Shift body segments: move each segment to the position of the one in front
        // Loop backwards (from tail to head) to avoid overwriting coordinates
        // If we looped forward, we'd copy the same coordinate multiple times
        for (int i = bodyParts; i > 0; i--) {
            // Each segment takes the position of the segment ahead
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        // Move the head (segment 0) based on current direction
        // UNIT_SIZE is 25 pixels, so head moves in 25-pixel increments
        switch (direction) {
            case 'U': y[0] -= UNIT_SIZE; break;   // Move UP: decrease Y coordinate
            case 'D': y[0] += UNIT_SIZE; break;   // Move DOWN: increase Y coordinate
            case 'L': x[0] -= UNIT_SIZE; break;   // Move LEFT: decrease X coordinate
            case 'R': x[0] += UNIT_SIZE; break;   // Move RIGHT: increase X coordinate
        }
    }

    /**
     * checkApple(): Check if snake head has eaten the apple
     * If eaten: grow snake, increment score, play sound, generate new apple
     */
    public void checkApple() {
        // Compare snake head position with apple position
        if (x[0] == appleX && y[0] == appleY) {
            // Increase snake length by one segment
            bodyParts++;

            // Increment the apple/food counter
            applesEaten++;

            // Play a simple beep sound to provide audio feedback
            Toolkit.getDefaultToolkit().beep();

            // Generate a new apple at a random location
            newApple();
        }
    }

    /**
     * checkCollisions(): Detect game-ending collision conditions
     * Checks for self-collision and boundary collisions
     * When collision occurs: stop game, save high score
     */
    public void checkCollisions() {
        // ===== CHECK SELF-COLLISION =====
        // Loop through all body segments (starting from segment 1, not the head)
        for (int i = bodyParts; i > 0; i--) {
            // If head position matches any body segment position
            if (x[0] == x[i] && y[0] == y[i]) {
                // Snake hit itself - game over!
                running = false;
            }
        }

        // ===== CHECK BOUNDARY COLLISION =====
        // Test if head goes outside the game boundary
        if (x[0] < 0 ||                    // Hit left wall
            x[0] >= WIDTH ||               // Hit right wall
            y[0] < 0 ||                    // Hit top wall
            y[0] >= HEIGHT) {              // Hit bottom wall
            // Snake hit a wall - game over!
            running = false;
        }

        // ===== HANDLE GAME END =====
        // If a collision was detected above, running becomes false
        if (!running) {
            // Stop the timer (stops calling actionPerformed)
            timer.stop();

            // Save the high score if current score is better
            saveHighScore();
        }
    }

    /**
     * gameOver(Graphics g): Display the game over screen with score information
     * Shows the player's final score and instructions to restart
     */
    public void gameOver(Graphics g) {
        // Set text color to red for game over message
        g.setColor(Color.red);

        // Set large bold font
        g.setFont(new Font("Arial", Font.BOLD, 40));

        // Draw "GAME OVER" message centered at middle of screen
        drawCentered(g, "GAME OVER", HEIGHT / 2);

        // Set smaller regular font for score information
        g.setFont(new Font("Arial", Font.PLAIN, 20));

        // Draw final score below game over message
        drawCentered(g, "Score: " + applesEaten, HEIGHT / 2 + 40);

        // Draw restart instruction below score
        drawCentered(g, "Presiona R para reiniciar", HEIGHT / 2 + 80);
    }

    /**
     * drawCentered(Graphics g, String text, int y): Helper method to center text horizontally
     * Calculates the X position needed to center the text on screen
     * @param g - Graphics object for drawing
     * @param text - The text string to draw
     * @param y - The Y coordinate where text should appear
     */
    public void drawCentered(Graphics g, String text, int y) {
        // Get font metrics to calculate text width
        FontMetrics metrics = g.getFontMetrics();

        // Calculate X position: (screen width - text width) / 2
        // This centers the text horizontally
        int x = (WIDTH - metrics.stringWidth(text)) / 2;

        // Draw the text at calculated centered position
        g.drawString(text, x, y);
    }

    /**
     * saveHighScore(): Save the high score to a binary file
     * If the current game score is better than the saved high score, it updates and saves it
     * Uses ObjectOutputStream to serialize the integer value to "highscore.dat"
     */
    public void saveHighScore() {
        // Check if current game score beats the previous high score
        if (applesEaten > highScore) {
            // Update high score variable with new record
            highScore = applesEaten;
        }

        // Try-with-resources: automatically closes the stream after use
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("highscore.dat"))) {
            // Write the high score as a binary integer to the file
            out.writeInt(highScore);
        } catch (IOException e) {
            // If file operations fail (e.g., no write permission), print error details
            e.printStackTrace();
        }
    }

    /**
     * loadHighScore(): Load the previously saved high score from file
     * Called during game initialization to restore the player's record
     * If file doesn't exist or is corrupted, defaults to 0
     */
    public void loadHighScore() {
        // Try-with-resources: automatically closes the stream after use
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("highscore.dat"))) {
            // Read the high score as a binary integer from the file
            highScore = in.readInt();
        } catch (IOException e) {
            // If file doesn't exist or can't be read (first time playing):
            // Set high score to 0 (this is the default/fallback value)
            highScore = 0;
        }
    }

    /**
     * actionPerformed(ActionEvent e): Called by the Timer at regular intervals (every DELAY ms)
     * This is the main game loop - executes game logic and redraws screen
     * Implements the ActionListener interface requirement
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Only execute game logic if the game is currently running
        if (running) {
            // Update snake position based on current direction
            move();

            // Check if snake head collides with the apple
            checkApple();

            // Check if snake collided with itself or the walls
            checkCollisions();
        }

        // Redraw the entire game screen (calls paintComponent)
        // This happens every game tick regardless of running state
        repaint();
    }

    /**
     * MyKeyAdapter: Inner class that extends KeyAdapter to handle keyboard input
     * Detects arrow keys (direction control) and SPACE/R keys (game start/restart)
     * Uses event-driven programming to respond to player actions
     */
    public class MyKeyAdapter extends KeyAdapter {
        /**
         * keyPressed(KeyEvent e): Called when any key is pressed on the keyboard
         * Routes input to appropriate game actions based on which key was pressed
         */
        public void keyPressed(KeyEvent e) {
            // Use switch statement to handle different key codes
            switch (e.getKeyCode()) {
                // ===== SPACE KEY: START GAME =====
                case KeyEvent.VK_SPACE:
                    // Only start if player hasn't started yet (prevents interrupting gameplay)
                    if (!started) {
                        // Mark that player has entered the game
                        started = true;

                        // Initialize and begin the game
                        startGame();
                    }
                    break;

                // ===== R KEY: RESTART GAME =====
                case KeyEvent.VK_R:
                    // Only restart if game is over (not running) AND player already started at least once
                    if (!running && started) {
                        // Reset everything and start a new game
                        startGame();
                    }
                    break;

                // ===== LEFT ARROW: MOVE LEFT =====
                case KeyEvent.VK_LEFT:
                    // Prevent snake from reversing into itself (can't go left if moving right)
                    if (direction != 'R') direction = 'L';
                    break;

                // ===== RIGHT ARROW: MOVE RIGHT =====
                case KeyEvent.VK_RIGHT:
                    // Prevent snake from reversing into itself (can't go right if moving left)
                    if (direction != 'L') direction = 'R';
                    break;

                // ===== UP ARROW: MOVE UP =====
                case KeyEvent.VK_UP:
                    // Prevent snake from reversing into itself (can't go up if moving down)
                    if (direction != 'D') direction = 'U';
                    break;

                // ===== DOWN ARROW: MOVE DOWN =====
                case KeyEvent.VK_DOWN:
                    // Prevent snake from reversing into itself (can't go down if moving up)
                    if (direction != 'U') direction = 'D';
                    break;
            }
        }
    }

    /**
     * main(String[] args): Entry point of the application
     * Creates the game window and initializes the game
     * This method runs when you execute the program
     */
    public static void main(String[] args) {
        // Create a new window (frame) with a title
        JFrame frame = new JFrame("Snake Mejorado");

        // Create an instance of SnakeGame (which is a JPanel)
        SnakeGame game = new SnakeGame();

        // Add the game panel to the window
        frame.add(game);

        // Set behavior when close button is clicked: exit the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Automatically size the window to fit the game panel contents
        frame.pack();

        // Center the window on the screen
        frame.setLocationRelativeTo(null);

        // Prevent player from resizing the window (keeps game grid consistent)
        frame.setResizable(false);

        // Make the window visible to the user
        frame.setVisible(true);
    }
}
