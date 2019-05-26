package players;

import org.jetbrains.annotations.NotNull;

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
            this.weapons[currentWeaponCount++] = weapon;
            weapon.setOwner(this);
            this.setCurretWeapon(currentWeaponCount - 1);
        } else {
            System.err.println("Нет оружия!");
        }
    }

    public void removeWeapon(int numWeapon) {
        if ((numWeapon < currentWeaponCount) && (numWeapon >= 0)) {
            for (int i = numWeapon; i < currentWeaponCount; i++) {
                if (i == numWeapon) {
                    this.weapons[i].setOwner(null);
                }
                weapons[i] = weapons[i + 1];
            }
            if (currentWeaponCount > 0) {
                this.setCurretWeapon(numWeapon);
            }
            System.out.println("Выбросили оружие!");
        } else {
            System.err.println("Не удалось выбросить оружие!");
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

    public Weapon getCurretWeapon() {
        return currentWeapon;
    }

    public void setCurretWeapon(int numWeapon) {
        if (weapons.length > 0 && numWeapon < weapons.length) {
            this.currentWeapon = weapons[numWeapon];
        } else {
            System.err.println("Список оружия пуст или нет оружия с таким номером!");
        }
    }

    public int getBulletsAmount() {
        return bulletsAmount;
    }

    public void setBulletsAmount(int bulletsAmount) {
        this.bulletsAmount = bulletsAmount;
    }
}
