package com.jasper.string;

public class LC0616_AddBoldTagInString {

    public static String addBoldTag(String s, String[] words) {

        int length = s.length();
        boolean nonBold = true;
        boolean[] isBold = new boolean[length];
        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            int index = s.indexOf(word);

            while (index != -1) {
                for (int i = index; i < index + word.length(); i++) {
                    isBold[i] = true;
                }

                index = s.indexOf(word, index + 1);
            }
        }

        for (int i = 0; i < length; i++) {
            if (isBold[i]) {
                if (nonBold) {
                    ans.append("<b>");
                    nonBold = false;
                }

                ans.append(s.charAt(i));
            } else {
                if (!nonBold) {
                    ans.append("</b>");
                    nonBold = true;
                }

                ans.append(s.charAt(i));
            }
        }

        if (!nonBold) {
            ans.append("</b>");
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        addBoldTag("abcxyz123", new String[]{"abc", "123"});
    }
}
