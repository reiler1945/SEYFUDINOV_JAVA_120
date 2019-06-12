package models;

public class CarStartByKey implements CarStartable{
    @Override
    public void start() {
        System.out.println("Стартуем ключом зажигания");
    }
}
