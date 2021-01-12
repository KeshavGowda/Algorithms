package com.algoexpert.trees.binarytrees;

public class NodeDepths {
	
	//Should return sum of each node's depths.
	
	public static void main(String[] args) {
		System.out.println(nodeDepths(test()));
	}

	public static int nodeDepths(BinaryTree root) {
		if (root.left == null && root.right == null)
			return 0;
		
		return traverse(root, 0);
	}
	
	private static int traverse(BinaryTree node, int curDepth) {
		int depth = curDepth;
		if (node.left != null)
			depth += traverse(node.left, curDepth+1);
		if (node.right != null)
			depth += traverse(node.right, curDepth+1);
		return depth;
	}

	static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}
	
	private static BinaryTree test() {
		BinaryTree l = new BinaryTree(2);
		BinaryTree r = new BinaryTree(3);
		BinaryTree m = new BinaryTree(1);
		m.left = l;
		m.right = r;
		return m;
	}

}
