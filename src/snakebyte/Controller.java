package snakebyte;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/******************************************************************
 * This class is used in module-04.
 * Update this class to complete the snake game according to the
 * design document description (see Canvas).
 * CLASS DESCRIPTION
 * This class is the event controller for the snake game.
 ******************************************************************/
public class Controller implements KeyListener{

    public 	static final int HEIGHT  = GamePanel.HEIGHT;
    public 	static final int WIDTH   = GamePanel.WIDTH;
    public 	static final int DELAY   = 50;

    JButton gameButton;
    JPanel  lowerPanel;
    private Food       food;
    private GamePanel  game;
    private Snake 	   snake;
    private Timer 	   timer;

    public Controller(GamePanel newGame) {
        game        = newGame;
        gameButton  = new JButton("New Game");
        lowerPanel  = new JPanel();

        //FIXME: UPDATE with correct functional programming to animate using timer
        timer 	    = new Timer(DELAY, e -> {});
        snake       = game.snake;
        food        = game.food;
        timer.start();
        timer.setCoalesce(true);

        gameButton.setFont(new Font("Helvetica", Font.PLAIN, 16));
        gameButton.setMargin(new Insets(20, 20 , 20 , 20));

        //FIXME: UPDATE with correct functional programming to create new game
        gameButton.addActionListener(e -> {});
        lowerPanel.add(gameButton);
    }

    private void animate() {
        //TODO: repaint game

        //TODO: check collisions

        //TODO: what to do, if game over or not over

    }

    public void checkCollisions() {
        double xMax = WIDTH - 2 * Snake.SQUARE;
        double yMax = WIDTH - 2 * Snake.SQUARE;

        //TODO: check for snake collisions on game panel

        //TODO: if game over stop timer
    }

    public void createNewGame(){
        SwingUtilities.invokeLater(Viewer::new);
    }


    public void keyPressed(KeyEvent event) {
        int keyPress = event.getKeyCode();

        //TODO: create motion for snake motion, UP, DOWN, LEFT, RIGHT

        //NOTE: Snake starts/points to the left, don't want to reverse back
        //      unto itself.

        //TODO: stop timer if game paused, restart timer after pause.

        game.repaint();
    }

    //These key detection responses not used.
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

}
