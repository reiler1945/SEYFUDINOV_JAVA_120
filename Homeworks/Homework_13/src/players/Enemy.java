package players;

public class Enemy extends Player implements EnemyObserver {

    public Enemy() {
        super("Enemy", 100);
    }

    public void handleEvent(Player player) {
        if (player.getHealth() <= 30) {
            player.removeEnemy(this);
            this.hit(player);
        }
    }
}