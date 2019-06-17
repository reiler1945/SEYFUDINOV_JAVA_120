package ru.itis.tests;

import ru.itis.collections.LinkedList;

public class MainLinkedListLong {
    public static void main(String[] args) {
        LinkedList<Long> list = new LinkedList<>();
        list.add(7L);
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        list.add(5L);
        list.add(6L);
        list.add(7L);
        list.add(8L);
        list.add(9L);
        list.add(7L);
        list.add(7L);
        list.add(10L);
        list.add(11L);
        list.add(7L);
        //list.add(new String("Семь"));

        System.out.println(list.get(0));

        System.out.println(list.exists(1L));

        System.out.println(list.toString());
        list.remove(10L);
        System.out.println(list.toString());
        list.removeAt(5);
        System.out.println(list.toString());
        list.remove(7L);
        System.out.println(list.toString());
        list.removeAt(0);
        System.out.println(list.toString());
        list.removeAt(list.size() - 1);
        System.out.println(list.toString());
    }
}
