package players;

public abstract class SteelArm extends Weapon{
    // удар
    public int action() {
        System.out.println("Shu!");
        return 1;
    }
}