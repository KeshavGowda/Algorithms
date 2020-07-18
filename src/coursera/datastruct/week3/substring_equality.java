package coursera.datastruct.week3;

import java.util.*;
import java.io.*;

public class substring_equality {
	static int m1 = 1_000_000_007;
	static int m2 = 1_000_000_009;
	static int x = 31;
	
	private long[] h1;
	private long[] h2;
	
	private void computeHashValues(String s) {
		for(int i = 1; i < s.length(); i++) { 
			h1[i] = ((x * h1[i - 1]) + s.charAt(i)) % m1;
			h2[i] = ((x * h2[i - 1]) + s.charAt(i)) % m2;
		}
	}

	public boolean ask(int a, int b, int l) {
		long hashA = h1[a + l - 1] - ((x ^ l) * h1[a]);
		long hashB = h1[b + l - 1] - ((x ^ l) * h1[b]);
		if(hashA % m1 == hashB % m1)
			return true;
		return false;
	}
	
	public void run() throws IOException {
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		String s = in.next();
		h1 = new long[s.length()];
		h2 = new long[s.length()];
		computeHashValues(s);
		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int l = in.nextInt();
			out.println(ask(a, b, l) ? "Yes" : "No");
		}
		out.close();
	}

	static public void main(String[] args) throws IOException {
	    new substring_equality().run();
	}

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
}
