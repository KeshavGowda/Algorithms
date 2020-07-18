package com.keshav.algo;

import java.util.*;

public class Inversions {
	
	private static int noOfInv = 0;

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);
        //write your code here
        return numberOfInversions;
    }
    
    public static int[] mergeSort(int[] a, int left, int right) {
    	if(left == right)
    		return new int[] {a[left]};
    	int mid = (left + right) / 2;
    	int[] b = mergeSort(a, left, mid);
    	int[] c = mergeSort(a, mid + 1, right);
    	int[] as = merge(b, c, mid);	
    	/*noOfInv = as[as.length - 1];
    	as[as.length - 1] = noOfInv;*/
    	return as;
    }
    
    public static int[] merge(int[] b, int[] c, int mid) {
    	//int noOfInv = 0;
    	int[] d = new int[b.length + c.length];
    	int bi = 0, ci = 0, di = 0;
    	while(bi < b.length && ci < c.length) {
    		int be = b[bi];
    		int ce = c[ci];
    		if(be <= ce) {
    			d[di] = be;
    			di++;
    			bi++;
    		} else {
    			d[di] = ce;
    			di++;
    			if(bi <= mid + ci) {
    				noOfInv += b.length - bi;
    			}
    			ci++;
    		}
    	}
    	//d[d.length - 1] = noOfInv;
    	for(; bi < b.length; bi++, di++)
    		d[di] = b[bi] ;
    	for(; ci < c.length; ci++, di++)
    		d[di] = c[ci];
    	//System.out.println(noOfInv);
    	return d;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();
        int[] b = mergeSort(a, 0, a.length - 1);
        System.out.println(noOfInv);
    }
}

