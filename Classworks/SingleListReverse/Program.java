/*
пример односвязного списка
*/
import java.util.Scanner;
class Program {
    public static void main(String args[]){
       SList list = new SList();
       SList temp = list;
       temp.value = 0;
       // инициализация листа
       for (int i = 1; i < 10; i++) {
                       SList buf = temp;
                       temp.next = new SList();
                       temp = temp.next;
                       temp.value = buf.value + 5;
       }
       // отобразим значения листа
       temp = list;
       while (temp != null) {
                       System.out.println(temp.value);
                       temp = temp.next;
       }
       System.out.println("------------------------------------");
       // реверсируем лист
       SList previous = null;
       SList current = list;
       SList forward = list.next;
       while (forward != null) {
                       current.next = previous;
                       previous = current;
                       current = forward;
                       forward = current.next;
       }
       current.next = previous;            
       System.out.println("------------------------------------");                  
       // отобразим reversed list
       temp = current;
       int i = 0;
       while (temp != null) {
                       System.out.println(temp.value);
                       temp = temp.next;
       }
       System.out.println("------------------------------------");                  
    }
}
 
class SList {
                int value;
                SList next;
}