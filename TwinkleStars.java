import java.util.Random;

public class TwinkleStars extends Star {

    public TwinkleStars(double xPos, double yPos) {
        super(xPos, yPos);

    }

    public void draw() {
        Random x = new Random();

        int randomNum = x.nextInt(10);
        if (randomNum == 5) {
            StdDraw.setPenColor(StdDraw.YELLOW);
        }
        if (randomNum == 3) {
            StdDraw.setPenColor(StdDraw.BLUE);
        }

    }

}
