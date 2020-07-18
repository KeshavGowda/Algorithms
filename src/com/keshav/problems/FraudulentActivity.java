package com.keshav.problems;

import java.util.Arrays;
import java.util.Random;

public class FraudulentActivity {
	
	// Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
    	float[] sub = new float[d];
    	int ntf = 0;
    	int i = 0;
    	while(i+d < expenditure.length) {
    		for(int k=i; k<i+d; k++) {
    			sub[k-i] = expenditure[k];
    		}
    		Arrays.sort(sub);
    		float median = d % 2 == 0 ? (sub[(d-1)/2] + sub[d/2])/2 : sub[d/2] ;
    		if(expenditure[i+d] >= median*2) 
				ntf++;
    		i++;
    	}
    	return ntf;
    }

    public static void main(String[] args) {
    	int[] exp = {2, 3, 4, 2, 3, 6, 8, 4, 5};
    	System.out.println(activityNotifications(exp, 5));
    	Random random = new Random();
    	random.nextInt(1000);
    	System.out.println(2015%8);
    }

}
