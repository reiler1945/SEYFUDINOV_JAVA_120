/*
Реализовать сортировку слиянием.
*/
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
		int c[] = {-1, 5, -3, 20, 11, 0, 2, 6};
		c = mergeSort(c);
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}				
		System.out.println("-----------------------");
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
	public static int[] mergeSort(int[] a) {
		// если массив нулевой или единичной длины
		if (a.length <= 1) {
			return a;	
		} else {
			// делим массив на 2 части
			int[] left = new int[a.length / 2];
			int[] right = new int[a.length - left.length];
			for (int i = 0; i < a.length; i++) {
				if (i < left.length) {
					left[i] = a[i];
				}	
				else { 	
					right[i - left.length] = a[i];
				}		
			} 
			// сортируем полученные части
			left = mergeSort(left);
			right = mergeSort(right); 
			// производим слияние 2-х отсортированных массивов в третий
			int[] result = new int[left.length + right.length];
			int k = 0;
			int m = 0;
			for (int i = 0; i < (left.length + right.length); i++) {
				// если не вышли за границу одного из массивов
				if ((k < left.length) && (m < right.length)) {
					if (left[k] < right[m]) {
						result[i] = left[k];
						k++;
					} else {
						result[i] = right[m];
						m++;
					}					
				} else {
					// если вышли за границу right
					if (k < left.length) {
						result[i] = left[k];
						k++;
					} else {
						result[i] = right[m];
						m++;
					}
				} 
			}
			return result;
		}
	}					
}