/*сортировка выбором*/
class Program{
	public static void main(String[] args) {
		int a[] = {-1, 5, -3, 20, 11, 0, 2, 6};
		for (int k = 0; k < a.length; k++) {
			int min = a[k];
			int i_min = k;
			for (int i = k; i < a.length; i++) {
				i_min = min > a[i] ? i : i_min;
				min = min > a[i] ? a[i] : min; 
			}	
			int temp = a[k];	
			a[k] = a[i_min];
			a[i_min] = temp;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}