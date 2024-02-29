/**
 * Asteriod file extended from enemy.
 * 
 * @author jasonamaya
 * @version April 14 2023.
 *
 */
public class Asteroid extends Enemy {

    public static final int ASTEROID_SPEED = 1;

    /**
     * Asteriod contructor that takes in a enum Asteriod.
     * 
     * @param asteroidSize creates Asteriod from the enemy file.
     */
    public Asteroid(AsteroidSize asteroidSize) {
        super(ASTEROID_SPEED, asteroidSize.getRadius(), asteroidSize.getPoints());

    }

    /**
     * Updates the Asteriod same as the superclass.
     */
    public void update() {
        super.update();

    }

    /**
     * Draws circle.
     */
    public void draw() {
        StdDraw.setPenRadius(.002);
        StdDraw.circle(this.getPose().getX(), this.getPose().getY(), radius);
    }

}