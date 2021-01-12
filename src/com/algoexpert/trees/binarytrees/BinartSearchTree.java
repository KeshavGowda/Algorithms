package com.algoexpert.trees.binarytrees;

public class BinartSearchTree {

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}

		public BST insert(int value) {
			BST newnode = new BST(value);
			BST node = this;
			boolean isInserted = false;
			while ( ! isInserted) {
				if (node.value > value) {
					if (node.left == null) {
						node.left = newnode;
						isInserted = true;
					}
					else 
						node = node.left;
				} else {
					if (node.right == null) {
						node.right = newnode;
						isInserted = true;
					}
					else 
						node = node.right;
				}
			}
			return this;
		}

		public boolean contains(int value) {
			BST node = this;
			while (node != null) {
				if (node.value == value) {
					return true;
				} else if (node.value > value) {
					node = node.left;
				} else {
					node = node.right;
				}
			}
			return false;
		}

		public BST remove(int value) {
			BST node = this;
			if (node.left == null && node.right == null)
				return this;
			BST toBeRemoved = null;
			BST prev = null;
			while (node != null) {
				if (node.value == value) {
					toBeRemoved = node;
					break;
				} else if (node.value > value) {
					prev = node;
					node = node.left;
				} else {
					prev = node;
					node = node.right;
				}
			}
			// if value is found in tree
			if (toBeRemoved != null) {
				//replace toBeRemoved node with left most node in right sub tree
				if (toBeRemoved.right != null) {
					BST replacement = toBeRemoved.right;
					BST prevNodeOfRepl = null;
					while (replacement.left != null) {
						prevNodeOfRepl = replacement;
						replacement = replacement.left;
					}
					toBeRemoved.value = replacement.value;
					prevNodeOfRepl.left = replacement.right;
				} else if (prev.value <= toBeRemoved.value) {
					prev.right = toBeRemoved.right;
				}
				if (prev != null) {
					prev.left = toBeRemoved.left;
				}
			}
			return this;
		}
	}
	
	public static void main(String[] args) {
		BST tree = new BST(10);
		tree.insert(5);
		tree.insert(15);
		tree.remove(5);
		tree.remove(15);
		tree.remove(10);
	}

}
