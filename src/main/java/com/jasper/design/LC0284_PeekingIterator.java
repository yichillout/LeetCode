package com.jasper.design;

import java.util.*;

class PeekingIterator implements Iterator<Integer> {
	private Iterator<Integer> iter;
	private Integer next;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		iter = iterator;
		if (iter.hasNext()) {
			next = iter.next();
		}
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer res = next;
		next = iter.hasNext() ? iter.next() : null;
		return res;
	}

	@Override
	public boolean hasNext() {
		return next != null;
	}
}

public class LC0284_PeekingIterator {

}
