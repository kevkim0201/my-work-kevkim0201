package snakebyte;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/******************************************************************
 * This class is used in module-04.
 * Update this class to complete the snake game according to the
 * design document description (see Canvas).
 * CLASS DESCRIPTION
 * This class is used to draw the food graphics on the game panel.
 ******************************************************************/
public class Food {

    private double  n;
    private double  x;
    private double  y;
    private int    	score;
    private Snake  	snake;

    private Color foodColor;
    public static final int SIZE  = 10;

    public Food(Snake _snake) {
        foodColor = Color.GREEN;
        n         = 1.5;
        score 	  = 0;
        snake 	  = _snake;
        setLocation();
    }

    public void checkCollision() {
        double snakeHeadX = snake.getX() + Snake.SQUARE / 2.0;
        double snakeHeadY = snake.getY() + Snake.SQUARE / 2.0;

        //TODO: create logic for snake collision with the food.
        //TODO: increment score when snake collides with food.
        //TODO: grow snake when snake collides with food.
    }


    public void draw(Graphics _graphics) {
        Graphics2D 	pen 	= (Graphics2D) _graphics;
        Rectangle2D food 	= new Rectangle2D.Double(x, y, SIZE, SIZE);
        //draw food
        pen.setColor(foodColor);
        pen.fill(food);
    }

    /**
     * return current score of game.
     * @return score of current game
     */
    public int getScore() {
        return score;
    }

    /**
     * set random location for the snake food on screen.
     */
    public void setLocation() {

        x     =  (Math.random() * (Controller.WIDTH  - n * SIZE ));
        y     =  (Math.random() * (Controller.HEIGHT - n * SIZE ));

        if (x < 0) {
            x = -x;
        }
        if (x > Controller.WIDTH - SIZE) {
            x = Controller.WIDTH - 2 * SIZE;
        }
        if (y < 0) {
            y = -y;
        }
        if (y > Controller.HEIGHT - SIZE) {
            y = Controller.HEIGHT - 2 * SIZE;
        }
    }
}
