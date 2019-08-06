import java.lang.*;
class FileCreatorThread extends Thread {
    public FileCreatorThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        TextsGenerator.generateFile(Thread.currentThread().getName());
    }
}