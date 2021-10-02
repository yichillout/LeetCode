package com.jasper.tree;

import java.util.ArrayList;
import java.util.List;

public class LC1650_LowestCommonAncestorOfABinaryTreeIII {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    // solution 1
    public Node lowestCommonAncestor1(Node p, Node q) {

        Node cur1 = p;
        Node cur2 = q;

        List<Node> list1 = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();

        while (cur1.parent != null) {
            list1.add(cur1);
            cur1 = cur1.parent;
        }
        list1.add(cur1);

        while (cur2.parent != null) {
            list2.add(cur2);
            cur2 = cur2.parent;
        }
        list2.add(cur2);

        for (int i = 0; i < list1.size(); i++) {
            if (q.val == list1.get(i).val) {
                return q;
            }
        }

        for (int i = 0; i < list2.size(); i++) {
            if (p.val == list2.get(i).val) {
                return p;
            }
        }

        int index1 = list1.size() - 1;
        int index2 = list2.size() - 1;
        Node prev = null;

        while (index1 >= 0 && index2 >= 0) {
            if (list1.get(index1).val != list2.get(index2).val) {
                break;
            }
            prev = list1.get(index1);
            index1--;
            index2--;
        }

        return prev;
    }

    // solution 2
    public Node lowestCommonAncestor2(Node p, Node q) {

        Node cur1 = p;
        Node cur2 = q;

        while (cur1 != cur2) {
            cur1 = cur1.parent == null ? q : cur1.parent;
            cur2 = cur2.parent == null ? p : cur2.parent;
        }

        return cur1;
    }

}
