package com.jasper.simulation;

import java.util.ArrayList;
import java.util.List;

public class LC0412_FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<>(n);
        int fizz = 0;
        int buzz = 0;
        for (int i = 1; i <= n; i++) {
            fizz++;
            buzz++;
            if (fizz == 3 && buzz == 5) {
                ret.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else if (fizz == 3) {
                ret.add("Fizz");
                fizz = 0;
            } else if (buzz == 5) {
                ret.add("Buzz");
                buzz = 0;
            } else {
                ret.add(String.valueOf(i));
            }
        }
        return ret;
    }
}
