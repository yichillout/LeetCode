package com.jasper.stack;

import java.util.*;

public class LC0150_EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {

		if (tokens == null || tokens.length == 0)
			return 0;

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i];
			if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
				int post = stack.pop();
				int prev = stack.pop();
				if (token.equals("+"))
					stack.push(prev + post);
				else if (token.equals("-"))
					stack.push(prev - post);
				else if (token.equals("*"))
					stack.push(prev * post);
				else if (post == 0)
					return 0;
				else
					stack.push(prev / post);
			} else
				stack.push(Integer.parseInt(token));
		}

		return stack.pop();
	}

}
