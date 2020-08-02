package com.algoexpert.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
	
	public static void main(String[] args) {
		Node a = new Node("A");
		a.addChild("B"); a.addChild("C"); a.addChild("D");
		System.out.println(a.depthFirstSearch(new ArrayList<>()));
	}

	static class Node {
		String name;
		List<Node> children = new ArrayList<Node>();

		public Node(String name) {
			this.name = name;
		}

		public List<String> depthFirstSearch(List<String> array) {
			Stack<Node> tobeVisited = new Stack<>();
			array.add(this.name);
			addChildrenToStack(tobeVisited, this);
			while (!tobeVisited.empty()) {
				Node current = tobeVisited.pop();
				array.add(current.name);
				addChildrenToStack(tobeVisited, current);
			}
			return array;
		}

		public Node addChild(String name) {
			Node child = new Node(name);
			children.add(child);
			return this;
		}
		
		private void addChildrenToStack(Stack<Node> tobeVisited, Node node) {
			for (int i = node.children.size() - 1; i >= 0; i--) {
				tobeVisited.add(node.children.get(i));
			}
		}
	}

}
