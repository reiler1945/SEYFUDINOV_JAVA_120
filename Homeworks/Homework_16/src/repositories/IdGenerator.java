package repositories;

import java.io.*;

public class IdGenerator {
    private String fileName;

    public IdGenerator(String fileName) {
        this.fileName = fileName;
    }

    public int generate() {
        try {
            InputStream input = new FileInputStream(this.fileName);
            byte[] bytes = new byte[10];
            input.read(bytes);
            String idAsString = new String(bytes);
            int lastGeneratedId = Integer.parseInt(idAsString.trim());
            lastGeneratedId++;
            input.close();
            OutputStream output = new FileOutputStream(this.fileName);
            idAsString = String.valueOf(lastGeneratedId);
            output.write(idAsString.getBytes());
            output.close();
            return lastGeneratedId;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
