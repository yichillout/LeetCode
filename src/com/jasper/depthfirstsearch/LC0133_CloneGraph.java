package com.jasper.depthfirstsearch;

import java.util.HashMap;

import com.jasper.common.UndirectedGraphNode;

public class LC0133_CloneGraph {

	HashMap<Integer, UndirectedGraphNode> visited = new HashMap<>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		
		if (node == null)
			return node;
		
		if (visited.containsKey(node.label))
			return visited.get(node.label); // this step create the edge

		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		visited.put(clone.label, clone);

		for (UndirectedGraphNode neighbor : node.neighbors)
			clone.neighbors.add(cloneGraph(neighbor));

		return clone;
	}

	public static void main(String[] args) {
		
	}

}
