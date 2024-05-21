
import java.util.*;

class TUF {
    static int knapsackUtil(int[] wt, int[] val, int ind, int W, int[][] dp) {
        if (ind == 0) {
            return ((int) (W / wt[0])) * val[0];
        }

        if (dp[ind][W] != -1)
            return dp[ind][W];

        int notTaken = 0 + knapsackUtil(wt, val, ind - 1, W, dp);

        int taken = Integer.MIN_VALUE;

        if (wt[ind] <= W)
            taken = val[ind] + knapsackUtil(wt, val, ind, W - wt[ind], dp);

        return dp[ind][W] = Math.max(notTaken, taken);
    }

    

    public static void main(String args[]) {
        int wt[] = { 2, 4, 6 };
        int val[] = { 5, 11, 13 };
        int W = 10;

        int n = wt.length;

        
        int[][] dp = new int[n][W + 1];

        
        for (int row[] : dp)
            Arrays.fill(row, -1);

        System.out.println("The Maximum value of items, the thief can steal is " + knapsackUtil(wt, val, n - 1, W, dp));
    }
}

