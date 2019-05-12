package lists;

public class Main {
    public static void main(String[] args) {
        IntegerArrayList list = new IntegerArrayList();
        list.array = new int[10];
        list.add(1000);
        System.out.println(list.get(0));
    }
}
