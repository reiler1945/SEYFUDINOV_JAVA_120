package players;

public abstract class Weapon {
    
    //повреждение для врага
    protected static int damage;
    
    //бонус в случае нанесения ущерба врагу
    protected static int bonus;
    
    //владелец оружия
    protected UpgradedPlayer owner;

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
    public UpgradedPlayer getOwner() {
        return owner;
    }
    
    //назначим владельца оружия
    protected void setOwner(UpgradedPlayer owner) {
        this.owner = owner;
    }
}