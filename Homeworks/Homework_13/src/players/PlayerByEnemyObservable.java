package players;

public interface PlayerByEnemyObservable {
    void notifyEnemies();
    void addEnemy(Enemy enemy);
    void removeEnemy(Enemy enemy);
}