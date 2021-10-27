package com.jasper.simulation;

public class LC0043_MultiplyStrings {

    public String multiply(String num1, String num2) {

        int n = num1.length();
        int m = num2.length();

        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();

        int[] result = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int num = (n1[i] - '0') * (n2[j] - '0');
                int index1 = i + j;
                int index2 = i + j + 1;

                int sum = num + result[index2] + result[index1] * 10;

                result[index2] = sum % 10;
                result[index1] = sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < result.length; i++) {
            if (sb.length() == 0 && result[i] == 0) {
                continue;
            }
            sb.append(result[i]);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
