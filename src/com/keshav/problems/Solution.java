package com.keshav.problems;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String encrypt(String s) {
    	String str = s.replaceAll("\\s", "");
     	int length = str.length();
    	int row = new Double(Math.floor(Math.sqrt(length))).intValue();
    	int column = new Double(Math.ceil(Math.sqrt(length))).intValue();
    	int j = 0, k=0;
    	String finalAnswer = "";
    	String[] res = new String[column];
    	boolean eos = false;
    	while(!eos) {
    		k = j+column;
    		if (k > str.length()) {
    			k = str.length();
    			eos = true;
    		}
    		String tmp = str.substring(j, k);
    		for(int z=0; z<tmp.length(); z++) {
    			if(res[z] != null) {
    				res[z] += tmp.substring(z, z+1);
    			}
    			else {
    				res[z] = tmp.substring(z, z+1);
    			}
    		}
    		j = k;
    	}
    	for(int z=0; z<res.length; z++) {
    		finalAnswer += res[z]+" ";
    	}
    	return finalAnswer.trim();
    }
    
    private static final Scanner scan = new Scanner(System.in);
    
    public static void regex() {
    	String data = "DELOITTE/r3ad0nly@da_tstz";
    	String regex = "\\w+/\\w+@\\w+";
    	if(data.matches(regex)) {
    		String s = data.substring(0, data.lastIndexOf("@"));
    		String[] arr = s.split("/");
    		System.out.println(arr[0].trim());
    		System.out.println(arr[1].trim());
    	}
    }
    
    public static void wrap(int lrecl) {
		String text = "Metallica is an American heavy metal band. The band was formed in 1981 in Los Angeles, California by drummer Lars Ulrich and vocalist/guitarist James Hetfield, and has been based in San Francisco, California for most of its career.[1][2] The group's fast tempos, instrumentals and aggressive musicianship made them one of the founding \"big four\" bands of thrash metal, alongside Megadeth, Anthrax and Slayer. Metallica's current lineup comprises founding members Hetfield and Ulrich, longtime lead guitarist Kirk Hammett and bassist Robert Trujillo. Guitarist Dave Mustaine (who went on to form Megadeth) and bassists Ron McGovney, Cliff Burton and Jason Newsted are former members of the band.";
		int start = 0, end = 0;
		String temp = "";
		boolean eos = false;
		if(text.length() <= lrecl) {
			System.out.println(text);
		}
		else {
			while(!eos) {
				end += lrecl;
				if(end > text.length()) {
					end = text.length();
					eos = true;
				}
				temp = text.substring(start, end);
				start = end;
				System.out.println(temp);
			}	
		}
    }
    
    public static void wrapSentence(int lrecl) {
		String text = "Metallica is an American heavy metal band. The band was formed in 1981 in Los Angeles, California by drummer Lars Ulrich and vocalist/guitarist James Hetfield, and has been based in San Francisco, California for most of its career.[1][2] The group's fast tempos, instrumentals and aggressive musicianship made them one of the founding \"big four\" bands of thrash metal, alongside Megadeth, Anthrax and Slayer. Metallica's current lineup comprises founding members Hetfield and Ulrich, longtime lead guitarist Kirk Hammett and bassist Robert Trujillo. Guitarist Dave Mustaine (who went on to form Megadeth) and bassists Ron McGovney, Cliff Burton and Jason Newsted are former members of the band.";
		int start = 0, end = 0;
		String temp = "";
		boolean eos = false;
		if(text.length() <= lrecl) {
			System.out.println(text);
		}
		else {
			while(!eos) {
				end += lrecl;
				if(end > text.length()) {
					end = text.length();
					
				}
				temp = text.substring(start, end);
				end = temp.lastIndexOf(" ") + start;
				temp = text.substring(start, end);
				start = end;
				System.out.println(temp);
			}	
		}
    }

    public static void main(String[] args) throws IOException {
        //String input = scan.nextLine();
        //System.out.println(encrypt(input));
    	wrap(100);
    }
}
