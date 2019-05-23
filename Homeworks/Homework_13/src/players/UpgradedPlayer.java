package players;
public class UpgradedPlayer extends Player {
    private static final int INITIAL_BULLETS_AMOUNT = 20;
    
    //боезапас
    private int bulletsAmount;
    
    //оружие
    private Weapon weapon;
    
    public UpgradedPlayer(String name, double health) {
        super(name, health);
        this.bulletsAmount = INITIAL_BULLETS_AMOUNT;
    }

    public void hit(Player player) {
        if (weapon != null) {
            weapon.doDamage(player);
            this.setScore(this.getScore() + weapon.getBonus());
        } else {
            super.hit(player);
        }
    }

    public int getBulletsAmount() {
        return bulletsAmount;
    }

    public void setBulletsAmount(int bulletsAmount) {
        this.bulletsAmount = bulletsAmount;
    }

    public Weapon getWeapon() {
        return weapon;
    }
    
    //берем оружие
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        //назначаем владельца оружия
        this.weapon.setOwner(this); 
    }
}
