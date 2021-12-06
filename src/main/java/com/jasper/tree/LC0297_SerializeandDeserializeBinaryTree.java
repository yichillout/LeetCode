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

    public String serialize1(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serializeHelper(builder, root);
        return builder.substring(0, builder.length() - 1);
    }

    public void serializeHelper(StringBuilder builder, TreeNode node) {
        if (node == null) {
            builder.append("#,");
            return;
        }

        builder.append(node.val + ",");
        serializeHelper(builder, node.left);
        serializeHelper(builder, node.right);
    }

    public TreeNode deserialize1(String data) {
        String[] d = data.split(",");
        int[] index = new int[]{0};
        return deserializeHelper(d, index);
    }

    public TreeNode deserializeHelper(String[] d, int[] index) {
        if (d[index[0]].equals("#")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(d[index[0]]));
        index[0]++;
        node.left = deserializeHelper(d, index);
        index[0]++;
        node.right = deserializeHelper(d, index);

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
