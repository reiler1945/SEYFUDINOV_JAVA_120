package players;

public class MachineGun extends HotWeapon {

	// определим параметры класса оружия
	static {
		damage = 20;
		bonus = 20;
		maxBulletsInMagazine = 12;
		bulletsForShot = 4;
	}

	public MachineGun(String name) {
		super(name);
	}
	
	//выстрел
	public void shot() {
		System.out.println("TA-TA-TA-TA!");
	}
}