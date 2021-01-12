package com.algoexpert.graphs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

public class EvenNodeForest {

	// Complete the evenForest function below.
	static int evenForest(Node root) {
		List<Integer> noOfNodes = new ArrayList<>();
 		for (int i = 0; i < root.children.size(); i++) {
 			noOfNodes.add(getNoOfNodesinBranch(root.children.get(i)));
		}
 		int count = 0;
 		boolean excludeRoot = false;
 		for (int no : noOfNodes) {
 			if (no % 2 == 0) {
 				count++;
 			} else {
 				if (excludeRoot) {
 					count++;
 				} else {
 					excludeRoot = true;
 					continue;
 				}
 			}
 		}
 		return count;
	}
	
	private static int getNoOfNodesinBranch(Node node) {
		int count = 0;
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		while(!stack.isEmpty()) {
			Node cur = stack.pop();
			for (int i = 0; i < cur.children.size(); i++) {
				stack.push(cur.children.get(i));
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int tNodes = Integer.parseInt(tNodesEdges[0]);
		int tEdges = Integer.parseInt(tNodesEdges[1]);

		Map<Integer, Node> tree = new HashMap<>();
		IntStream.range(0, tEdges).forEach(i -> {
			try {
				String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
				int from = Integer.parseInt(tFromTo[0]);
				int to = Integer.parseInt(tFromTo[1]);
				
				if ( ! tree.containsKey(from)) {
					Node node  = new Node(from);
					tree.put(from, node);
				}
				if ( ! tree.containsKey(to)) {
					Node node  = new Node(to);
					tree.put(to, node);
				}
				Node fromNode = tree.get(from);
				Node toNode = tree.get(to);
				toNode.children.add(fromNode);
				
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});
		Node root = tree.get(1);
		int res = evenForest(root);

		System.out.println(res);

		bufferedReader.close();
	}
	
	static class Node {
		int value;
		List<Node> children = new ArrayList<>();
		public Node (int value) {
			this.value = value;
		}
		@Override
		public String toString() {
			return Integer.toString(value);
		}
	}

}
