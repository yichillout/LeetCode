package com.jasper.stack;

import java.util.Stack;

class MaxStack {

    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        pushHelper(x);
    }

    public void pushHelper(int x) {
        int tempMax = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
        if (x > tempMax) {
            tempMax = x;
        }
        stack.push(x);
        maxStack.push(tempMax);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> temp = new Stack<>();

        while (stack.peek() != max) {
            temp.push(stack.pop());
            maxStack.pop();
        }

        stack.pop();
        maxStack.pop();

        while (!temp.isEmpty()) {
            int x = temp.pop();
            pushHelper(x);
        }

        return max;
    }
}

public class LC0716_MaxStack {
}
