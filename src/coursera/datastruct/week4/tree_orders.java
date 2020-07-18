package coursera.datastruct.week4;

import java.util.*;
import java.io.*;

public class tree_orders {
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

	public class TreeOrders {
		int n;
		int[] key, left, right;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) { 
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
		}

		List<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
            Stack<Integer> nodes = new Stack<>();
            nodes.push(0);
            int current = getLeftChild(0);
            while(current > 0 || !nodes.isEmpty()) {
            	while(current > 0) {
                	nodes.push(current);
                	current = getLeftChild(current);
                }
                current = nodes.pop();
                result.add(key[current]);
                current = getRightChild(current);
            }
			return result;
		}

		List<Integer> preOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			Stack<Integer> nodes = new Stack<>();
            nodes.push(0);
            while (!nodes.isEmpty()) {
            	int i = nodes.pop();
            	result.add(key[i]);
            	if(getRightChild(i) > 0)
            		nodes.push(getRightChild(i));
            	if(getLeftChild(i) > 0)
            		nodes.push(getLeftChild(i));
            }
			return result;
		}

		List<Integer> postOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			Set<Integer> visited = new HashSet<>();
			Stack<Integer> nodes = new Stack<>();
			nodes.add(0);
            while(!nodes.isEmpty()) {
            	boolean removeNode = true;
            	int i = nodes.peek();
            	if(getRightChild(i) > 0 && !visited.contains(getRightChild(i))) {
            		nodes.push(getRightChild(i));
            		removeNode = false;
            	}
            	if(getLeftChild(i) > 0 && !visited.contains(getLeftChild(i))) {
            		nodes.push(getLeftChild(i));
            		removeNode = false;
            	}
            	if(removeNode) {
            		int leaf = nodes.pop();
            		result.add(key[leaf]);
            		visited.add(leaf);
            	}
            }
			return result;
		}
		
		int getLeftChild(int node) {
			return left[node];
		}
		
		int getRightChild(int node) {
			return right[node];
		}
		
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
