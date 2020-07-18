package com.keshav.algo;

import java.util.HashSet;
import java.util.Set;

public class TwoCharacters {
	
	// Complete the alternate function below.
    static int alternate(String s) {
    	int len = 0;
    	String alt = "";
    	Set<Character> uniqueLetters = new HashSet<>();
    	for(int i = 0; i < s.length(); i++) {
    		Character ch = s.charAt(i);
    		if( ! uniqueLetters.contains(ch)) {
    			uniqueLetters.add(ch);
    			alt = s.replaceAll(ch.toString(), "");
    			int curLen = getLongestLength(alt);
    			if(curLen > len)
    				len = curLen;
    		}
    	}
    	return len;
    }
    
    static int getLongestLength(String s) {
    	Character ch = null;
    	int len = 0;
    	if(s.length() < 2)
    		return len;
    	boolean isCorrect = false;
		for(int j = 0; j < s.length(); j+=2) {
			if(j + 1 < s.length()) {
				if(s.charAt(j) == s.charAt(j + 1) - 2) {
					isCorrect = true;
					continue;
				}
				else {
					isCorrect = false;
					ch = s.charAt(j + 1);
					break;
				}
			}
		}
		if(isCorrect == false && ch != null) {
			len = getLongestLength(s.replaceAll(ch.toString(), ""));
		} else {
			len = s.length();
		}
		return len;
    }
	
	public static void main(String[] args) {
		System.out.println(alternate("beabeefeab"));
	}

}
