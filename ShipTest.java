import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ShipTest {

    @Test
    public void testConstants() {
        assertEquals(10, Ship.SHIP_WIDTH);
        assertEquals(20, Ship.SHIP_HEIGHT);
        assertEquals(0.1, Ship.SHIP_TURN, 0.001);
        assertEquals(0.1, Ship.SHIP_MOVE, 0.001);
        assertEquals(0.02, Ship.FRICTION, 0.001);
    }

    @Test
    final void testUpdate() {
        Ship s = new Ship();
        s.update();
        s.thrust();
        s.update();
        assertTrue(s.velocity.getMagnitude() >= 0);
    }

    @Test
    final void testShip() {
        Ship ship = new Ship();
        Pose pose = ship.getPose();
        assertEquals(GameDriver.SCREEN_WIDTH / 2, pose.getX(), 0.01);
        assertEquals(GameDriver.SCREEN_HEIGHT / 2, pose.getY(), 0.01);

        Vector2D velocity = ship.getVelocity();
        assertEquals(0, velocity.getX(), 0);
        assertEquals(0, velocity.getY(), 0);

        assertEquals(20, Ship.SHIP_HEIGHT);

    }

    @Test
    final void testTurnLeft() {
        Ship ship = new Ship();
        ship.turnLeft();
    }

    @Test
    final void testTurnRight() {
        Ship ship = new Ship();
        ship.turnRight();

    }

    @Test
    final void testThrust() {
        Ship ship = new Ship();
        ship.thrust();
    }

    @Test
    public void testDraw() {
        Ship ship = new Ship();
        ship.draw();
        assertEquals(StdDraw.getLastDraw(), "polygon()");
    }

}
