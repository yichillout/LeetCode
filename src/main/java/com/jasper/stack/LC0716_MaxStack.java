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
        if (stack.isEmpty()) {
            maxStack.push(x);
        } else {
            maxStack.push(x > maxStack.peek() ? x : maxStack.peek());
        }

        stack.push(x);
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
        Stack<Integer> tmp = new Stack<>();

        int max = maxStack.peek();

        while (stack.peek() != max) {
            tmp.push(stack.pop());
            maxStack.pop();
        }

        stack.pop();
        maxStack.pop();

        while (!tmp.isEmpty()) {
            push(tmp.pop());
        }

        return max;
    }
}

public class LC0716_MaxStack {

    public static void main(String[] args) {
        MaxStack stk = new MaxStack();
        stk.push(5);   // [5] the top of the stack and the maximum number is 5.
        stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
        stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
        stk.top();     // return 5, [5, 1, 5] the stack did not change.
        stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
        stk.top();     // return 1, [5, 1] the stack did not change.
        stk.peekMax(); // return 5, [5, 1] the stack did not change.
        stk.popMax();     // return 1, [5] the top of the stack and the max element is now 5.
        stk.top();     // return 5, [5] the stack did not change.
    }

}
