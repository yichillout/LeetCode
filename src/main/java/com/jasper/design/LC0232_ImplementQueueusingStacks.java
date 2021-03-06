package com.jasper.design;

import java.util.*;

class MyQueue {

	Stack<Integer> input;
	Stack<Integer> output;

	public MyQueue() {
		input = new Stack<Integer>();
		output = new Stack<Integer>();
	}

	public void push(int x) {
		input.push(x);
	}

	public int pop() {
		peek();
		return output.pop();
	}

	public int peek() {
		if (output.isEmpty()) {
			while (!input.isEmpty()) {
				output.push(input.pop());
			}
		}
		return output.peek();
	}

	public boolean empty() {
		return input.isEmpty() && output.isEmpty();
	}
}

public class LC0232_ImplementQueueusingStacks {

	public static void main(String[] args) {
		MyQueue obj = new MyQueue();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		int param_2 = obj.pop();
		int param_3 = obj.peek();

		System.out.println(param_2);
		System.out.println(param_3);
	}

}
