package players;
import javafx.beans.Observable;

import java.util.Arrays;

public class Player implements PlayerObservable{

    protected static final int DEFAULT_HIT_SCORE_VALUE = 1;
    protected static final int INITIAL_SCORE_VALUE = 0;

    protected String name;
    protected int score;

    protected Enemy enemy;

    private double health;

    public Player(String name, double health) {
        this.name = name;
        this.health = health;
        this.score = INITIAL_SCORE_VALUE;
    }

    public void hit(Player player) {
        if (getHealth() > 0) {
            System.out.println("kick by hand!");
            this.score += DEFAULT_HIT_SCORE_VALUE;
            player.setHealth(player.getHealth() - DEFAULT_HIT_SCORE_VALUE);
        } else {
            System.err.println("The player " + getName() + "is dead!");
        }
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        if (health > 0d) {
            this.health = health;
        } else {
            this.health = 0d;
            System.err.println("The player " + getName() + "is dead!");
        }
        notifyEnemy();
    }

    public void addObserver(Enemy enemy) {
        this.enemy = enemy;
    }

    public void removeObserver() {
        this.enemy = null;
    }

    public void notifyEnemy() {
        if (enemy != null) {
            enemy.handleEvent(this);
        }
    }
}