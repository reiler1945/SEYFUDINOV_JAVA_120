package models;

public class CarStarRemotely implements CarStartable{
    @Override
    public void start() {
        System.out.println("Стартуем удаленно!");
    }
}
