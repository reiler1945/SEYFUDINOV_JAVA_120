package ru.itis.tests;

import ru.itis.collections.IntegerArrayList;
import ru.itis.collections.IntegerLinkedList;
import ru.itis.collections.IntegersList;
import ru.itis.collections.Node;

public class MainLinkedList {
    public static void main(String[] args) {
        IntegersList list = new IntegerLinkedList();
        list.add(7);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(7);
        list.add(7);
        list.add(10);
        list.add(11);
        list.add(7);

        System.out.println(list.get(0));

        System.out.println(list.exists(1));

        System.out.println(list.toString());
        list.remove(10);
        System.out.println(list.toString());
        list.removeAt(5);
        System.out.println(list.toString());
        list.remove(7);
        System.out.println(list.toString());
        list.removeAt(0);
        System.out.println(list.toString());
        list.removeAt(list.size() - 1);
        System.out.println(list.toString());
    }
}
