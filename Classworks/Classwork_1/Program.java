class Program {
	public static void main(String args[]) {
		int number = 135;
		int x0, x1, x2, x3, x4, x5, x6, x7;
		x0 = number % 2;	
		number >>= 1;
		x1 = number % 2;
		number >>= 1;
		x2 = number % 2;
		number >>= 1;
		x3 = number % 2;
		number >>= 1;
		x4 = number % 2;
		number >>= 1;
		x5 = number % 2;
		number >>= 1;
		x6 = number % 2;
		number >>= 1;
		x7 = number % 2;
		number >>= 1;
		System.out.println(x7 + "" + x6 + "" + x5 + "" + x4 + "" + x3 + "" + x2 + "" + x1 + "" + x0);
	}
}