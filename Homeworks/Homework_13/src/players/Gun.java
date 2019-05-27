package players;

public class Gun extends HotWeapon {
	// определим параметры класса оружия
	static {
		damage = 20;
		bonus = 20;
		maxBulletsInMagazine = 12;
		bulletsForShot = 1;
	}

	public Gun(String name) {
		super(name);
	}
	
	//выстрел
	public void shot() {
		System.out.println("Bang!");
	}
}