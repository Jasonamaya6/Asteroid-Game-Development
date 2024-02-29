import java.util.Random;

/**
 * Saucer file.
 * 
 * @author jasonamaya
 * @version April 14 2023.
 *
 */
public class Saucer extends Enemy {
    public static final int HALF_WIDTH = 10;
    public static final int HALF_HEIGHT = 5;
    public static final int SAUCER_SPEED = 2;
    public static final int SAUCER_POINTS = 400;
    public static final double SPAWN_PROB = 0.002;
    public static final double TURN_PROB = 0.05;

    /**
     * Saucer contructor.
     */
    public Saucer() {
        super((double) SAUCER_SPEED, HALF_WIDTH, SAUCER_POINTS);
    }

    /**
     * Update method.
     */
    public void update() {
        this.pose = pose.move(velocity);
        Random ran = new Random();
        if (ran.nextInt(1, 100) <= 5) {
            this.velocity = this.velocity.newHeading(Math.random());
        }
        if (this.pose.getX() >= GameDriver.SCREEN_WIDTH) {
            this.setDestroyed(true);
        } else if (this.pose.getX() <= 0) {
            this.setDestroyed(true);
        }
        if (this.pose.getY() >= GameDriver.SCREEN_HEIGHT) {
            this.setDestroyed(true);
        } else if (this.pose.getY() <= 0) {
            this.setDestroyed(true);
        }
    }

    /**
     * Draws a rectangle.
     */
    public void draw() {
        StdDraw.rectangle(pose.getX(), pose.getY(), HALF_WIDTH, HALF_HEIGHT);
    }
}