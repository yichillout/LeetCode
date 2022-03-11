package com.company.amazon.oa;

import java.util.ArrayList;
import java.util.List;


/**
 * Input is an encoded string and a rowNumber, and your purpose is designing a method to decode it
 * How does the encoding work? For example, if string "my name is" will be encoded with rowNumber = 3, it will use a metrix to represent the original string first
 * i.e.
 *  m n e s _
 *  _ y a _ _
 *  _ _ _ m i
 *
 * You need read it from upper left to lower right, first char is in metrix[0][0] and second char should be in metrix[1][1] etc.
 * and the input is constructed by this metrix line by line, means it will look like : "mnes__ya_____mi"
 * If string "my name is" encoded with rowNumber = 4, it will look like:
 *  m a i _ _
 *  _ y m s _
 *  _ _ _ e _
 *  _ _ _ n _
 * and the input will become "mai___yms____e____n_"
 * You need decode the input string with rowNumber it provide and return the original string, remember to replace all '_' with space.
 */
public class DecodeString {

    static String decode(String input, int numOfRows) {
        List<String> image = new ArrayList<>();
        int col = input.length() / numOfRows;
        for (int i = 0; i < numOfRows; i++) {
            image.add(input.substring(i * col, i * col + col));
        }

        StringBuilder sb = new StringBuilder();
        int nextY = 0;
        for (int x = 0, y = 0; x < numOfRows && y < col; ) {
            sb.append(image.get(x).charAt(y));
            x++; y++;
            if (y >= col || x >= numOfRows) {
                x = 0;
                y = ++nextY;
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(decode("hlowrd el ol", 2));
        System.out.println(decode("hyt    a t    rpe    ror", 4));
        System.out.println(decode("mnes__ya_____mi", 3));
    }
}