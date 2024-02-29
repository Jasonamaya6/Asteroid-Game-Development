/**
 * Bullet file class.
 * 
 * @author jasonamaya
 * @version April 10 2023
 *
 */
public class Bullet extends GameElement {

    public static final double BULLET_RADIUS = 1.5;
    public static final int BULLET_SPEED = 20;
    public static final int BULLET_DURATION = 20;
    private int counter;

    /**
     * Bullet constructor used from game element that take in the parameter pose, to create the constructor.
     * 
     * @param pose Pose object that is being passed.
     */
    public Bullet(Pose pose) {
        super(new Pose(pose.getX(), pose.getY(), pose.getHeading()), new Vector2D(pose.getHeading(), BULLET_SPEED),
                BULLET_RADIUS);
        counter = 0;
    }

    /**
     * Update method that is implemented from game element and checks if counter has less then 20 updates anything more
     * it implements the setDestoryed method.
     */
    public void update() {
        super.update();
        counter++;
        if (counter >= BULLET_DURATION) {
            this.setDestroyed(true);
        }
    }

    /**
     * Draws a filled circle.
     */
    public void draw() {
        StdDraw.filledCircle(this.getPose().getX(), this.getPose().getY(), BULLET_RADIUS);

    }

}
