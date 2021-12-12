package com.jasper.design;

import java.util.*;

class RandomizedCollection1 {

    List<Integer> data;
    Map<Integer, Set<Integer>> idxMap;
    Random random;

    public RandomizedCollection1() {
        data = new ArrayList<>();
        idxMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (idxMap.containsKey(val)) {
            return false;
        }

        idxMap.put(val, new HashSet<>());
        idxMap.get(val).add(data.size());
        data.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!idxMap.containsKey(val)) {
            return false;
        }

        Set<Integer> idxSet = idxMap.get(val);
        int idxToBeRemoved = idxSet.iterator().next();

        if (idxSet.size() == 1) {
            idxMap.remove(val);
        } else {
            idxSet.remove(idxToBeRemoved);
        }

        int lastIdx = data.size() - 1;
        if (idxToBeRemoved != lastIdx) {
            int lastVal = data.get(lastIdx);
            Set<Integer> lastIdxSet = idxMap.get(lastVal);
            lastIdxSet.add(idxToBeRemoved);
            lastIdxSet.remove(lastIdx);
            data.set(idxToBeRemoved, lastVal);
        }

        data.remove(lastIdx);

        return true;
    }

    public int getRandom() {
        return data.get(random.nextInt(data.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

public class LC0381_InsertDeleteGetRandomO1DuplicatesAllowed {
}
