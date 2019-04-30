/*сортировка выбором*/
class Program{
	public static void main(String[] args) {
		int a[] = {-1, 5, -3, 20, 11, 0, 2, 6};
		for (int k = 0; k < a.length; k++) {
			int max = a[k];
			int i_max = k;
			for (int i = k; i < a.length; i++) {
				i_max = max > a[i] ? i : i_max;
				max = max > a[i] ? a[i] : max; 
			}	
			int temp = a[k];	
			a[k] = a[i_max];
			a[i_max] = temp;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}