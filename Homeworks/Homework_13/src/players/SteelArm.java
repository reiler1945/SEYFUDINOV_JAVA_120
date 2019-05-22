package players;
public abstract class SteelArm extends Weapon{
    // нанести урон
    public int action() {
        System.out.println("Shu!");
        return 1;
    }
}