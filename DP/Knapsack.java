
import java.util.*;

class Knapsack {
    
    static int knapsackUtil(int[] wt, int[] val, int ind, int W, int[][] dp) {
       
        if (ind < 0) {
            return 0;
            } 
       
        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }

        int notTaken = 0 + knapsackUtil(wt, val, ind - 1, W, dp);

        int taken = Integer.MIN_VALUE;
        if (wt[ind] <= W) {
            taken = val[ind] + knapsackUtil(wt, val, ind - 1, W - wt[ind], dp);
        }

    
        return  dp[ind][W] = Math.max(notTaken, taken);
    }

   
    

    public static void main(String args[]) {
        int wt[] = {1, 2, 4, 5};
        int val[] = {5, 4, 8, 6};
        int W = 5;
        int n = wt.length;

        int dp[][] = new int[n][W + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        
        System.out.println("The Maximum value of items the thief can steal is " + knapsackUtil(wt, val, n - 1, W, dp));
    }
}

