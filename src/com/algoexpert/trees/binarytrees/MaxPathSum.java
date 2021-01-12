package com.algoexpert.trees.binarytrees;

public class MaxPathSum {
	
	public static void main(String[] args) {
		System.out.println(maxPathSum(test()));
	}

	public static int maxPathSum(BinaryTree tree) {
		
	}
	
	private static SumValues maxPathSumValue(BinaryTree tree) {
		if (tree == null) 
			return new SumValues(0, 0);
		else if (tree.left == null && tree.right == null) 
			return new SumValues(tree.value, tree.value);
		SumValues left;
		SumValues right;
		if (tree.left != null)
			left = maxPathSumValue(tree.left);
		if (tree.right != null)
			right = maxPathSumValue(tree.right);
	}

	static class BinaryTree {
		public int value;
		public BinaryTree left;
		public BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
		}
	}
	
	static class SumValues {
		public int maxSumBranch;
		public int runningMaxSumBranch;
		
		public SumValues(int maxSumBranch, int runningMaxSumBranch) {
			this.maxSumBranch = maxSumBranch;
			this.runningMaxSumBranch = runningMaxSumBranch;
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
