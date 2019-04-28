/*
Считать с консоли, поменять местами минимальный и максимальный элементы местами
*/
import java.util.Scanner;
class Program {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dimension of massive:");	
		int[] arr = new int[scanner.nextInt()];
		int i = 0;
		System.out.println("Enter the list of values:");	
		//вводим данные
		int input = scanner.nextInt();
		while ((input >= 0) && (i < arr.length)) {
		    arr[i++] = input;
		    input = scanner.nextInt();
		};
		//ищем минимальное и максимальное значения в массиве
		int max_value = arr[0]; 
		int min_value = arr[0]; 
		for (int k = 0; k < arr.length; k++) {
            max_value = (arr[k] > max_value) ? arr[k] : max_value; 
			min_value = (arr[k] < min_value) ? arr[k] : min_value;
		};
		//меняем местами значения
		for (int k = 0; k < arr.length; k++) {
            if (arr[k] == max_value) {
				arr[k] = min_value;
			} else if (arr[k] == min_value) {
				arr[k] = max_value;
			}	
		};		
		for (int k = 0; k < arr.length; k++) {
			System.out.println("arr[" + k + "] = " + arr[k]);
		};				
        System.out.println("Program finished");
    }
}