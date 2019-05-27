package players;

public class UpgradedPlayer extends Player {
    private static final int INITIAL_BULLETS_AMOUNT = 20;
    private static final int MAX_WEAPON_COUNT = 5;

    private int currentWeaponCount;

    //боезапас
    private int bulletsAmount;
    
    //оружие
    private Weapon[] weapons;

    private Weapon currentWeapon;
    
    public UpgradedPlayer(String name, double health) {
        super(name, health);
        this.bulletsAmount = INITIAL_BULLETS_AMOUNT;
        weapons = new Weapon[MAX_WEAPON_COUNT];
        currentWeaponCount = 0;
    }

    public void addWeapon(Weapon weapon) {
        if (weapon != null) {
			int result = MyArraysUtil.addElement(weapons, weapon, currentWeaponCount);
			if (result >= 0) {
				currentWeaponCount = result;
				weapon.setOwner(this);
				this.setCurrentWeapon(currentWeaponCount - 1);
			}	
        } else {
            System.err.println("Нет оружия!");
        }
    }

    public void removeWeapon(Weapon weapon) {
		int result = MyArraysUtil.removeElement(weapons, weapon, currentWeaponCount);
		if (result >= 0) {
			currentWeaponCount = result;
			weapon.setOwner(null);
			if (currentWeaponCount > 0) {
                this.setCurrentWeapon(currentWeaponCount - 1);
            }
		}	
    }

    public void hit(Player player) {
        if (currentWeapon != null)  {
            currentWeapon.doDamage(player);
            this.setScore(this.getScore() + currentWeapon.getBonus());
        } else {
            super.hit(player);
        }
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(int numWeapon) {
        if (weapons.length > 0 && numWeapon < weapons.length) {
            this.currentWeapon = weapons[numWeapon];
        } else {
            System.err.println("Список оружия пуст или нет такого оружия!");
        }
    }
	
    public void setCurrentWeapon(Weapon weapon) {
		setCurrentWeapon(MyArraysUtil.getIndex(weapons, weapon, currentWeaponCount));
    }	

    public int getBulletsAmount() {
        return bulletsAmount;
    }

    public void setBulletsAmount(int bulletsAmount) {
        this.bulletsAmount = bulletsAmount;
    }
}