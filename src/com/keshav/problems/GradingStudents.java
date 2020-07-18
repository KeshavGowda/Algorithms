package com.keshav.problems;

import java.io.IOException;

public class GradingStudents {

    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades) {
    	int[] finalScores = new int[grades.length];
    	for(int i=0; i<grades.length; i++) {
    		if(grades[i] < 38) {
    			finalScores[i] = grades[i];
    			continue;
    		} else {
    			int nextMultiple = findNextMultiple(grades[i]);
    			if(nextMultiple - grades[i] < 3) {
    				finalScores[i] = nextMultiple;
    			} else {
    				finalScores[i] = grades[i];
    			}
    		}
    	}
    	return finalScores;
    }
    
    private static int findNextMultiple(int number) {
    	int nextMultiple = number;
    	if(number % 5 == 0) {
    		return number;
    	} else {
    		return findNextMultiple(++nextMultiple);
    	}
    }
    
    public static int fact(int n) {
    	/*if(n == 1) {
    		return n;
    	} else {
    		return n * fact(n-1);
    	}*/
    	int factr = 1;
    	int multiplier = 1;
    	while(multiplier <= n) 
    		factr = factr * multiplier++;
    	return factr;
    }

    public static void main(String[] args) throws IOException {
    	/*int[] scores = new int[] {73, 67, 38, 33};
    	scores = gradingStudents(scores);
    	for(int score : scores) {
    		System.out.println(score);
    	}*/
    	String str = "UNLOAD FROM TABLE DB5TDBA.PCT_TRN_CLSN_BAL\r\n" + 
    			"HEADER NONE\r\n" + 
    			"(INTR_UPC_ID, LOC_NBR, TRN_CLSN_QTY)\r\n" + 
    			"WHEN (TRN_CLSN_CDE = 'SE' AND TRN_CLSN_QTY <> 0)\r\n" + 
    			"NOPAD\r\n" + 
    			"SHRLEVEL CHANGE ISOLATION UR";
    	String sub = null;
    	String col;
    	String query = "select ";
    	if(str.contains("WHEN")) {
    		String[] array = str.split("WHEN");
    		sub = array[0];
    		sub = sub.substring(sub.indexOf("(")+1, sub.lastIndexOf(")"));
    		String[] arr = sub.split(",");
    		for(int i = 0; i < arr.length; i++) {
        		col = arr[i].trim().split(" ")[0];
        		query += col;
        		if(i+1 != arr.length) query+=", ";
        	}
    		sub = array[1];
    		query += " FROM SCHEMA.TABLE WHERE ";
    		sub = sub.substring(sub.indexOf("(")+1, sub.lastIndexOf(")"));
    		query += sub + ";";
    		System.out.println(query);
    	}
    	
    	
    }

}
