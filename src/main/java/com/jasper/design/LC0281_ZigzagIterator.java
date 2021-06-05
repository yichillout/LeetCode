package com.jasper.design;

import java.util.*;

class ZigzagIterator {
	
	private int length;
	private int index1 = 0;
	private int index2 = 0;
	private List<Integer> list1;
	private List<Integer> list2;
	private boolean useList2;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		this.length = v1.size() + v2.size();
		list1 = v1;
		list2 = v2;
		if (list1.size() == 0) {
			useList2 = true;
		}
	}

	public int next() {
		if (!useList2) {
			if (index2 < list2.size()) {
				useList2 = true;
			}
			return list1.get(index1++);
		} else {
			if (index1 < list1.size()) {
				useList2 = false;
			}
			return list2.get(index2++);
		}

	}

	public boolean hasNext() {
		return (index1 + index2) < length;
	}
}

public class LC0281_ZigzagIterator {

}
