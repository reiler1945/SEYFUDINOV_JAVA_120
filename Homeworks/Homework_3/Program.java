
/*
пользователь вводит число
программа выводит сумму цифр этого числа
пользователь вводит другое число
 программа выводит произведение цифр этого числа
в каждом случае, если выведенное программой значение четное, то не давать пользователю ввести нечетное число (требовать ввести заново)
Вопросы: спросить у Марселя как бы он записал "проверяем что указывает user" с точки зрения читабельности
*/
import java.util.Scanner;
class Program {
  public static void main(String args[]){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Program started");             
                int input = scanner.nextInt();
                boolean oper_type = true; //по умолчанию сложение
                int result = 0;
                //цикл ввода
    while (input >= 0) {
                  //цикл выполнения целевой операции
      result = oper_type ? 0 : 1;    
                  while ((input / 10 > 0) || (input % 10 > 0)) {
                                 // сложение                  
                                 result = oper_type ? result + input % 10 : result * (input % 10);             
                                 input = input / 10;
                  };
                  oper_type = !oper_type;
                  //вывод результата
                  System.out.println("result = " + result);            
                  input = scanner.nextInt();       
                  //проверяем что указывает user                      
                  while (((result % 2 == 0) & (input % 2 != 0)) & (input >= 0)) {
                  			   System.out.println("REPEAT INPUT");
                               input = scanner.nextInt();                         
                  };
                }
                System.out.println("Program finished");
  }
}