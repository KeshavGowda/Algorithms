package com.keshav.problems;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Gridlands {

    // Complete the gridlandMetro function below.
    static BigInteger gridlandMetro(int n, int m, int k, Map<Integer, List<int[]>> tracks) {
    	long result = 0;
    	long temp = 0;
    	for(Entry<Integer, List<int[]>> entry : tracks.entrySet()) {
    		List<int[]> value = entry.getValue();
    		for(int[] sd : value) {
    			temp = sd[1] - sd[0] + 1;
        		result += temp;
    		}
    	}
    	BigInteger totalGrid = new BigInteger(Integer.toString(n)).multiply(new BigInteger(Integer.toString(m)));
    	BigInteger finalAnswer = totalGrid.subtract(new BigInteger(Long.toString(result)));
    	return finalAnswer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nmk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);
        int r, s, d;
        Map<Integer, List<int[]>> tracks = new HashMap<>();
        for (int i = 0; i < k; i++) {
            String[] trackRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            r = Integer.parseInt(trackRowItems[0])-1;
            s = Integer.parseInt(trackRowItems[1])-1;
            d = Integer.parseInt(trackRowItems[2])-1;
            if(tracks.get(r) != null) {
            	if((d-s) > 0) {
            		List<int[]> value = tracks.get(r);
                	for(int[] et : value) {
                		if(s < et[0]) {
                    		et[0] = s;
                    	} 
                    	else if(d > et[1]) {
                    		et[1] = d;
                    	} 
                	}
            	} else {
            		boolean included = false;
            		List<int[]> exst = tracks.get(r);
            		for(int[] track : exst) {
            			if(d >= track[0] && d <= track[1]) {
            				included = true;
            			}
            		}
            		if(!included) {
            			exst.add(new int[] {s, d});
                		tracks.put(r, exst);
            		}
            	}	
            } else {
            	List<int[]> value = new ArrayList<>();
            	value.add(new int[] {s, d});
            	tracks.put(r, value);
            }
   
        }
        BigInteger result = gridlandMetro(n, m, k, tracks);
        scanner.close();
        System.out.println(result);
    }
 
}
