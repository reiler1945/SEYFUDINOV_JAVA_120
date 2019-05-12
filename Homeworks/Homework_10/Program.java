/*
На вход подается строка, как в примере Chars.
 
Необходимо посчитать, какая буква встречалась больше всех независимо от регистра. Если таких букв несколько, вывести в алфавитном порядке.
 
Hello, my dear friend, Ludvik
 
d
e
l
 
*/
// латиница 32-127 : (65 - 90 : 97 - 122) + 32
// кириллица 1024-1279 : (1040 - 1071 : 1072 - 1103) + 32; Ё, ё (1025, 1105)
// ниже конманды для запуска программы в консоле с нужными настройками
/*
cd C:\Program Files\Java\jdk1.8.0_181\bin\
rem переводим кодировку на win 1251
chcp 1251
javac C:\Users\XXX\Desktop\java\Homework_10\Program.java
java -classpath "C:\\Users\\XXX\\Desktop\\java\\Homework_10" Program
Pause
*/
import java.util.Arrays;
import java.util.Scanner;
public class Program {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         char text[];
         String input = scanner.nextLine();       
         while (!input.equals("quit")) { 
           text = input.toCharArray();
           /*System.out.println(Arrays.toString(text));
           for (int i = 0; i < text.length; i++) {
                System.out.println(text[i] + ":" + (int)text[i]);
           }*/
           printMaxCountCharLatin(text);
           printMaxCountCharKirill(text);
           input = scanner.nextLine();         
         }       
     }
     public static void printMaxCountCharLatin(char[] text) {
         //массив для подсчета кол-ва присутствющих симовлов независимо от регистра
         int count[] = new int[26];               
         for (int i = 0; i < text.length; i++) {
            int charCode = (int)text[i];
            //отображаем код символа в диапазон массива [0-25]           
            if (charCode > 90) {
               charCode = charCode - 32;
            }
            charCode = charCode - 65;
            if ((charCode >= 0) && (charCode < 25)) {
               count[charCode]++;
            }
         }
         //ведем поиск символа с максимальным присутсвием
         int maxCount = 0;
         for (int i = 0; i < count.length; i++) {
           if (count[i] > maxCount) {
                maxCount = count[i];
           }
         }
         // отобразим символы с максимальным кол-вом присутствия в алфавитном порядке
         if (maxCount > 0) {
           for (int i = 0; i < count.length; i++) {
              if (count[i] == maxCount) {
                System.out.println((char)(i + 65 + 32) + ":" + maxCount);
              }
           }
         }        
     }      
     public static void printMaxCountCharKirill(char[] text) {
         //массив для подсчета кол-ва присутствющих симовлов независимо от регистра
         int count[] = new int[33];               
         for (int i = 0; i < text.length; i++) {
           int charCode = (int)text[i];
           //отображаем код символа в диапазон массива [0-32]
           //для символа 'ё' отдельный алгоритм
           if ((charCode == 1025) || (charCode == 1105)) {
                count[32]++;
           } else {
                if (charCode > 1071) {
                 charCode = charCode - 32;
                }
                charCode = charCode - 1040;
                if ((charCode >= 0) && (charCode < 32)) {
                 count[charCode]++;
                }
           }           
         }
         //ведем поиск символа с максимальным присутсвием
         int maxCount = 0;
         for (int i = 0; i < count.length; i++) {
           if (count[i] > maxCount) {
                maxCount = count[i];
           }
         }
         // отобразим символы с максимальным кол-вом присутствия в алфавитном порядке
         if (maxCount > 0) {
           for (int i = 0; i < count.length; i++) {
                if (count[i] == maxCount) {
                 if (i == 32) {
                      System.out.println((char)1105 + ":" + maxCount);
                 } else {
                      System.out.println((char)(i + 1040 + 32) + ":" + maxCount);
                 }      
                }
           }
         }        
     }           
}
