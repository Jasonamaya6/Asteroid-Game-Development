import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BulletTest {

    @Test
    public void testUpdate() {
        Pose pose = new Pose(50, 50, 0);
        Bullet bullet = new Bullet(pose);
        bullet.update();
        Pose expectedPose = new Pose(50 + Bullet.BULLET_DURATION, 50, 0);
        assertEquals(expectedPose, bullet.getPose());
        for (int i = 0; i < 20; i++) {
            bullet.update();
        }
    }

    @Test
    public void testBulletConstructor() {
        Point point = new Point(100, 200);
        Pose pose = new Pose(100, 200, 0);
        double heading = 0.0;
        Bullet bullet = new Bullet(pose);

        assertEquals(point.getY(), bullet.getPose().getY(), 0.01);
        assertEquals(heading, bullet.getPose().getHeading(), 0.01);
        assertEquals(heading, bullet.getVelocity().getHeading(), 0.01);
        assertEquals(Bullet.BULLET_SPEED, bullet.getVelocity().getMagnitude(), 0.01);
        assertEquals(Bullet.BULLET_RADIUS, bullet.getRadius(), 0.01);
    }

    @Test
    final void testDraw() {
        Pose pose = new Pose(50, 50, 0);
        Bullet bullet = new Bullet(pose);
        bullet.draw();
        assertEquals(StdDraw.getLastDraw(), "filledCircle(" + bullet.getPose().getX() + ", " + bullet.getPose().getY()
                + ", " + Bullet.BULLET_RADIUS + ")");

    }

}
