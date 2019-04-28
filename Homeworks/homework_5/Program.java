/*
Ввести размер массива с консоли,
ввести сам массив,
посчитать кол-во локальных минимумов и максимумов,
вывести эту информацию на экран
a[i-1] < a[i] > a[i + 1] - локальный максимум
a[i-1] > a[i] < a[i + 1] - локальный минимум
*/
import java.util.Scanner;
class Program {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dimension of massive:");	
		int[] arr = new int[scanner.nextInt()];
		int i = 0;
		System.out.println("Enter the list of values:");	
		int input = scanner.nextInt();
		while ((input >= 0) && (i < arr.length)) {
		    arr[i++] = input;
		    input = scanner.nextInt();
		};
		int max_count = 0; 
		int min_count = 0;
		for (int k = 1; k < arr.length - 1; k++) {
			if ((arr[k] > arr[k - 1]) && (arr[k] > arr[k + 1])) {
				max_count++;
			} else if ((arr[k] < arr[k - 1]) && (arr[k] < arr[k + 1])) {
				min_count++;
			}
		};
		System.out.println("max_count = " + max_count);
		System.out.println("min_count = " + min_count);
        System.out.println("Program finished");
    }
}