package coursera.algo.week5;

import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int money) {
        int[] coin = {1, 3, 4};
        int[] minNumCoins = new int[money + 1];
        for(int m = 1; m <= money; m++) {
        	minNumCoins[m] = Integer.MAX_VALUE;
        	for(int i = 0; i < coin.length; i++) {
        		if(m >= coin[i]) {
        			int numCoins = minNumCoins[m - coin[i]] + 1;
	        		if(numCoins < minNumCoins[m]) 
	        			minNumCoins[m] = numCoins;	
        		}
        	}
        }
        return minNumCoins[money];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}

