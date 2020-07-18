package com.keshav.algo;

import java.util.Random;

public class Fibonacci {
	
	public static int fibonacciRec(int n) {
		if(n <= 1) return n;
		else return fibonacciRec(n-1) + fibonacciRec(n-2);
	}
	
	public static int fibonacciFast(int n) {
		int[] fibSeries = new int[n];
		fibSeries[0] = 0;
		fibSeries[1] = 1;
		for(int i=2; i<n ; i++) {
			fibSeries[i] = fibSeries[i-1] + fibSeries[i-2];
		}
		return fibSeries[n-1];
	}
	
	private static long getFibonacciHuge(long n, long m) {
		if(n <= 1) 
			return n;
		long n1 = n % piscano(m);
		long prev = 0;
		long curr = 1;
		long res = n1;
		for(long i=2; i<=n1; i++) {
			res = (prev + curr) % m;
			prev = curr;
			curr = res;
		}
		return res;
	}
	
	private static long piscano(long m) {
		long prev = 0;
		long curr = 1;
		long pisc = 0;
		for(long i=2; i<= m*m; i++) {
			long temp_prev = prev;
			prev = curr;
			curr = (temp_prev + curr) % m;
			if(curr == 0) {
				long curr2 = (prev + curr) % m;
				if(curr2 == 1) {
					pisc = i;
					break;
				} else {
					continue;
				}
			}
		}
		return pisc;
	}
	
	private static long calcSumLastSquare(long n) {
		long n1 = n % 60;
		if(n <= 1 || n1 <= 1) 
			return n % 10;
		long prev = 0;
		long curr = 1;
		long res = 0;
		for(long i=2; i<=n1; i++) {
			long temp_prev = prev;
			prev = curr;
			curr = (temp_prev + curr) % 10;
			res = (res + (curr * curr)) % 10;
		}
		return res + 1;
	}
	
	public static void main(String[] args) {
		/*int n = 5;
		long start = System.nanoTime();
		System.out.println(fibonacciRec(n-1));
		System.out.println("rec-> " + (System.nanoTime() - start) + " ns");
		long start2 = System.nanoTime();
		System.out.println(fibonacciFast(n));
		System.out.println("fast-> " + (System.nanoTime() - start2) + " ns");
		Random random = new Random();*/
		//System.out.println(piscano(100, 4));
		//System.out.println(getFibonacciHuge(2816213588l, 239));
		//System.out.println(calcSumLastSquare(240));
		System.out.println(getFibonacciPartialSumFast(10, 200));
	}
	
	private static long getFibonacciPartialSumFast(long from, long to) {
		int previous = 0;
		int current = 1;
		long res = 0;
		long n1 = from % 60;
		if(n1 == 0)
			res += current;
		long n2 = to % 60;
		for(long i=2; i<=n2 ; i++) {
			int temp_previous = previous;
			previous = current;
			current = (temp_previous + current) % 10;
			if(i >= n1) {
				res = (res + current) % 10;
			}
		}
		return res;
	}

}
