package snakebyte;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/******************************************************************
 * This class is used in module-04.
 * Update this class to complete the snake game according to the
 * design document description (see Canvas).
 * CLASS DESCRIPTION
 * This class uses an ArrayList to draw the snake body graphics
 * on the game panel.
 ******************************************************************/
public class Snake {

    private Color            bodyColor;
    private Direction        direction;
    private boolean          elongate;
    private boolean          isMoving;
    private ArrayList<Point> snakeBody;

    public static final int  SQUARE     = 8;
    public static final int  START_SIZE = 20;
    public static final int  START_X    = Controller.WIDTH  / 2;
    public static final int  START_Y    = Controller.HEIGHT / 2;

    public Snake() {
        bodyColor  = Color.WHITE;
        isMoving   = false;
        elongate   = false;
        snakeBody  = make();
    }

    public void draw(Graphics _graphics) {
        Graphics2D _pen = (Graphics2D) _graphics;
        _pen.setColor(bodyColor);
        double _x, _y;

        //coordinates to draw snake
        for (int i = 0; i < snakeBody.size(); i++) {
            _x = snakeBody.get(i).getX();
            _y = snakeBody.get(i).getY();
            Rectangle2D body = new Rectangle2D.Double(_x, _y, SQUARE, SQUARE);
            _pen.draw(body);
        }
    }

    public Direction getDirection() {
        //TODO: return direction snake is moving.
        return null;

    }

    public double getX() {
        //TODO: return x location of snake on screen.
        return 0;
    }

    public double getY() {
        //TODO: return y location of snake on screen.
        return 0;
    }

    public void grow(boolean isLonger) {
        //TODO: updates if snake body has to get longer (grow).
    }

    public boolean hasCollision() {
        double x = getX();				// snake head location X
        double y = getY();				// snake head location Y

        for (int i = 1; i < snakeBody.size(); i++) {
            if( snakeBody.get(i).getX() == x && snakeBody.get(i).getY() == y) {
                return true;
            }
        }
        return false;
    }

    public void inMotion(boolean _isMoving) {
        isMoving = _isMoving;
    }

    public boolean isMoving() {
        return isMoving;
    }

    private ArrayList<Point> make() {

        //TODO: create an ArrayLis of points to make the snake body

        //TODO: add starting point (front of snake) to the array list

        //TODO: add each additional point to create the snake body (use loop)

        //TODO: return the starting snake body
        return null;
    }

    public void move() {

        if (isMoving) {

            Point head    	= snakeBody.get(0);
            Point tail   	= snakeBody.get(snakeBody.size() - 1);

            // TODO : create new (x, y) location of head of snakeBody

            // TODO: grow the snake body by one SQUARE when collided with food

        }
    }

    public void setDirection(Direction _direction) {
        direction = _direction;
    }

}
