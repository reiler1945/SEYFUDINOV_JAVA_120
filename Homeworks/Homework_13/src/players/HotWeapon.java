package players;
public abstract class HotWeapon extends Weapon{

	// максимальное количество патронов в магазине
	protected static int maxBulletsInMagazine;

	// расход патронов за выстрел
	protected static int bulletsForShot;

	// количество патронов в магазине
	protected int bulletsInMagazine;

	protected String name;

	public HotWeapon(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract void shot();

	public int action() {
		if (this.bulletsInMagazine / bulletsForShot == 0) {
			System.err.println("No more bullets in the gun " + this.getName() + "!");
			return -1;
		} else {
			this.shot();
			this.bulletsInMagazine =- bulletsForShot;
			return 1;
		}
	}

	// перезарядка магазина
	// как переносить условия?
	public void reloadFrom(UpgradedPlayer upgradedPlayer) {
		if (this.bulletsInMagazine > 0) {
			System.err.println("Magazine is not empty yet!");
			return;
		}
		if (upgradedPlayer.getBulletsAmount() / maxBulletsInMagazine == 0) {
			System.err.println("Not enough bullets amount!");
			return;
		}
		if (upgradedPlayer.getBulletsAmount() / maxBulletsInMagazine > 0) {
			bulletsInMagazine =+ maxBulletsInMagazine;
			upgradedPlayer.setBulletsAmount(upgradedPlayer.getBulletsAmount() - maxBulletsInMagazine);
			System.out.println("Magazine is full!");
			return;
		}
	}
}