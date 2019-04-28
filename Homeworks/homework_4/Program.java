/*
На вход подается N чисел, N -> infinity.
Последним числом является -1
Выяснить сколько раз встречается каждая цифра среди всех этих чисел.
Нулевые не выводить. 
*/
import java.util.Scanner;
class Program {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Program started");	
		int[] arr = new int[10];
		int input;
		int k = 0; //счетчик
		System.out.println("Enter integer values, last value must be negative: ");	
		do {
			System.out.print("value # " + ++k + ": ");	 
		    input = scanner.nextInt();
			if (input == 0) { //если вводим 0
			    arr[0]++;	
			} else {  //в остальных случаях
				while (((input / 10) > 0 || (input % 10) > 0) && (input >= 0)) {
					arr[input % 10]++;
					input = input / 10;
				}
			}	
		} while (input >= 0);
		//подсчет цифр
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				System.out.println(i + " - " + arr[i] + "pieces");
			}	
		}	
        System.out.println("Program finished");
    }
}