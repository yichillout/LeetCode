package com.jasper.tree;

import java.util.ArrayList;
import java.util.List;

public class LC0428_SerializeAndDeserializeNAryTree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    // Encodes a tree to a single string.
    public String serialize(Node root) {
        List<String> res = new ArrayList<>();
        serializeDfs(root, res);
        return String.join(",", res);
    }

    public void serializeDfs(Node node, List<String> res) {
        if (node == null) {
            return;
        }

        res.add(String.valueOf(node.val));
        res.add(String.valueOf(node.children.size()));

        for (Node child : node.children) {
            serializeDfs(child, res);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.equals("")) {
            return null;
        }

        int[] index = new int[1];
        String[] strs = data.split(",");
        return deserializeDfs(strs, index);
    }

    public Node deserializeDfs(String[] strs, int[] index) {
        Node node = new Node(Integer.parseInt(strs[index[0]]), new ArrayList<>());
        index[0]++;

        int size = Integer.parseInt(strs[index[0]]);
        index[0]++;

        for (int i = 0; i < size; i++) {
            node.children.add(deserializeDfs(strs, index));
        }

        return node;
    }
}
