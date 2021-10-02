package com.jasper.simulation;

public class LC0157_ReadNCharactersGivenRead4 {

    public int read(char[] buf, int n) {

        char[] buffer4 = new char[4];
        boolean isEnd = false;
        int readIndex = 0;

        while (readIndex < n && !isEnd) {
            int count = read4(buffer4);

            if (count < 4) {
                isEnd = true;
            }

            int remainingCount = n - readIndex;

            int needToReadCount = Math.min(remainingCount, count);

            for (int i = 0; i < needToReadCount; i++) {
                buf[readIndex++] = buffer4[i];
            }
        }

        return readIndex;
    }

    /**
     * The read4 API is defined in the parent class Reader4.
     * int read4(char[] buf4);
     */
    public int read4(char[] buf4) {
        return Integer.MAX_VALUE;
    }
}
