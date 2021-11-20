import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class UsefulUtil {


    public static void main(String[] args) {

    }

    @Test
    public void charArrayToString() {
        char[] str = new char[]{'1', '2', '3', '4', '5'};

        String str1 = new String(str);
        String str2 = new String(str, 2, 2);
        String str3 = new String(str, 2, str.length - 2);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }


    @Test
    public void loopMap() {
        Map<Integer, Integer> freqs = new HashMap<>();
        freqs.put(1, 1);
        freqs.put(2, 2);

        for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
            System.out.println(entry.getKey());
        }

        for (int key : freqs.keySet()) {
            System.out.println(key);
        }

        for (int value : freqs.values()) {
            System.out.println(value);
        }
    }

    @Test
    public void splitUsage() {
        String str = "geekss@for@@geekss@";
        String[] arr0 = str.split("@");
        String[] arr1 = str.split("@", 3);
        String[] arr2 = str.split("@", 5);
        String[] arr3 = str.split("@", -1);

        for (String a : arr0) {
            System.out.println(a);
        }
        System.out.println("----------");
        for (String a : arr1) {
            System.out.println(a);
        }
        System.out.println("----------");
        for (String a : arr2) {
            System.out.println(a);
        }
        System.out.println("----------");
        for (String a : arr3) {
            System.out.println(a);
        }
    }
}
