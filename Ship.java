/**
 * Ship file.
 * 
 * @author jasonamaya
 * @version April 10, 2023.
 *
 */
public class Ship extends GameElement {

    public static final int SHIP_WIDTH = 10;
    public static final int SHIP_HEIGHT = 20;
    public static final double SHIP_TURN = 0.1;
    public static final double SHIP_MOVE = 0.1;
    public static final double FRICTION = 0.02;

    /**
     * Ship extended from game elements.
     */
    public Ship() {
        super(new Pose(GameDriver.SCREEN_WIDTH / 2, GameDriver.SCREEN_HEIGHT / 2, Math.PI / 2),
                new Vector2D(Math.PI, 0), SHIP_HEIGHT / 2);
    }

    /**
     * Turns the ship to the left. Implements the new heading method from pose.
     */
    public void turnLeft() {
        this.pose = this.getPose().newHeading(this.getPose().getHeading() + SHIP_TURN);

    }

    /**
     * Turns the ship to the right and also uses the new heading method from pose.
     */
    public void turnRight() {
        this.pose = this.getPose().newHeading(this.getPose().getHeading() - SHIP_TURN);

    }

    /**
     * Update method extended from game element and checks the magnitude subtracted by friction, if less then 0 new
     * maginitude created otherwise it uses the inital maginitude value.
     */
    public void update() {
        super.update();
        double magFriction = this.velocity.getMagnitude() - FRICTION;
        if (magFriction < 0) {
            magFriction = 0;
        }
        this.velocity = this.velocity.newMagnitude(magFriction);
    }

    /**
     * Thurst method creates new vector2d and the velocity is added to it.
     */
    public void thrust() {
        Vector2D vec = new Vector2D(this.pose.getHeading(), SHIP_MOVE);
        this.velocity = this.velocity.add(vec);

    }

    /**
     * Draws triangle.
     */
    public void draw() {
        GameUtils.drawPoseAsTriangle(this.pose, SHIP_WIDTH, SHIP_HEIGHT);

    }

}
