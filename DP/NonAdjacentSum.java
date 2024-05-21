
import java.util.*;

public class NonAdjacentSum {
    static int solveUtil(int ind, int[] arr, int[] dp) {
        if (ind < 0) return 0;
        if (ind == 0) return arr[ind];
        if (dp[ind] != -1) return dp[ind];
        
        int pick = arr[ind] + solveUtil(ind - 2, arr, dp);
        int nonPick = solveUtil(ind - 1, arr, dp);
        
        return dp[ind] = Math.max(pick, nonPick);
    }

    

    public static void main(String args[]) {
        int arr[] = {2, 1, 4, 9};
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        // int result = solveUtil(n - 1, arr, dp);
        int result=0;
        dp[0]=arr[0];
        for(int i=1;i<n;i++){
            int pick=Integer.MIN_VALUE;
            if(i>1)pick=arr[i]+dp[i-2];
            int notTake=dp[i-1];

            dp[i]=Math.max(pick,notTake);


        }

        System.out.println(dp[dp.length-1]);
    }
}

