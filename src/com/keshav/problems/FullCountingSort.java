package com.keshav.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class FullCountingSort {
	
	static void countSort(Map<Integer, List<String>> input) {
		for(Entry<Integer, List<String>> entry : input.entrySet()) {
			System.out.print(entry.getValue().toString().replaceAll(",|]|\\[", "")+" ");
		}		
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Map<Integer, List<String>> input = new TreeMap<>();
        String[] data;
        
        for(int i=0; i<n; i++) {
        	data = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        	int key = Integer.parseInt(data[0]);
        	if(input.containsKey(key)) {
        		if(i<n/2) input.get(key).add("-");
        		else input.get(key).add(data[1]);
        	} else {
        		List<String> values = new ArrayList<>();
        		if(i<n/2)  values.add("-");
        		else values.add(data[1]);
        		input.put(key, values);
        	}
        }

        countSort(input);

        bufferedReader.close();
    }

}
