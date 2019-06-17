/*
https://avatars.mds.yandex.net/get-yabs_performance/1906317/2a0000016b0bb578ce24c19c3ed66f4ee7e0/huge
/Users/reiler/Desktop/SEYFUDINOV_JAVA_120/Homeworks/Homework_14
 */

import java.util.Scanner;
import java.net.URL;
import java.io.*;
class Main {
    public static void main(String args[]) throws Exception {
        byte bytes[] = new byte[1024 * 1024 * 5]; //5 Mb
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the url address:");
        String url = scanner.nextLine();//Line();
        //url = "http://macmy.ru/uploads/posts/2015-01/1420524440_3567.jpg";
        System.out.println("Enter the save folder address:");
        String folder = scanner.nextLine();
        while ( (!url.equals("exit")) || (!folder.equals("exit")) ) {
            InputStream inputStream = new URL(url).openStream();
            int c = inputStream.read();
            int i = 0;
            while (c != -1) {
                bytes[i] = (byte)c;
                i++;
                c = inputStream.read();
            }
            OutputStream outputStream = new FileOutputStream(folder + "/" + i + ".jpg");
            outputStream.write(bytes, 0, i);

            outputStream.close();
            inputStream.close();

            System.out.println("Enter the url address:");
            url = scanner.nextLine();
            System.out.println("Enter the save folder address:");
            folder = scanner.nextLine();
        }
    }
}
