package lists;

public class Main {
    public static void main(String[] args) {
        IntegerArrayList list = new IntegerArrayList();
        list.array = new int[10];
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
//возврат консоли:
/*
[]
added element = 1 by index = 0
added element = 2 by index = 1
added element = 3 by index = 2
added element = 4 by index = 3
added element = 5 by index = 4
[1,2,3,4,5,]
added element = 6 by index = 5
added element = 7 by index = 6
added element = 8 by index = 7
added element = 9 by index = 8
added element = 10 by index = 9
Can't add element 11. The list is full
[1,2,3,4,5,6,7,8,9,10,]
removed element by index = 10
[1,2,3,4,5,6,7,8,9,]
removed element by index = 6
[1,2,3,4,5,6,8,9,]
added element = 8 by index = 8
[1,2,3,4,5,6,8,9,8,]
removed element by index = 6
removed element by index = 7
[1,2,3,4,5,6,9,]
*/
