package com.jasper.breadthfirstsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.jasper.common.TreeNode;

public class LC0103_BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        levelRecursion2(root, result, 0);
        return result;
    }

    private void levelRecursion2(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) {
            return;
        }
        if (result.size() < level + 1) {// need one more line
            result.add(new LinkedList<>());
        }
        if (level % 2 != 0) {
            ((LinkedList<Integer>) result.get(level)).addFirst(node.val);
        } else {
            result.get(level).add(node.val);
        }

        levelRecursion2(node.left, result, level + 1);
        levelRecursion2(node.right, result, level + 1);
    }

    public static void main(String[] args) {

    }
}
