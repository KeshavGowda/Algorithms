package coursera.algo.week6;

import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
      
      return 0;
    }
    
    private static void minAndMax(int i, int j) {
    	int min = Integer.MIN_VALUE;
    	int max = Integer.MAX_VALUE;
    	for(int k = i; i <= j-1; k++) {
    		
    	}
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

