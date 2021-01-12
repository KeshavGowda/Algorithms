package com.algoexpert.graphs;

public class YoungestCommonAncestor {

	public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne,
			AncestralTree descendantTwo) {
		if (topAncestor.name == descendantOne.name || topAncestor.name == descendantTwo.name) {
			return topAncestor;
		}
		int level1 = getNodeLevel(descendantOne);
		int level2 = getNodeLevel(descendantTwo);
		AncestralTree commonAncestor = null;
		if (level1 != level2) {
			if (level1 < level2) {
				AncestralTree nodeAtLevel = getNodeAtLevel(descendantTwo, level2, level1);
				findYoungestCommonAncestor(nodeAtLevel, descendantOne);
			} else {
				AncestralTree nodeAtLevel = getNodeAtLevel(descendantOne, level1, level2);
				findYoungestCommonAncestor(nodeAtLevel, descendantTwo);
			}
		}
		return commonAncestor;
	}
	
	private static AncestralTree findYoungestCommonAncestor(AncestralTree node1, AncestralTree node2) {
		AncestralTree ancestorNode1 = node1.ancestor;
		AncestralTree ancestorNode2 = node2.ancestor;
		boolean isFound = false;
		while (isFound) {
			if (ancestorNode1 != null && ancestorNode2 != null) {
				if (ancestorNode1.name == ancestorNode2.name) {
					break;
				} else {
					ancestorNode1 = ancestorNode1.ancestor;
					ancestorNode2 = ancestorNode2.ancestor;
				}
			}
		}
		return ancestorNode1;
	}
	
	private static AncestralTree getNodeAtLevel(AncestralTree node, int currentLevel, int targetLevel) {
		while (currentLevel > targetLevel) {
			node = node.ancestor;
			currentLevel--;
		}
		return node;
	}
	
	private static int getNodeLevel(AncestralTree node) {
		int level = 0;
		while (node.ancestor != null) {
			level++;
			node = node.ancestor;
		}
		return level;
	}

	static class AncestralTree {
		public char name;
		public AncestralTree ancestor;

		AncestralTree(char name) {
			this.name = name;
			this.ancestor = null;
		}

		// This method is for testing only.
		void addAsAncestor(AncestralTree[] descendants) {
			for (AncestralTree descendant : descendants) {
				descendant.ancestor = this;
			}
		}
	}

}
