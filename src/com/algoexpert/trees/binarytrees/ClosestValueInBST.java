package com.algoexpert.trees.binarytrees;

public class ClosestValueInBST {

	public static int findClosestValueInBst(BST tree, int target) {
		int diff = Integer.MAX_VALUE;
		int val = -1;
		BST node = tree;
		while (node != null) {
			if (Math.abs(target - node.value) < diff) {
				diff = Math.abs(target - node.value);
				val = node.value;
			} 
			if (target < node.value) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return val;
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}
	}

}
