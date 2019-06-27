/*сортировка пузырьком*/
class Program{
	public static void main(String[] args) {
		int a[] = {-1, 5, -3, 20, 11, 0, 2, 6};
		for (int i = a.length; i > 0; i--) {	
			for (int j = 0; j < i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}