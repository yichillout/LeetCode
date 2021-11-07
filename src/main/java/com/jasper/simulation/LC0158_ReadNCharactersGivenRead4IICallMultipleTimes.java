package com.jasper.simulation;

public class LC0158_ReadNCharactersGivenRead4IICallMultipleTimes {

    char[] buffer = new char[4];
    int index = -1;
    int readSize = -1;

    public int read(char[] buf, int n) {
        int size = 0;

        while (index < readSize) {
            if (n == 0) {
                return size;
            }

            buf[size] = buffer[index];
            size++;
            index++;
            n--;
        }

        if (n == 0) {
            return size;
        }

        readSize = read4(buffer);

        while (readSize != 0 && n > 0) {
            for (index = 0; index < readSize; index++) {
                if (n == 0) {
                    return size;
                }

                buf[size] = buffer[index];
                size++;
                n--;
            }

            readSize = read4(buffer);
            index = 0;
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
