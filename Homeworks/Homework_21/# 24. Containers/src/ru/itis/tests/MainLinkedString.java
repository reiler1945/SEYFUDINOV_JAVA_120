package ru.itis.tests;

import ru.itis.collections.LinkedList;

public class MainLinkedString {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add(new String("Семь"));
        list.add(new String("Один"));
        list.add(new String("Два"));
        list.add(new String("Три"));
        list.add(new String("Четыре"));
        list.add(new String("Пять"));
        list.add(new String("Шесть"));
        list.add(new String("Семь"));
        list.add(new String("Восемь"));
        list.add(new String("Девять"));
        list.add(new String("Семь"));
        list.add(new String("Семь"));
        list.add(new String("Десять"));
        list.add(new String("Одиннадцать"));
        list.add(new String("Семь"));
        //list.add(new Integer(1));

        System.out.println(list.get(0));

        System.out.println(list.exists("Один"));

        System.out.println(list.toString());
        list.remove("Десять");
        System.out.println(list.toString());
        list.removeAt(5);
        System.out.println(list.toString());
        list.remove("Семь");
        System.out.println(list.toString());
        list.removeAt(0);
        System.out.println(list.toString());
        list.removeAt(list.size() - 1);
        System.out.println(list.toString());
    }
}
