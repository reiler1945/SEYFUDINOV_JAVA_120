package ru.company;

public class Main {

    public static void main(String[] args) {
	    CoffeeMachine coffeeMachine1 = new CoffeeMachine("Samsung", CupCount.One);
        CoffeeMachine coffeeMachine2 = new CoffeeMachine("Sony", CupCount.One);
        CoffeeMachine coffeeMachine3 = new CoffeeMachine("Samsung", CupCount.One);
        coffeeMachine1.setStatus(Status.Off);
        System.out.println(coffeeMachine1);
        System.out.println(coffeeMachine1.equals(coffeeMachine2));
        System.out.println(coffeeMachine1.equals(coffeeMachine3));

    }
}
