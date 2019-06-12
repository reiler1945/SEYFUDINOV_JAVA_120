package ru.company;

public class CoffeeMachine {
    private String modelName;

    private CupCount cupCount;
    private Status status;

    public CoffeeMachine(String modelName, CupCount cupCount) {
        this.modelName = modelName;
        this.cupCount = cupCount;
    };

    public String getModelName() {
        return modelName;
    }

    public CupCount getCupCount() {
        return cupCount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "model = " + this.getModelName() + "; "
                + "Count of cup = " + this.getCupCount();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof CoffeeMachine) {
            CoffeeMachine another = (CoffeeMachine) obj;
            return (this.getCupCount() == another.getCupCount()) && (this.getModelName() == another.getModelName());
        } else {
            return false;
        }
    }
}
