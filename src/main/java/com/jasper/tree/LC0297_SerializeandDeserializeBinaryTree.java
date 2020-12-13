package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0297_SerializeandDeserializeBinaryTree {

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		if (root == null)
			return null;

		StringBuilder sb = new StringBuilder();
		serializeHelper(sb, root);
		return sb.toString().substring(0, sb.length() - 1);
	}

	public static void serializeHelper(StringBuilder sb, TreeNode node) {
		if (node != null) {
			sb.append(node.val + ",");
			serializeHelper(sb, node.left);
			serializeHelper(sb, node.right);
		} else {
			sb.append("#,");
		}
	}

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		if (data == null)
			return null;

		int[] t = { 0 };
		String[] arr = data.split(",");

		return helper(arr, t);
	}

	public static TreeNode helper(String[] arr, int[] t) {
		if (arr[t[0]].equals("#")) {
			return null;
		}

		TreeNode root = new TreeNode(Integer.parseInt(arr[t[0]]));

		t[0] = t[0] + 1;
		root.left = helper(arr, t);
		t[0] = t[0] + 1;
		root.right = helper(arr, t);

		return root;
	}

}
