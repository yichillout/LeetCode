package com.jasper.design;

import java.util.*;

class RandomizedCollection {

	ArrayList<Integer> result;
	HashMap<Integer, LinkedHashSet<Integer>> map;

	public RandomizedCollection() {
		result = new ArrayList<Integer>();
		map = new HashMap<Integer, LinkedHashSet<Integer>>();
	}

	public boolean insert(int val) {
		boolean alreadyExists = map.containsKey(val);
		if (!alreadyExists) {
			map.put(val, new LinkedHashSet<Integer>());
		}
		map.get(val).add(result.size());
		result.add(val);
		return !alreadyExists;
	}

	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		LinkedHashSet<Integer> valSet = map.get(val);
		int indexToReplace = valSet.iterator().next();

		int numAtLastPlace = result.get(result.size() - 1);
		LinkedHashSet<Integer> replaceWith = map.get(numAtLastPlace);

		result.set(indexToReplace, numAtLastPlace);

		valSet.remove(indexToReplace);

		if (indexToReplace != result.size() - 1) {
			replaceWith.remove(result.size() - 1);
			replaceWith.add(indexToReplace);
		}
		result.remove(result.size() - 1);

		if (valSet.isEmpty()) {
			map.remove(val);
		}
		return true;
	}

	public int getRandom() {
		return result.get((int) (Math.random() * result.size()));
	}
}

public class LC0381_InsertDeleteGetRandomDuplicatesallowed {

}
