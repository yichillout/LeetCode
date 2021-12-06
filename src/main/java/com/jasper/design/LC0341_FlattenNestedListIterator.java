package com.jasper.design;

import java.util.*;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a
    // nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return stack.pop().getInteger();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (stack.peek().isInteger()) { // always keep the top one is a single integer rather than nested list.
                return true;
            }
            NestedInteger curr = stack.pop();
            for (int i = curr.getList().size() - 1; i >= 0; i--) {
                stack.push(curr.getList().get(i));
            }
        }
        return false;
    }
}

public class LC0341_FlattenNestedListIterator {
}
