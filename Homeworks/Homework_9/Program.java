/*
Реализовать сортировку слиянием.
*/
import java.util.Arrays;
class Program {
	public static void main(String[] args) {
		int a[] = {-1, 5, -3, 20, 11, 0, 2, 6};
		a = bubbleSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("-----------------------");		
		int b[] = {-1, 5, -3, 20, 11, 0, 2, 6};
		b = selectionSort(b);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		System.out.println("-----------------------");
		int c[] = new int[100];
		for (int i = 0; i < c.length; i++) {
			c[i] = 100 - i;
		}
		int d[] = new int[c.length];
		mergeSort(c, d, 0, c.length - 1);
		System.out.println(Arrays.toString(c));			
	}
	/*сортировка выбором*/
	public static int[] selectionSort(int[] a) {
		for (int k = 0; k < a.length; k++) {
			int min = a[k];
			int index_min = k;
			for (int i = k; i < a.length; i++) {
				if (min > a[i]) {
					index_min = i;
					min = a[i];
				}
			}	
			int temp = a[k];	
			a[k] = a[index_min];
			a[index_min] = temp;
		}
		return a;
	}
	/*сортировка пузырьком*/
	public static int[] bubbleSort(int[] a) {
		for (int i = a.length; i > 0; i--) {	
			for (int j = 0; j < i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		return a;
	}
	/*сортировка слиянием*/
	//lo - low, mi - middle, hi = high	
	public static void mergeSort(int[] a, int[] b, int lo, int hi) {
		// если массив нулевой или единичной длины
		if ((a.length <= 1) || (lo == hi)) {
			b[lo] = a[lo];
			return;
		} else {
			// делим массив на 2 части
			int mi = lo + (hi - lo) / 2;
			// сортируем полученные части
			mergeSort(a, b, lo, mi);
			if (mi < hi) {
				mi++;
			}
			mergeSort(a, b, mi, hi); 
			// производим слияние 2-х отсортированных массивов в третий
			int k = lo;
			int m = mi;
			for (int i = lo; i <= hi; i++) {
				// если не вышли за границу одного из массивов
				if ((k < mi) && (m <= hi)) {
					if (b[k] < b[m]) {
						a[i] = b[k];
						k++;
					} else {
						a[i] = b[m];
						m++;
					}					
				} else {
					// если вышли за границу 
					if (k < mi) {
						a[i] = b[k];
						k++;
					} else {
						a[i] = b[m];
						m++;
					}
				} 
			}
			//переприсваиваем отсортированную часть буферному массиву
			for (int i = lo; i <= hi; i++) {
				b[i] = a[i];
			}	
		}
	}					
}
