package ru.itis;

public class Utils {
    static String repeatString(String s,int count){
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < count; i++) {
            r.append(s);
        }
        return r.toString();
    }
}
