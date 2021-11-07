package com.jasper.tree;

import java.util.ArrayList;
import java.util.List;

public class LC0510_InorderSuccessorInBSTII {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    // solution 1
    public Node inorderSuccessor1(Node node) {
        if (node.right == null) {
            Node result = node.parent;
            while (result != null && result.val < node.val) {
                result = result.parent;
            }
            return result;
        } else {
            Node result = node.right;
            while (result.left != null) {
                result = result.left;
            }
            return result;
        }
    }

    // solution 2
    public Node inorderSuccessor2(Node node) {
        List<Node> list = new ArrayList<>();

        Node cur = node;
        while (cur.parent != null) {
            cur = cur.parent;
        }

        helper(cur, list);

        int i = 0;
        while (i < list.size()) {
            if (list.get(i) == node) {
                break;
            }
            i++;
        }

        if (i + 1 < list.size()) {
            return list.get(i + 1);
        }

        return null;
    }

    public void helper(Node node, List<Node> list) {
        if (node == null) {
            return;
        }

        helper(node.left, list);
        list.add(node);
        helper(node.right, list);
    }
}
