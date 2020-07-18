package com.keshav.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DotProduct {


	private static long maxDotProduct2(int[] a, int[] b) {
		long result = 0;
		List<Integer> aDone = new ArrayList<>();
		List<Integer> bDone = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			int maxa = findMax(a);
			int maxb = findMax(b);
			if(!aDone.contains(maxa) && !bDone.contains(maxb)) {
				result += maxa * maxb;
				aDone.add(maxa);
				bDone.add(maxb);
			}
		}
		return result;
	}
	
	private static long maxDotProduct(int[] a, int[] b) {
		long result = 0;
		Arrays.sort(a);
		Arrays.sort(b);
		for(int i = 0; i < a.length; i++) {
			result += (long)a[i] * (long)b[i];
		}
		return result;
	}
	
	private static int findMax(int[] arr) {
		int max = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > arr[max])
				max = i;
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = scanner.nextInt();
		}
		System.out.println(maxDotProduct(a, b));
	}
}
