package coursera.algo.week5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kebn
 * Fibonacci using Dynamic Progamming
 */
public class Fibonacci {
	
	private static Map<Integer, Integer> fibSeries = new HashMap<>();
	
	private static int fibonacci(int n) {
		if(fibSeries.get(n) == null) {
			if(n <= 1)
				return n;
			else {
				int s = fibonacci(n - 1) + fibonacci(n - 2);
				fibSeries.put(n, s);
			}
		}
		return fibSeries.get(n);
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacci(10));
	}

}
