import java.lang.*;
import java.io.*;
class MyScanner {

    InputStream in;

    MyScanner(InputStream in){
        this.in = in;
    }

    public int readInt() throws IOException {
        byte[] bytes = new byte[100];
        int count = in.read(bytes);
        int result = 0;
        char[] chars = new char[count];
        for (int i = 0; i < count; i++) {
            chars[i] = (char)bytes[i];
        }
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
        int d = 1;
        for (int i = off + len - 1; i >= off; i--) {
            result = result + charToInt(chars[i]) * d;
            d = d * 10;
        }
        if (minus) {
            result = -result;
        }
        return result;
    }

    private int charToInt(char ch) {
        int result = -1;
		result = (byte)ch - (byte)'0';
		if (!((result >= 0) && (result <= 9))) {
			throw new IllegalArgumentException("Incorrect argument");
		}
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
