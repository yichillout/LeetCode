package com.jasper.design;

import java.util.*;

// Solution 1: two stack
class MinStack1 {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public MinStack1() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek())
			minStack.push(x);
	}

	public void pop() {
		int x = stack.pop();
		if (x == minStack.peek())
			minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}

// Solution 2: one stack -- The idea is to store node
class MinStack2 {
	private Stack<Node> stack;

	public MinStack2() {
		this.stack = new Stack<>();
	}

	public void push(int x) {
		int min = Math.min(x, getMin());
		this.stack.push(new Node(x, min));
	}

	public void pop() {
		this.stack.pop();
	}

	public int top() {
		return this.stack.peek().val;
	}

	public int getMin() {
		if (this.stack.isEmpty())
			return Integer.MAX_VALUE;
		return this.stack.peek().min;
	}

	private class Node {
		public int min;
		public int val;

		public Node(int val, int min) {
			this.val = val;
			this.min = min;
		}
	}
}

// Solution 3: one stack
// -- The idea is to store the gap between the min value and the current value;
class MinStack3 {
	long min;
	Stack<Long> stack;

	public MinStack3() {
		stack = new Stack<>();
	}

	public void push(int x) {
		if (stack.isEmpty()) {
			stack.push(0L);
			min = x;
		} else {
			stack.push(x - min);// Could be negative if min value needs to
								// change
			if (x < min)
				min = x;
		}
	}

	public void pop() {
		if (stack.isEmpty())
			return;

		long pop = stack.pop();

		if (pop < 0)
			min = min - pop;// If negative, increase the min value

	}

	public int top() {
		long top = stack.peek();
		if (top > 0) {
			return (int) (top + min);
		} else {
			return (int) (min);
		}
	}

	public int getMin() {
		return (int) min;
	}
}

public class LC0155_MinStack {

}
