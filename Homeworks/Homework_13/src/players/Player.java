package players;

import java.util.Arrays;

public class Player implements PlayerByEnemyObservable, StrategyContext{

    protected static final int DEFAULT_HIT_SCORE_VALUE = 1;
    protected static final int INITIAL_SCORE_VALUE = 0;
	protected static final int MAX_ENEMIES = 5;

    protected String name;
    protected int score;

    Strategy strategy;

    protected int currerntEnemyCount = 0;	
    protected Enemy[] enemies;

    private double health;

    public Player(String name, double health) {
        this.name = name;
        this.health = health;
        this.score = INITIAL_SCORE_VALUE;
		enemies = new Enemy[MAX_ENEMIES];
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
        notifyEnemies();
    }

    public void addEnemy(Enemy enemy) {
		int result = MyArraysUtil.addElement(enemies, enemy, currerntEnemyCount);
		if (result >= 0) {
			currerntEnemyCount = result; 
		}	
    }

    public void removeEnemy(Enemy enemy) {
		int result = MyArraysUtil.removeElement(enemies, enemy, currerntEnemyCount);
		if (result >= 0) {
			currerntEnemyCount = result; 
		}			
    }

    public void notifyEnemies() {
        for (int i = 0; i < currerntEnemyCount; i++) {
            enemies[i].handleEvent(this);
        }
    }

    public void executeStrategy() {
        if (strategy != null) {
            strategy.say();
        }
    };

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}