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

// Solution 2: one stack
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
class MinStack3 {

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();

    public void push(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

public class LC0155_MinStack {

}
