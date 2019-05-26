package players;

public interface PlayerObservable {
    void notifyEnemy();
    void addObserver(Enemy enemy);
    void removeObserver();
}
