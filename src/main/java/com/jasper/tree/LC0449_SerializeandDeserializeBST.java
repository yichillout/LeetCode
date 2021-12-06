package com.jasper.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.jasper.common.TreeNode;

public class LC0449_SerializeandDeserializeBST {

    // solution 1 : DFS general way
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


    // Solution 1 : BFS
    public static String serialize2(TreeNode root) {
        if (root == null) {
            return "{}";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        sb.append("{");

        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (head == null) {
                sb.append("#");
            } else {
                sb.append(head.val);
                queue.offer(head.left);
                queue.offer(head.right);
            }

            if (!queue.isEmpty()) {
                sb.append(",");
            }
        }

        sb.append("}");
        return sb.toString();
    }

    public static TreeNode deserialize2(String data) {

        if (data == null || data.equals("{}")) {
            return null;
        }

        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));

        list.add(root);
        int index = 0;

        boolean isLeftChild = true;

        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    list.get(index).left = node;
                } else {
                    list.get(index).right = node;
                }
                list.add(node);
            }
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(5);

        String str = serialize2(root);
        System.out.println(str);

        TreeNode result = deserialize2(str);
    }
}
