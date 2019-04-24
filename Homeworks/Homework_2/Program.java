/*
 реализовать программу, которая для некоторого целого числа, к примеру 13765 подсчитывает
 кол-во 5000, 2000, 1000, 500, 200, 100, 50, 10, 1 
*/
import java.util.Scanner;
class Program_2 {
  public static void main(String args[]){
	Scanner scanner = new Scanner(System.in);
	int sum = scanner.nextInt();
	int x5000, x2000, x1000, x500, x200, x100, x50, x10, x1;
	x5000 = sum / 5000;
	sum %= 5000;
	x2000 = sum / 2000;
	sum %= 2000;
	x1000 = sum / 1000;
	sum %= 1000;
	x500 = sum / 500;
	sum %= 500;
	x200 = sum / 200;
	sum %= 200;
	x100 = sum / 100;
	sum %= 100;
	x50 = sum / 50;
	sum %= 50;	
	x10 = sum / 10;
	sum %= 10;		
	x1 = sum;
	System.out.print(
					 x5000 + " - 5000\n" +
					 x2000 + " - 2000\n" +
					 x1000 + " - 1000\n" +
					 x500 + " - 500\n" +
					 x200 + " - 200\n" +
					 x100 + " - 100\n" +
					 x50 + " - 50\n" +
					 x10 + " - 10\n" +
					 x1 + " - 1"
    );
  }
}