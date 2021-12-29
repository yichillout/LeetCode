package com.jasper.stack;

import java.util.Stack;


class BrowserHistory {

    Stack<String> historyStack;
    Stack<String> futureStack;

    public BrowserHistory(String homepage) {
        historyStack = new Stack<>();
        historyStack.push(homepage);
        futureStack = new Stack<>();
    }

    public void visit(String url) {
        historyStack.push(url);
        futureStack = new Stack<>();
    }

    public String back(int steps) {
        while (historyStack.size() > 1 && steps > 0) {
            futureStack.push(historyStack.pop());
            steps--;
        }

        return historyStack.peek();
    }

    public String forward(int steps) {
        while (futureStack.size() > 0 && steps > 0) {
            historyStack.push(futureStack.pop());
            steps--;
        }

        return historyStack.peek();
    }
}

public class LC1472_DesignBrowserHistory {

    public static void main(String[] args) {
        BrowserHistory bh = new BrowserHistory("leetcode.com");
        bh.visit("google.com");
        bh.visit("facebook.com");
        bh.visit("youtube.com");

        System.out.println(bh.back(1));
        System.out.println(bh.back(1));
        System.out.println(bh.forward(1));

        bh.visit("linkedin.com");

        System.out.println(bh.forward(2));
        System.out.println(bh.back(2));
        System.out.println(bh.back(7));
    }
}
