package com.jasper.simulation;

public class LC0157_ReadNCharactersGivenRead4 {

    public int read(char[] buf, int n) {

        char[] buffer = new char[4];
        int size = 0;

        int readSize = read4(buffer);
        while (readSize != 0 && n > 0) {
            for (int i = 0; i < readSize; i++) {
                if (n == 0) {
                    return size;
                }

                buf[size] = buffer[i];
                size++;
                n--;
            }
            readSize = read4(buffer);
        }

        return size;
    }

    /**
     * The read4 API is defined in the parent class Reader4.
     * int read4(char[] buf4);
     */
    public int read4(char[] buf4) {
        return Integer.MAX_VALUE;
    }
}
