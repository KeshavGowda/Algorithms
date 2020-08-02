package com.algoexpert.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
	
	public static void main(String[] args) {
		Node a = new Node("A");
		Node b = new Node("B");
		b.addChild("E"); b.addChild("F");
		Node c = new Node("C");
		Node d = new Node("D");
		d.addChild("G"); b.addChild("H");
		a.children.add(b);a.children.add(c);a.children.add(d);
		System.out.println(a.breadthFirstSearch(new ArrayList<>()));
	}

	static class Node {
		String name;
		List<Node> children = new ArrayList<Node>();

		public Node(String name) {
			this.name = name;
		}

		public List<String> breadthFirstSearch(List<String> array) {
			Queue<Node> queue = new LinkedList<>();
			array.add(this.name);
			queue.addAll(this.children);
			while (!queue.isEmpty()) {
				Node currentNode = queue.poll();
				array.add(currentNode.name);
				queue.addAll(currentNode.children);
			}
			return array;
		}

		public Node addChild(String name) {
			Node child = new Node(name);
			children.add(child);
			return this;
		}
	}

}
