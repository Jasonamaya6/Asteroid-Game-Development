/**
 * Star class file.
 * 
 * @author jasonamaya
 * @version March 30 2023
 *
 */
public class Star implements Drawable {

    public static final int STAR_RADIUS = 1;
    private Point location;

    /**
     * Star constructor.
     * 
     * @param x double xpos that will be put into a new Point.
     * @param y double ypos that will be put into a new Point
     */
    public Star(double x, double y) {
        this.location = new Point(x, y);

    }

    public Point getLocation() {
        return this.location;
    }

    /**
     * implemented method that draws.
     */
    public void draw() {
        StdDraw.filledCircle(location.getX(), location.getY(), STAR_RADIUS);

    }

}
