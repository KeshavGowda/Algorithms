package com.algoexpert.trees.binarytrees;

class ValidateBST {
	
	public static boolean validateBst(BST tree) {
		return validate(tree, tree);
	}
	
	public static boolean validate(BST tree, BST root) {
		if (tree == null || (tree.left == null && tree.right == null)) {
			return true;
		} else {
			BST left = tree.left;
			BST right = tree.right;
			if (tree.value < root.value) {
				if (left.value >= tree.value || left.value >= root.value)
					return false;
				if (right.value < tree.value || right.value >= root.value)
					return false;
			} else {
				if (left.value >= tree.value || left.value < root.value)
					return false;
				if (right.value < tree.value || right.value < root.value)
					return false;
			}
			if (left == null || tree.value > left.value) {
				if (right == null || tree.value <= right.value) {
					return validate(left, root) && validate(right, root);
				}
			}
		}
		return false;
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		BST tree = new BST(10);
		BST tree2 = new BST(5);
		tree.left = tree2;
		BST tree3 = new BST(10);
		tree2.right = tree3;
		BST tree4 = new BST(15);
		tree.right = tree4;
		System.out.println(validateBst(tree));
	}
}
