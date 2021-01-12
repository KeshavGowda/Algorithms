package com.algoexpert.trees.binarytrees;

public class BinaryTreeDiameter {

	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}
	
	private int maxLength = 0;

	public int binaryTreeDiameter(BinaryTree tree) {
		findMaxPathLength(tree);
		return maxLength;
	}
	
	public int findMaxPathLength(BinaryTree tree) {
		if (tree == null)
			return 0;
		int leftLength = 0;
		int rightLength = 0;
		if (tree.left != null)
			leftLength = findMaxPathLength(tree.left) + 1;
		if (tree.right != null)
			rightLength = findMaxPathLength(tree.right) + 1;
		if (leftLength + rightLength > maxLength)
			maxLength = leftLength + rightLength;
		return Math.max(leftLength, rightLength);
	}

	public static void main(String[] args) {
		BinaryTree one = new BinaryTree(1);
		BinaryTree three = new BinaryTree(3);
		BinaryTree five = new BinaryTree(5);
		one.left = three;
		one.right = five;
		System.out.println(new BinaryTreeDiameter().binaryTreeDiameter(one));
	}

}
