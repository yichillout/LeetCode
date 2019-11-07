package com.jasper.stack;

import java.util.Stack;

public class LC0388_LongestAbsoluteFilePath {

	public static int lengthLongestPath(String input) {
		String[] item = input.split("\n");
		int longestLength = 0;
		int currLength = 0;
		Stack<Integer> stack = new Stack<Integer>();

		for (String s : item) {
			// Find level of the current item, level is calculated by counting number of \t
			int level = 0;
			boolean isFile = false;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '\t')
					level++;
				else if (s.charAt(i) == '.')
					isFile = true;
			}

			// If the current item is a few levels back up, we need to pop out all the items
			// until we get to the parent of the current item so we can push the current
			// item into the stack
			while (stack.size() > level) {
				currLength -= stack.pop();
			}

			int itemSize = s.length() - level + 1; // plus one because directories and files start with '/'' e.g.
													// "/subdir2"
			currLength += itemSize;

			// Only update the longestLength if a file is found.
			if (isFile) {
				// We subtract 1 from the currLength because the first directory doesn't have
				// '/'' in the front. e.g. "dir/subdir2/subsubdir2/file2.ext"
				if (currLength - 1 > longestLength) {
					longestLength = currLength - 1;
				}
			}

			stack.add(itemSize);
		}

		return longestLength;
	}

	public static void main(String[] args) {

		System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));

	}

}
