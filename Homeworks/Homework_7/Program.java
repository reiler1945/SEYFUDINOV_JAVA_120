/*
Написать функцию boolean isPrime(int number) для проверки, является ли число number простым числом.
*/
import java.lang.Math;
class Program {
	public static void main(String[] args) {
		System.out.println("Program started");
		// определим простые числа по диапазону
		for (int i = 1; i < 60; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
		System.out.println("Program finished");
	}
	// определение простоты числа методом "Перебор делителей"
	public static boolean isPrime(int number) {
		boolean flag = false;
		int sqrtNumber = (int)Math.sqrt(number);
		if (sqrtNumber < 2) {
			sqrtNumber = 2;
		};
		int i = 2;
		// как только найдем делитель без остатка, то flag = true 
		while ((i <= sqrtNumber) && !flag) {
			flag = (number % i == 0);
			i++;
		};
		// число простое, если делитель не найден
		return !flag;
	};

}