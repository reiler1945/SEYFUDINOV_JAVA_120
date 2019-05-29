import java.io.IOException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException, Exception {
        MyScanner myScanner = new MyScanner(System.in);
        int i1 = myScanner.readInt();
        int i2 = myScanner.readInt();
        System.out.println("i1 * i2 = " + (i1 * i2));
        //System.out.println(new Scanner(System.in).nextInt());
    }
}
