package com.algoexpert.trees.binarytrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeightBST {

	public static BST minHeightBst(List<Integer> array) {
		return buildTree(array, 0, array.size() - 1);
	}
	
	private static BST buildTree(List<Integer> array, int i, int j) {
		if (i > j)
			return null;
		else if (i == j)
			return new BST(array.get(i));
		else {
			int mid = (i + j) / 2;
			BST node = new BST(array.get(mid));
			node.left = buildTree(array, i, mid - 1);
			node.right = buildTree(array, mid + 1, j);
			return node;
		}
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
			left = null;
			right = null;
		}

		public void insert(int value) {
			if (value < this.value) {
				if (left == null) {
					left = new BST(value);
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					right = new BST(value);
				} else {
					right.insert(value);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		List<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22));
		minHeightBst(array);
	}

}
