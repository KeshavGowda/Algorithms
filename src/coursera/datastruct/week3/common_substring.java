package coursera.datastruct.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class common_substring {
	
	static int prime = 1000000007;
    static int multiplier = 31;
	
    public class Answer {
        int i, j, len;
        Answer(int i, int j, int len) {
            this.i = i;
            this.j = j;
            this.len = len;
        }
    }

    public Answer solve(String s, String t) {
        Answer ans = new Answer(0, 0, 0);
        for (int i = 0; i < s.length(); i++)
            for (int j = 0; j < t.length(); j++)
                for (int len = 0; i + len <= s.length() && j + len <= t.length(); len++)
                    if (len > ans.len && s.substring(i, i + len).equals(t.substring(j, j + len)))
                        ans = new Answer(i, j, len);
        return ans;
    }
    
    public Answer findSubstring(String s, String t) {
    	Answer ans = new Answer(0, 0, 0);
    	int length = Math.min(s.length(), t.length());
    	Map<Long, Integer> hashes_s, hashes_t;
    	while(length > 0) {
    		hashes_s = preComputeHashes(s, length);
    		hashes_t = preComputeHashes(t, length);
    		for(Entry<Long, Integer> entry : hashes_t.entrySet()) {
    			if(hashes_s.containsKey(entry.getKey())) {
    				int j = hashes_s.get(entry.getKey());
    				int k = entry.getValue();
    				if(s.substring(j, j + length).equals(t.substring(k, k + length)))
    					return new Answer(j, k, length);
    			}
    		}
    		length--;
    	}
    	return ans;
    }
    
    private static Map<Long, Integer> preComputeHashes(String text, int patternLength) {
    	Map<Long, Integer> hashValues = new HashMap<>();
    	String lastSub = text.substring(text.length() - patternLength);
    	long previousHash = polyHash(lastSub);
    	hashValues.put(previousHash, text.length() - patternLength);
    	long y = 1;
    	for(int i = 0; i < patternLength; i++)
    		y = (y * multiplier) % prime;
    	for(int i = text.length() - patternLength - 1; i >= 0; i--) {
    		long a = (multiplier * previousHash) + text.charAt(i) - (y * text.charAt(i + patternLength));
    		previousHash = ((a % prime) + prime) % prime;
    		hashValues.put(previousHash, i);
    	}
    	return hashValues;
    }

    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        in.lines().forEach(line -> {
            StringTokenizer tok = new StringTokenizer(line);
            String s = tok.nextToken();
            String t = tok.nextToken();
            Answer ans = findSubstring(s, t);
            System.out.println(ans.i + " " + ans.j + " " + ans.len);
        });
        out.close();
    }
    
    private static long polyHash(String s) {
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; i--)
            hash = (hash * multiplier + s.charAt(i)) % prime;
        return hash;
    }

    static public void main(String[] args) {
        new common_substring().run();
    }
}
