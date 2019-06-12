package models;

public class SimpleCar extends Car {

    public SimpleCar(Builder builder) {
        this.model = builder.model;
        this.driver = builder.driver;
        this.startStrategy = builder.startStrategy;
        this.distance = builder.distance;
        this.id = builder.id;
    }

    public static class Builder{
        private String model;
        private Driver driver;
        private CarStartable startStrategy;
        private int distance;
        private int id;

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setDriver(Driver driver) {
            this.driver = driver;
            return this;
        }

        public Builder setStartStrategy(CarStartable startStrategy) {
            this.startStrategy = startStrategy;
            return this;
        }

        public Builder setDistance(int distance) {
            this.distance = distance;
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public SimpleCar build () {
            return new SimpleCar(this);
        }
    }

    public static Builder builder () {
        return new Builder();
    }

    @Override
    public void engineSound() {
        System.out.println("I'm Simple car whroom whroom!");
    }
}
