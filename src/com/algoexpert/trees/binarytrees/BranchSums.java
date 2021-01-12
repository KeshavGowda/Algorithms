package com.algoexpert.trees.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {
	
	/** tree =    1				branch sums =
	 *			/   \           15 = 1 + 2 + 4 + 8
	 *         2     3          16 = 1 + 2 + 4 + 9
	 *        / \   / \         18 = 1 + 2 + 5 + 10
     *       4   5 6   7		.
     *      / \   \				.
     *     8   9  10			. 
     */	       
	
	public static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		BinaryTree(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	public static void main(String[] args) {
		List<Integer> sums = branchSums(test());
		System.out.println(sums);
	}
	
	public static List<Integer> branchSums(BinaryTree root) {
		List<Integer> sums = new ArrayList<>();
		if (root == null)
			return sums; 
		if (root.left == null && root.right == null) {
			sums.add(root.value); 
			return sums;
		}
		calculateSum(root, 0, sums);
		
		return sums;
	}
	
	private static void calculateSum(BinaryTree btree, int curSum, List<Integer> sums) {
		curSum += btree.value;
		if (btree.right == null && btree.left == null) {
			sums.add(curSum);
			return;
		}
		if (btree.left != null)
			calculateSum(btree.left, curSum, sums);
		if (btree.right != null)
			calculateSum(btree.right, curSum, sums);
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
