package coursera.datastruct.week4;

import java.util.*;
import java.io.*;

public class is_bst {
	class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class IsBST {
		class Node {
			int key;
			int left;
			int right;

			Node(int key, int left, int right) {
				this.left = left;
				this.right = right;
				this.key = key;
			}
			
			@Override
			public String toString() {
				return Integer.toString(this.key);
			}
		}

		int nodes;
		Node[] tree;

		void read() throws IOException {
			FastScanner in = new FastScanner();
			nodes = in.nextInt();
			tree = new Node[nodes];
			for (int i = 0; i < nodes; i++) {
				tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
			}
		}

		boolean isBinarySearchTree() {
			//in-order traversal, if prev node is greater than curr node, return false
			if(tree.length == 0)
				return true;
			Stack<Node> nodes = new Stack<>();
			nodes.push(tree[0]);
			Node previous = null;
            Node current = getLeftChild(tree[0]);
            while(current.key != -1 || !nodes.isEmpty()) {
            	while(current.key != -1) {
                	nodes.push(current);
                	current = getLeftChild(current);
                }
                current = nodes.pop();
                if(previous == null)
                	previous = current;
                else if(previous.key > current.key)
                	return false;
                previous = current;
                current = getRightChild(current);
            }
			return true;
		}
		
		Node getLeftChild(Node node) {
			if(node.left != -1)
				return tree[node.left];
			else
				return new Node(-1, -1, -1);
		}
		
		Node getRightChild(Node node) {
			if(node.right != -1)
				return tree[node.right];
			else
				return new Node(-1, -1, -1);
		}
		
	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new is_bst().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		IsBST tree = new IsBST();
		tree.read();
		if (tree.isBinarySearchTree()) {
			System.out.println("CORRECT");
		} else {
			System.out.println("INCORRECT");
		}
	}
}
