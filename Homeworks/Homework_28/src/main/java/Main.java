import java.util.Scanner;
import java.lang.*;

public class Main {
    static int wordsCountInFile = 0;
    static int filesCount = 0;
    static String dictionaryName = "files//";

    public static void main(String[] args) {

        // задаем начальные условия
        String fileName = "Words.txt";
        TextsGenerator.loadWords(fileName);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter wordsCountInFile: ");
        wordsCountInFile = scanner.nextInt();
        System.out.println("Enter filesCount: ");
        filesCount = scanner.nextInt();

        long time_before = 0;
        long time_after = 0;
        //последовательное выполнение
        time_before = System.currentTimeMillis();
        for (int i = 0; i < filesCount; i++) {
            TextsGenerator.generateFile(Thread.currentThread().getName() + " #" + i);
        }
        time_after = System.currentTimeMillis();
        System.out.println("time sequential: " + (time_after - time_before));

        //параллельное выполнение
        time_before = System.currentTimeMillis();
        Thread[] threads = new Thread[filesCount];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new FileCreatorThread("Thread #" + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }
        time_after = System.currentTimeMillis();
        System.out.println("time parallel: " + (time_after - time_before));
    }
}