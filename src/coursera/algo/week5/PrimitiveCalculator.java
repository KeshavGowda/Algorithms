package coursera.algo.week5;

import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }
    
    private static List<Integer> dyn_sequence(int n) {
    	List<Integer> sequence = new ArrayList<Integer>();
    	int[] moves = new int[n + 1];
    	for(int i = 1; i < moves.length; i++) {
    		moves[i] = moves[i - 1] + 1;
    		if(i % 2 == 0) {
    			moves[i] = Math.min(moves[i], moves[i/2] + 1);
    		}
    		if(i % 3 == 0) {
    			moves[i] = Math.min(moves[i], moves[i/3] + 1);
    		}
    	}
    	int i = n;
		while (i>1) {
			sequence.add(i);
			if (moves[i-1] == moves[i]-1)
				i = i-1;
			else if (i%2 == 0 && (moves[i/2] == moves[i]-1))
				i = i/2;
			else if (i%3 == 0 && (moves[i/3] == moves[i]-1))
				i = i/3;
		}
		sequence.add(1);
		Collections.reverse(sequence);
		return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = dyn_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
        //dyn_sequence(n);
    }
}

