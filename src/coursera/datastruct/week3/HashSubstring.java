package coursera.datastruct.week3;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {

    private static FastScanner in;
    private static PrintWriter out;
    static int prime = 1000000007;
    static int multiplier = 31;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        printOccurrences(rabinKarp(readInput()));
        out.close();
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurrences(List<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }

    private static List<Integer> getOccurrences(Data input) {
    	String s = input.pattern, t = input.text;
    	int m = s.length(), n = t.length();
    	List<Integer> occurrences = new ArrayList<Integer>();
    	for (int i = 0; i + m <= n; ++i) {
    		boolean equal = true;
    		for (int j = 0; j < m; ++j) {
    			if (s.charAt(j) != t.charAt(i + j)) {
    				equal = false;
    				break;
    			}
    		}
    		if (equal)
    			occurrences.add(i);
    	}
    	return occurrences;
    }
    
    private static List<Integer> rabinKarp(Data input) {
    	List<Integer> result = new ArrayList<>();
    	long pHash = polyHash(input.pattern);
    	long[] hashes = preComputeHashes(input.text, input.pattern.length());
    	for(int i = 0; i <= input.text.length() - input.pattern.length(); i++) {
    		if(pHash != hashes[i]) 
    			continue;
    		if(input.pattern.equals(input.text.substring(i, i + input.pattern.length())))
    			result.add(i);
    	}
    	return result;
    }
    
    private static long[] preComputeHashes(String text, int patternLength) {
    	long[] hashes = new long[text.length() - patternLength + 1];
    	String lastSub = text.substring(text.length() - patternLength);
    	hashes[text.length() - patternLength] = polyHash(lastSub);
    	long y = 1;
    	for(int i = 0; i < patternLength; i++)
    		y = (y * multiplier) % prime;
    	for(int i = text.length() - patternLength - 1; i >= 0; i--) {
    		long a = (multiplier * hashes[i + 1]) + text.charAt(i) - (y * text.charAt(i + patternLength));
    		hashes[i] = ((a % prime) + prime) % prime;
    	}
    	return hashes;
    }
    
    private static long polyHash(String s) {
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; i--)
            hash = (hash * multiplier + s.charAt(i)) % prime;
        return hash;
    }

    static class Data {
        String pattern;
        String text;
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
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

