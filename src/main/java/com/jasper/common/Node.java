package com.jasper.common;

import java.util.ArrayList;
import java.util.List;

public class Node {
	public int val;
	public List<Node> neighbors;

	public Node(int x) {
		val = x;
		neighbors = new ArrayList<Node>();
	}
};
