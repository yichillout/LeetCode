package com.jasper.design;

import java.util.*;

class RandomizedCollection {

    Map<Integer, Set<Integer>> map;
    List<Integer> data;
    Random random;

    public RandomizedCollection() {
        map = new HashMap<>();
        data = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean isContained = map.containsKey(val);

        if (!isContained) {
            map.put(val, new HashSet<>());
        }

        map.get(val).add(data.size());
        data.add(val);

        return !isContained;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        Set<Integer> indexSet1 = map.get(val);
        int index = indexSet1.iterator().next();

        int lastData = data.get(data.size() - 1);
        Set<Integer> indexSet2 = map.get(lastData);

        data.set(index, lastData);

        indexSet1.remove(index);
        if (indexSet1.size() == 0) {
            map.remove(val);
        }

        if (index != data.size() - 1) {
            indexSet2.remove(data.size() - 1);
            indexSet2.add(index);
        }
        data.remove(data.size() - 1);

        return true;
    }

    public int getRandom() {
        return data.get(random.nextInt(data.size()));
    }
}

public class LC0381_InsertDeleteGetRandomDuplicatesallowed {

}
