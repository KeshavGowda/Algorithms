package coursera.algo.week5;

import java.util.*;

class EditDistance {
	
	public static int editDistance(String s, String t) {
		int[][] d = new int[t.length() + 1][s.length() + 1];
		for(int i = 0; i <= s.length(); i++)
			d[0][i] = i;
		for(int j = 0; j <= t.length(); j++)
			d[j][0] = j;
		for(int j = 1; j <= t.length(); j++) {
			for(int i = 1; i <= s.length(); i++) {
				int insertion = d[j][i - 1] + 1;
				int deletion = d[j - 1][i] + 1;
				if(s.charAt(i - 1) == t.charAt(j - 1)) {
					int match = d[j - 1][i - 1];
					d[j][i] = Math.min(insertion, Math.min(deletion, match));
				} else {
					int mismatch = d[j - 1][i - 1] + 1;
					d[j][i] = Math.min(insertion, Math.min(deletion,mismatch));
				}
			}
		}
		return d[t.length()][s.length()];
	}
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		String s = scan.next();
		String t = scan.next();

		System.out.println(editDistance(s, t));
	}

}
