/**
 * Enemy class.
 * 
 * @author jasonamaya
 * @version April 14 2023.
 *
 */
public abstract class Enemy extends GameElement {

    protected int points;

    /**
     * Enemy constrctor.
     * 
     * @param speed speed of the enemy,
     * @param radius direction of the pose.
     * @param points worth of points the user gets.
     */
    public Enemy(double speed, double radius, int points) {
        super(new Pose(AsteroidsGame.randomXPosition(), AsteroidsGame.randomXPosition(), AsteroidsGame.randomHeading()),
                new Vector2D(AsteroidsGame.randomHeading() * (Math.PI / 2), speed), radius);
        this.points = points;
    }

    /**
     * Getter for points.
     * 
     * @return points.
     */
    public int getPoints() {
        return points;
    }
}