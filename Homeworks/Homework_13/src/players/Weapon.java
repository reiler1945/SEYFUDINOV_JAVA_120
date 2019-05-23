package players;
public abstract class Weapon {
    
    //повреждение для врага
    protected static int damage;
    
    //бонус в случае нанесения ущерба врагу
    protected static int bonus;
    
    //владелец оружия
    protected PlayerUpgraded owner;

    // действие оружия
    public abstract int action();

    // нанесение урона
    public void doDamage(Player player) {
        this.action();
        player.setHealth(player.getHealth() - this.damage);
    }
    
    public int getBonus() {
        return bonus;
    }
    
    public int getOwner() {
        return owner;
    }

    protected void setOwner(PlayerUpgraded owner) {
        this.owner = owner;
    }
}
