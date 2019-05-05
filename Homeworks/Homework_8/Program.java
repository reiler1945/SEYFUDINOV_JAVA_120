/*
-Написать функции int sum(int array[]).
-Написать функцию int[] getVectorOfFrequency(int array[]), предполагая, 
что массив array состоит из числе от 1 до 1000 вернуть вектор частот.
Если число 55 в массиве array встречается 35 раз, то результат функции - массив частот, в индексе 55 имеет значение - 35. (см. Гистограмма)
-Написать функцию double average(int array[]) - возвращает среднее арифметическое массива.
*/
class Program{
	public static void main(String[] args) {
		int array[] = {1, 2, 3, 4, 7, 6, 7, 8, 9};
		System.out.println("sum(array) = " + sum(array));
		System.out.println("avaerage(array) = " + average(array));
		int[] result = getVectorOfFrequency(array);
		// выводим те числа, которые встречаются более чем 0 раз
		for (int i = 0; i < result.length; i++) {
			if (result[i] > 0) {
				System.out.println("count of " + i + " = " + result[i]);
			}
		}
	}
	public static int sum(int array[]) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			result = result + array[i];
		}
		return result;
	}
	public static double average(int array[]) {
		return (double) sum(array) / array.length;
	}	
	public static int[] getVectorOfFrequency(int array[]) {
		int[] result = new int[1000];
		for (int i = 0; i < array.length; i++) {
			result[array[i]]++; 
		}
		return result;
	} 
}