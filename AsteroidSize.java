import java.util.Random;

/**
 * Asteriod enum of size.
 * 
 * @author jasonamaya
 * @version April 14 2023.
 *
 */
public enum AsteroidSize {
    SMALL(10, 200), MEDIUM(20, 100), LARGE(30, 50);

    private int radius;
    private int points;

    /**
     * Asteriod constructor.
     * 
     * @param radius direction.
     * @param points worth of points.
     */
    private AsteroidSize(int radius, int points) {
        this.radius = radius;
        this.points = points;
    }

    /**
     * Getter for radius.
     * 
     * @return returns radius.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Getter.
     * 
     * @return points.
     */
    public int getPoints() {
        return points;
    }

    /**
     * The asteriod size.
     * 
     * @return based on the random num it choose the size.
     */
    public static AsteroidSize randomSize() {
        Random r = new Random();
        int chance = r.nextInt(4);
        if (chance == 0) {
            return AsteroidSize.SMALL;
        } else if (chance == 1) {
            return AsteroidSize.MEDIUM;
        } else {
            return AsteroidSize.LARGE;
        }
    }

}