package coursera.datastruct.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
    private int[] data;
    private List<Swap> swaps;
    int size;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        size = in.nextInt();
        data = new int[size];
        for (int i = 0; i < size; ++i) {
          data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
          out.println(swap.index1 + " " + swap.index2);
        }
    }

    private void generateSwaps() {
      swaps = new ArrayList<Swap>();
      // The following naive implementation just sorts 
      // the given sequence using selection sort algorithm
      // and saves the resulting sequence of swaps.
      // This turns the given array into a heap, 
      // but in the worst case gives a quadratic number of swaps.
      //
      // TODO: replace by a more efficient implementation
      /*for (int i = 0; i < data.length; ++i) {
        for (int j = i + 1; j < data.length; ++j) {
          if (data[i] > data[j]) {
            swaps.add(new Swap(i, j));
            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
          }
        }
      }*/
      
      //construct heap
      for(int i = size/2; i >= 0; i--)
    	  siftDown(i); 
    }
    
    private void siftDown(int index) {
    	int maxindex = index;
    	int leftchild = leftChild(index);
    	int rightChild = rightChild(index);
    	boolean left = false;
    	boolean right = false;
    	if(leftchild > 0 && leftchild < size && data[leftchild] < data[maxindex])
    		left = true;
    	if(rightChild > 0 && rightChild < size && data[rightChild] < data[maxindex])
    		right = true;
    	if(left == true && right == true) {
    		maxindex = data[leftchild] < data[rightChild] ? leftchild : rightChild;
    	} else if(left == true && right == false) {
    		maxindex = leftchild;
    	} else if(left == false && right == true) {
    		maxindex = rightChild;
    	}
    	if(maxindex != index) {
    		swaps.add(new Swap(index, maxindex));
    		swap(index, maxindex);
    		siftDown(maxindex);
    	}
    }
    
    private int leftChild(int index) {
    	int left = 2 * index + 1;
    	return left < size ? left : -1;
    }
    
    private int rightChild(int index) {
    	int right = 2 * index + 2;
    	return right < size ? right : -1;
    }
    
    private void swap(int a, int b) {
    	int temp = data[a];
    	data[a] = data[b];
    	data[b] = temp;
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
