package models;

public abstract class Car {
    protected String model;
    protected Driver driver;
    protected CarStartable startStrategy;
    protected int distance;
    protected int id;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public abstract void engineSound();

    public void drive(int distance) {
        startStrategy.start();
        engineSound();
        this.distance += distance;
    }

    public CarStartable getStartStrategy() {
        return startStrategy;
    }

    public void setStartStrategy(CarStartable startStrategy) {
        this.startStrategy = startStrategy;
    }
}
