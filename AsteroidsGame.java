import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Asteroid Game main.
 * 
 * @author Jason amaya
 * @version April 14 2023.
 */
public class AsteroidsGame implements Playable {

    public static final int LIVES = 3;

    private ArrayList<Drawable> drawElements;
    private ArrayList<Updatable> updateElements;
    private ArrayList<GameElement> shipAndBullets;
    private ArrayList<Enemy> enemies;

    private NumericDisplay score;
    private NumericDisplay lives;
    private Ship ship;

    /**
     * Constructs all game elements.
     */
    public AsteroidsGame() {
        StdDraw.setTitle("Generic Space Rock Shooter");

        drawElements = new ArrayList<>();
        updateElements = new ArrayList<>();
        shipAndBullets = new ArrayList<>();
        enemies = new ArrayList<>();

        final int TOP = GameDriver.SCREEN_HEIGHT;
        score = new NumericDisplay(10, TOP - 20, "Score: ", 0);
        lives = new NumericDisplay(10, TOP - 40, "Lives: ", LIVES);
        drawElements.add(score);
        drawElements.add(lives);

    }

    /**
     * Creates and adds 100 stars with random locations.
     */
    private void newStars() {
        for (int i = 0; i < 100; i++) {
            TwinkleStars star = new TwinkleStars(randomXPosition(), randomYPosition());
            star.draw();
            drawElements.add(star);
        }
    }

    /**
     * Creates new enemies.
     */
    private void newEnemies() {
        for (int i = 0; i < 10; i++) {
            Asteroid enem = new Asteroid(AsteroidSize.randomSize());
            addEnemy(enem);
        }
    }

    /**
     * Adds new enimies into the Arraylist.
     * 
     * @param enemy object and adds into the arraylists.
     */
    public void addEnemy(Enemy enemy) {
        drawElements.add(enemy);
        updateElements.add(enemy);
        enemies.add(enemy);
    }

    /**
     * Creates a new ship and adds them into the array list.
     */
    private void newShip() {
        ship = new Ship();
        drawElements.add(ship);
        updateElements.add(ship);
        shipAndBullets.add(ship);
    }

    /**
     * Starts the game.
     */
    public void startGame() {
        newStars();
        newShip();
        newEnemies();

    }

    /**
     * The input the user clicks.
     */
    private void handleKeyboardInput() {
        if (GameDriver.spacePressed()) {
            Bullet bullet = new Bullet(ship.getPose());
            bullet.draw();
            drawElements.add(bullet);
            updateElements.add(bullet);
            shipAndBullets.add(bullet);
        }

        if (GameDriver.leftPressed()) {
            ship.turnLeft();
        }

        if (GameDriver.rightPressed()) {
            ship.turnRight();
        }

        if (GameDriver.upPressed()) {
            ship.thrust();
        }
    }

    @Override
    public void update() {
        // freeze simulation if game is over
        if (lives.getValue() <= 0) {
            return;
        }

        // update everything (including newest bullet)
        handleKeyboardInput();
        for (Updatable item : updateElements) {
            item.update();
        }

        // TODO You will need these in Part 3
        handleCollisions();
        removeDestroyedBullets();
        removeDestroyedEnemies();

        // TODO Put your code here
        Random random = new Random();
        if (random.nextDouble(0, 1) < Saucer.SPAWN_PROB) {
            Saucer sauce = new Saucer();
            sauce.draw();
            addEnemy(sauce);
        }

        if (enemies.isEmpty()) {
            newEnemies();
        }
    }

    @Override
    public void draw() {
        StdDraw.setPenColor(Color.WHITE);
        for (Drawable item : drawElements) {
            item.draw();
        }
    }

    /**
     * Destroys objects of enemies.
     */
    public void handleCollisions() {
        boolean addS = false;
        for (Enemy enemy : enemies) {
            for (GameElement element : shipAndBullets)
                if (element.checkCollision(enemy)) {
                    element.setDestroyed(true);
                    enemy.setDestroyed(true);
                    if (element instanceof Ship) {
                        lives.setValue(lives.getValue() - 1);
                        addS = true;
                    }

                }
        }
        if (addS) {
            drawElements.remove(ship);
            updateElements.remove(ship);
            shipAndBullets.remove(ship);
            this.newShip();
        }
    }

    /**
     * Removes the destroyed bullets.
     */
    public void removeDestroyedBullets() {
        ArrayList<GameElement> list = new ArrayList<>();
        for (GameElement bullet : shipAndBullets) {
            if (bullet.isDestroyed() && bullet instanceof Bullet) {
                list.add(bullet);
            }
        }
        for (GameElement bullet : list) {
            drawElements.remove(bullet);
            updateElements.remove(bullet);
            shipAndBullets.remove(bullet);
        }
    }

    /**
     * removes the enimies that have been destroyed.
     */
    public void removeDestroyedEnemies() {
        ArrayList<Enemy> list = new ArrayList<>();
        for (Enemy enemy : enemies) {
            if (enemy.isDestroyed()) {
                list.add(enemy);
                this.score.setValue(score.getValue() + enemy.getPoints());
            }
        }
        for (Enemy enemy : list) {
            drawElements.remove(enemy);
            updateElements.remove(enemy);
            enemies.remove(enemy);
        }
    }

    /**
     * Generates random position.
     * 
     * @return Random x position
     */
    protected static double randomXPosition() {
        return GameDriver.GENERATOR.nextDouble() * GameDriver.SCREEN_WIDTH;
    }

    /**
     * Genrator for position.
     * 
     * @return y position.
     */
    protected static double randomYPosition() {
        return GameDriver.GENERATOR.nextDouble() * GameDriver.SCREEN_HEIGHT;
    }

    /**
     * Random heading direction.
     * 
     * @return heading.
     */
    protected static double randomHeading() {
        return GameDriver.GENERATOR.nextDouble() * 2 * Math.PI;
    }

}