package com.jasper.design;

import java.util.*;

class MyStack {

	Queue<Integer> queue;

	public MyStack() {
		queue = new LinkedList<Integer>();
	}

	public void push(int x) {
		queue.add(x);
		int size = queue.size();
		for (int i = 0; i < size - 1; i++) {
			queue.add(queue.poll());
		}
	}

	public int pop() {
		return queue.poll();
	}

	public int top() {
		return queue.peek();
	}

	public boolean empty() {
		return queue.isEmpty();
	}
}

public class LC0225_ImplementStackusingQueues {

	public static void main(String[] args) {
		MyStack obj = new MyStack();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		int param_2 = obj.pop();
		int param_3 = obj.top();

		System.out.println(param_2);
		System.out.println(param_3);
	}

}
