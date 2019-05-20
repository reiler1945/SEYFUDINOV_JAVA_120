package lists;

public class Main {
    public static void main(String[] args) {
        IntegerArrayList list = new IntegerArrayList();
        list.print();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.print();
        list.removeByIndex(10);
        list.print();
        list.removeByIndex(6);
        list.print();
        list.add(8);
        list.print();
        list.removeByValue(8);
        list.print();
    }
}
