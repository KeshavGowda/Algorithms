package com.keshav.problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.omg.CORBA.OMGVMCID;

public class StrongPassword {
	
	// Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
    	char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};
    	char[] lower_case = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    	char[] upper_case = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    	char[] special_characters = {'!','#','$','%','&','(',')','*','+','-','@','^'};
    	
    	int cs = 0;
    	boolean isNum = false, isLower = false, isUpper = false, isSpecial = false;
    	for(char ch : password.toCharArray()) {
    		if(!isNum && Arrays.binarySearch(numbers, ch) >= 0) {cs++; isNum = true; continue;}
    		if(!isLower && Arrays.binarySearch(lower_case, ch) >= 0) {cs++; isLower = true; continue;}
    		if(!isUpper && Arrays.binarySearch(upper_case, ch) >= 0) {cs++; isUpper = true; continue;}
    		if(!isSpecial && Arrays.binarySearch(special_characters, ch) >= 0) {cs++; isSpecial = true; continue;}
    		if(cs == 4) break;
    	}
    	if(n >= 6) {
    		return 4 - cs;
    	} else {
    		return n+(4-cs) >= 6 ? 4 - cs : (4-cs)+(6-(4-cs)-n);
    	} 	
    }
    
    // Complete the getMoneySpent function below.
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int max = -1;
        for(int k : keyboards) {
        	for(int d : drives) {
        		if((k + d <= b) && (k + d > max)) {
        			max = k + d;
        		}
        	}
        }
        return max;
    }
    
	public static void main(String[] args) {
		String password = "+v-kz";
		System.out.println(minimumNumber(password.length(), password));
		int b = 5;
		int[] key = {4};
		int[] dr = {5};
		System.out.println(getMoneySpent(key, dr, b));
	}

}
