/*
 пользователь вводит число
 программа выводит сумму цифр этого числа
 пользователь вводит другое число 
 программа выводит произведение цифр этого числа
 в каждом случае, если выведенное программой значение четное, то не давать пользователю ввести нечетное число (требовать ввести заново)
 Вопросы: спросить у Марселя как бы он записал "проверяем что указывает user" с точки зрения читабельности 
*/
import java.util.Scanner;
class Program_3 {
  public static void main(String args[]){
	Scanner scanner = new Scanner(System.in);
	System.out.println("Program started");	
	int input = scanner.nextInt();
	int x_digit; 
	boolean oper_type = true; //по умолчанию сложение
	int result = 0;
	//цикл ввода
    while (input >= 0) {
	  //цикл расчета x-значности числа
 	  x_digit = 1;
	  int to_calc = input; 
	  while (to_calc / 10 > 0) {
		x_digit = x_digit * 10;
		to_calc = to_calc / 10;
	  }		  
	  System.out.println("x_digit = " + x_digit);	
	  //цикл выполнения целевой операции
	  result = oper_type ? 0 : 1;
	  while (x_digit / 10 >= 0) {
		if (x_digit == 0) {
		  x_digit = 1;	
		}			
		if (oper_type) {
		  // сложение
		  System.out.println("result1 = " + input / x_digit);			  
		  result = result + input / x_digit; 
		  input = input % x_digit;
		} 
		else {
		  // умножение	
		  result = result * (input / x_digit); 
		  input = input % x_digit;
		}
		if (x_digit == 1) {break;};
		x_digit = x_digit / 10;
	  };
	  oper_type = !oper_type;
	  //вывод результата
	  System.out.println("result = " + result);	
	  input = scanner.nextInt();	
	  //проверяем что указывает user 		
	  while ((((result % 2 == 0) && (input % 2 == 0)) || ((result % 2 != 0) && (input % 2 != 0))) && (input >= 0)) {
		System.out.println("REPEAT INPUT");	  
		input = scanner.nextInt();		
	  }; 
	}
	System.out.println("Program finished");
  }
}