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
		char ch;
		char[] chars = new char[count];		
		boolean minus = false;
		int beginPos = -1;
		int endPos = -1;
		int n = 0;
        for (int i = 0; i < count; i++) {
			ch = (char)bytes[i];
			if (isCharSpaceOrEnter(ch) && (beginPos < 0)) {
				continue;
			} 
			if (isCharSpaceOrEnter(ch) && (endPos >= 0)) {
				continue;
			} 
			if ((ch == '-') && !minus && (beginPos < 0)) {
				minus = true;
				continue;				
			}
			if (isCharDigit(ch) >= 0) {
				chars[i] = (char)bytes[i];
		        if (beginPos < 0) {
					beginPos = i;
				}
			} else {
				if (endPos < 0) {
					if (isCharSpaceOrEnter(ch)) {
						endPos = i;
					} else throw new IllegalArgumentException("Incorrect argument");
				} else {
					throw new IllegalArgumentException("Incorrect argument");
				}	
			}
		}
        if (beginPos < 0) {
			throw new IllegalArgumentException("Incorrect argument");
		}
		int d = 1;
		int result = 0;
		for (int i = endPos - 1; i >= beginPos; i--) {
            result = result + charToInt(chars[i]) * d;
            d = d * 10;
        }
		if (minus) {
			result = -result;
		}	
        return result;
    }

	
	
    private int charToInt(char ch) {
		int result = isCharDigit(ch);
        if (result < 0) {
			throw new IllegalArgumentException("Incorrect argument");
		} else {
			return result;
		}	
    }

    private boolean isCharSpaceOrEnter(char ch) {
		return ((ch == ' ') || (ch == '\t') || (ch == '\n') || (ch == '\r')) ? true : false;
    }
	
    private int isCharDigit(char ch) {
        int result = (byte)ch - (byte)'0';
		return ((result >= 0) && (result <= 9)) ? result : -1;
    }	
}
