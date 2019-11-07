package com.jasper.design;

import java.util.*;

class Vector2D {

	private List<List<Integer>> list;
	private int listIndex;
	private int elemIndex;

	public Vector2D(List<List<Integer>> vec2d) {
		list = vec2d;
		listIndex = 0;
		elemIndex = 0;
	}

	public int next() {
		return list.get(listIndex).get(elemIndex++);
	}

	public boolean hasNext() {
		while (listIndex < list.size()) {
			if (elemIndex < list.get(listIndex).size()) {
				return true;
			} else {
				listIndex++;
				elemIndex = 0;
			}
		}

		return false;
	}
}

public class LC0251_Flatten2DVector {

}
