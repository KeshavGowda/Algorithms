package coursera.algo.week3;

public class Knapsack {
	
	private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        int a = 0;
        if(capacity == 0) {
        	return value;
        }
        double[] vw  = new double[values.length];
        for(int i = 0; i < values.length; i++) {
        	vw[i] = (double)values[i]/weights[i];	
        }
        for(int i = 0; i < values.length; i++) {
        	int maxi = findMax(vw, weights);
        	a = Math.min(weights[maxi], capacity);
        	value += a * vw[maxi];
        	weights[maxi] -= a;
        	capacity -= a;
        }
        return value;
    }
	
	private static int findMax(double[] array, int[] weights) {
		int max = 0;
		for(int i = 1; i < array.length; i++) {
			if((array[i] > array[max]) && (weights[i] != 0))
				max = i;
		}
		return max;
	}
	
	public static void main(String[] args) {
		int capacity = 10;
		int[] values = {500};
		int[] weights = {30};
		System.out.println(getOptimalValue(capacity, values, weights));
	}

}
