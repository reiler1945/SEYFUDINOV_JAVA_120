package players;
public abstract class Weapon {
    protected static int damage;
    protected static int bonus;

    // действие оружия
    public abstract int action();

    // нанести урон
    public void doDamage(Player player) {
        this.action();
        player.setHealth(player.getHealth() - this.damage);
    }

    public int getBonus() {
        return bonus;
    }
}