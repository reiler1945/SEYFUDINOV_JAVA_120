package humans;

public class Human {
    String name;
    int age;
    double height;
    int passedDistance;

    void go(int km) {
        passedDistance += km;
    }
}