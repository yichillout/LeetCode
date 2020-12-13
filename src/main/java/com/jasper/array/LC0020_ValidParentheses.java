package com.jasper.array;

import java.util.*;

public class LC0020_ValidParentheses {
	public static boolean isValid(String s) {

		Stack<Character> stack = new Stack<Character>();

		if (s == null)
			return false;

		if (s.equals(""))
			return true;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (!stack.isEmpty() && c == ')') {
				if (stack.pop() != '(')
					return false;
			} else if (!stack.isEmpty() && c == ']') {
				if (stack.pop() != '[')
					return false;
			} else if (!stack.isEmpty() && c == '}') {
				if (stack.pop() != '{')
					return false;
			} else {
				return false;
			}
		}

		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
