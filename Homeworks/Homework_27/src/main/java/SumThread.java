import java.lang.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SumThread extends Thread {
    private static final Lock lock = new ReentrantLock();
    private final int numbers[];
    private int start;
    private int finish;

    private int result = 0;

    public SumThread(int numbers[], int start, int finish) {
        this.numbers = numbers;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public void run() {
        for (int i = start; i < finish; i++) {
            int digitsSum = 0;
            int copy = numbers[i];
            while (copy != 0) {
                digitsSum = copy % 10;
                copy = copy / 10;
            }
            result += digitsSum;
        }
        lock.lock();
        Main.MainSumResult += result;
        lock.unlock();
    }

    public int getResult() {
        return result;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }
}