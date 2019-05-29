import java.io.IOException;
import java.io.InputStream;
class MyScanner {

    InputStream in;

    MyScanner(InputStream in){
        this.in = in;
    }

    public int readInt() throws IOException, Exception {
        byte[] bytes = new byte[100];
        int count = in.read(bytes);
        int result = 0;
        char[] chars = new char[count];
        for (int i = 0; i < count; i++) {
            chars[i] = (char)bytes[i];
        }
        final int DECIMAL = 10;
        boolean minus = false;
        boolean beginToRead = false;
        int off = 0;
        int len = 0;
        for (int i = 0; i < chars.length; i++) {
            // пробел или табуляция слева от числа
            if (((chars[i] == ' ') || (chars[i] == ' ')) && (!beginToRead))  {
                continue;
            // пробел или табуляция справа от числа
            } else if (((chars[i] == ' ') || (chars[i] == '\t') || chars[i] == '\n') && beginToRead)  {
                break;
            // целевые символы для конвертации
            } else {
                if (!beginToRead) {
                    beginToRead = true;
                    off = i;
                }
                if (chars[i] == '-') {
                    minus = true;
                    continue;
                };
                len++;
            }
        }
        if ((minus) && (len > 0)) {
            off++;
        }
        int n = 0;
        for (int i = off + len - 1; i >= off; i--) {
            result = result + charToInt(chars[i]) * power(DECIMAL, n);
            n++;
        }
        if (minus) {
            result = -result;
        }
        return result;
    }

    private int charToInt(char ch) throws Exception {
        int result = -1;
        if (ch == '0') {
            result = 0;
        } else if (ch == '1') {
            result = 1;
        } else if (ch == '2') {
            result = 2;
        } else if (ch == '3') {
            result = 3;
        } else if (ch == '4') {
            result = 4;
        } else if (ch == '5') {
            result = 5;
        } else if (ch == '6') {
            result = 6;
        } else if (ch == '7') {
            result = 7;
        } else if (ch == '8') {
            result = 8;
        } else if (ch == '9') {
            result = 9;
        } else throw new Exception();
        return result;
    }

    private int power(int i, int n) {
        if (n == 0) {
            return 1;
        } else {
            return i * power(i, n - 1);
        }
    }
}