package com.jasper.tree;

import com.jasper.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC0297_SerializeandDeserializeBinaryTree {

    /**
     * solution 1 : DFS
     * <p>
     *     1
     *   2   3
     *     4   5
     * <p>
     * 1,2,#,#,3,4,#,#,5,#,#
     */

    // solution 1 : DFS
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    public void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }

        sb.append(node.val + ",");

        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] index = new int[1];
        String[] strs = data.split(",");
        return deserializeHelper(strs, index);
    }

    public TreeNode deserializeHelper(String[] strs, int[] index) {

        if (strs[index[0]].equals("#")) {
            index[0]++;
            return null;
        }

        int val = Integer.parseInt(strs[index[0]]);
        index[0]++;
        TreeNode node = new TreeNode(val);

        node.left = deserializeHelper(strs, index);
        node.right = deserializeHelper(strs, index);

        return node;
    }

    // solution 2 : BFS
    public String serialize2(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> qu = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        qu.offer(root);
        sb.append(String.valueOf(root.val));
        sb.append(' ');
        while (!qu.isEmpty()) {
            TreeNode x = qu.poll();
            if (x.left == null) sb.append("null ");
            else {
                qu.offer(x.left);
                sb.append(String.valueOf(x.left.val));
                sb.append(' ');
            }
            if (x.right == null) sb.append("null ");
            else {
                qu.offer(x.right);
                sb.append(String.valueOf(x.right.val));
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize2(String data) {
        if (data.length() == 0) return null;
        String[] node = data.split(" ");
        Queue<TreeNode> qu = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(node[0]));
        qu.offer(root);
        int i = 1;
        while (!qu.isEmpty()) {
            Queue<TreeNode> nextQu = new LinkedList<>();
            while (!qu.isEmpty()) {
                TreeNode x = qu.poll();
                if (node[i].equals("null")) x.left = null;
                else {
                    x.left = new TreeNode(Integer.valueOf(node[i]));
                    nextQu.offer(x.left);
                }
                i++;
                if (node[i].equals("null")) x.right = null;
                else {
                    x.right = new TreeNode(Integer.valueOf(node[i]));
                    nextQu.offer(x.right);
                }
                i++;
            }
            qu = nextQu;
        }
        return root;
    }
}
