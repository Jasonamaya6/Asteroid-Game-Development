/**
 * Game Element file.
 * 
 * @author jason amaya.
 * @version March 30, 2023
 */
abstract class GameElement implements Updatable, Drawable {

    protected Pose pose;
    protected Vector2D velocity;
    protected double radius;
    protected boolean destroyed;

    /**
     * Game element constructor.
     * 
     * @param pose instantiates a pose variable.
     * @param velocity instantiates a pose velocity.
     * @param radius instantiates a pose radius.
     */
    public GameElement(Pose pose, Vector2D velocity, double radius) {
        this.pose = pose;
        this.velocity = velocity;
        this.radius = radius;

    }

    public Pose getPose() {
        return this.pose;
    }

    public Vector2D getVelocity() {
        return this.velocity;
    }

    public double getRadius() {
        return this.radius;
    }

    public boolean isDestroyed() {
        return destroyed;

    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;

    }

    /**
     * Checks the collison returns true or not.
     * 
     * @param other Another Game element parameter to check
     * @return true or false.
     */
    public boolean checkCollision(GameElement other) {
        double dis = Math.sqrt(Math.pow(this.getPose().getX() - other.getPose().getX(), 2)
                + Math.pow(this.getPose().getY() - other.getPose().getY(), 2));
        double between = (this.radius + other.radius);
        if (between > dis) {
            return true;
        }
        return false;
    }

    /**
     * Update returns the pose to the opposite side of where it goes from the edges.
     */
    public void update() {
        pose = pose.move(velocity);

        if (pose.getX() >= GameDriver.SCREEN_WIDTH) {
            pose = pose.newX(0);
        } else if (this.getPose().getX() <= 0) {
            pose = pose.newX(GameDriver.SCREEN_WIDTH);
        }
        if (this.getPose().getY() >= GameDriver.SCREEN_WIDTH) {
            pose = pose.newY(0);
        } else if (this.getPose().getY() <= 0) {
            pose = pose.newY(GameDriver.SCREEN_WIDTH);
        }
    }
}
