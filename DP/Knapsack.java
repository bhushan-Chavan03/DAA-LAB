
import java.util.*;

class Knapsack {
    

    /////////////Memoization////////////
    static int knapsackMemo(int[] wt, int[] val, int ind, int W, int[][] dp) {
       
        if (ind < 0) {
            return 0;
            } 
       
        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }

        int notTaken = 0 + knapsackMemo(wt, val, ind - 1, W, dp);

        int taken = Integer.MIN_VALUE;
        if (wt[ind] <= W) {
            taken = val[ind] + knapsackMemo(wt, val, ind - 1, W - wt[ind], dp);
        }

    
        return  dp[ind][W] = Math.max(notTaken, taken);
    }

   //////////////Tabulation////////////////
   static int knapsackTab(int[] wt, int[] val, int n, int W) {
    int dp[][] = new int[n][W + 1];
    
    for (int i = wt[0]; i <= W; i++) {
        dp[0][i] = val[0];
    }
    
    for (int ind = 1; ind < n; ind++) {
        for (int cap = 0; cap <= W; cap++) {
            int notTaken = dp[ind - 1][cap];
            
            int taken = Integer.MIN_VALUE;
            if (wt[ind] <= cap) {
                taken = val[ind] + dp[ind - 1][cap - wt[ind]];
            }
            
            dp[ind][cap] = Math.max(notTaken, taken);
        }
    }
    
   
    return dp[n - 1][W];
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

        
        System.out.println("The Maximum value of items the thief can steal is " + knapsackMemo(wt, val, n - 1, W, dp));
    }
}

