package com.jasper.depthfirstsearch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.jasper.common.Node;

public class LC0133_CloneGraph {

    // solution 1 : BFS
    public Node cloneGraph1(Node node) {

        if (node == null) {
            return null;
        }

        Map<Node, Node> oldToNewMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];


        queue.offer(node);
        visited[node.val] = true;
        oldToNewMap.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                for (Node neighbor : cur.neighbors) {
                    if (!visited[neighbor.val]) {
                        queue.offer(neighbor);
                        visited[neighbor.val] = true;
                        oldToNewMap.put(neighbor, new Node(neighbor.val));
                    }
                }
            }
        }


        for (Map.Entry<Node, Node> entry : oldToNewMap.entrySet()) {
            Node oldNode = entry.getKey();
            Node newNode = entry.getValue();
            for (Node oldNeighbor : oldNode.neighbors) {
                Node newNeighbor = oldToNewMap.get(oldNeighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }

        return oldToNewMap.get(node);
    }


    // solution 2 : DFS
    HashMap<Integer, Node> visited = new HashMap<>();

    public Node cloneGraph2(Node node) {

        if (node == null)
            return node;

        if (visited.containsKey(node.val))
            return visited.get(node.val); // this step create the edge

        Node clone = new Node(node.val);
        visited.put(clone.val, clone);

        for (Node neighbor : node.neighbors)
            clone.neighbors.add(cloneGraph2(neighbor));

        return clone;
    }
}
