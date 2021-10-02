package com.jasper.design;

import java.util.*;

class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> numbers;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        numbers = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            numbers.add(val);
            map.put(val, numbers.size() - 1);
            return true;
        }
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            if (numbers.size() == 1) {
                numbers.remove(numbers.size() - 1);
                map.remove(val);
                return true;
            }

            int index = map.get(val);
            int lastIndex = numbers.size() - 1;

            numbers.set(index, numbers.get(lastIndex));
            map.put(numbers.get(lastIndex), index);

            map.remove(val);
            numbers.remove(lastIndex);
            return true;
        }
    }

    public int getRandom() {
        return numbers.get(random.nextInt(numbers.size()));
    }

}

public class LC0380_InsertDeleteGetRandom {

}
