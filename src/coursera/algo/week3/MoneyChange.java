package coursera.algo.week3;

public class MoneyChange {
	
	private static int getChange(int m) {
        int coins = 0;
        int remaining = m;
        while(remaining > 0) {
        	while(remaining >= 8) {
        		coins++;
        		remaining -= 10;
        	}
        	while(remaining >= 4) {
        		coins++;
        		remaining -= 5;
        	}
        	while(remaining >= 2) {
        		coins++;
        		remaining -= 1;
        	}
        }
        return coins;
    }
	
	public static void main(String[] args) {
		System.out.println(getChange(997));
	}

}
