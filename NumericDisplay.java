/**
 * Numeric Display class.
 * 
 * @author jasonamaya
 * @version April 3, 2023.
 *
 */
public class NumericDisplay implements Drawable {

    private String prefix;
    private int value;
    private Point location;

    /**
     * Numeric display contructor.
     * 
     * @param xPos the x postion of the point.
     * @param yPos the y position of the point.
     * @param prefix string for the draw.
     * @param value int that will be in the draw method.
     * 
     */
    public NumericDisplay(int xPos, int yPos, String prefix, int value) {
        this.prefix = prefix;
        this.value = value;
        this.location = new Point(xPos, yPos);
    }

    public Point getLocation() {
        return location;
    }

    public int getValue() {
        return value;
    }

    /**
     * Setter for the value variable.
     * 
     * @param value int parameter.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * implemented method that draws.
     */
    public void draw() {
        StdDraw.textLeft(location.getX(), location.getY(), prefix + value);

    }

}
