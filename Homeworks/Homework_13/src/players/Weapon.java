package players;
public abstract class Weapon {
    
    //повреждение для врага
    protected static int damage;
    
    //бонус в случае нанесения ущерба врагу
    protected static int bonus;
    
    //владелец оружия
    protected PlayerUpgraded owner;

    // действие оружия -1 - неуспешно (нет патронов), 1 - успешно
    public abstract int action();

    // нанесение урона
    public void doDamage(Player player) {
        this.action();
        player.setHealth(player.getHealth() - this.damage);
    }
    
    //бонус при уроне врага
    public int getBonus() {
        return bonus;
    }
    
    //получим владельца оружия
    public int getOwner() {
        return owner;
    }
    
    //назначим владельца оружия
    protected void setOwner(PlayerUpgraded owner) {
        this.owner = owner;
    }
}
