
///////////////get the length of the substring////////////////////////

import java.util.*;

class LCS {
    ///////////////////Memoization///////////////////////
    static int lcsUtil(String s1, String s2, int ind1, int ind2, int[][] dp) {
        if (ind1 < 0 || ind2 < 0)
            return 0;

        if (dp[ind1][ind2] != -1)return dp[ind1][ind2];

       
        if (s1.charAt(ind1) == s2.charAt(ind2)) return dp[ind1][ind2] = 1 + lcsUtil(s1, s2, ind1 - 1, ind2 - 1, dp);

        
        else  return dp[ind1][ind2] = Math.max(lcsUtil(s1, s2, ind1, ind2 - 1, dp),lcsUtil(s1, s2, ind1 - 1, ind2, dp));
    }

    static int lcsMemo(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n][m];

        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        return lcsUtil(s1, s2, n - 1, m - 1, dp);
    }


    ////////////////////   Tabulation///////////////////////////
    static int lcsTab(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];

        
        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

       
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
               
                else dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        return dp[n][m];
    }



    public static void main(String args[]) {
        String s1 = "acd";
        String s2 = "ced";
        System.out.println("The Length of Longest Common Subsequence is " + lcsMemo(s1, s2));


        //Tabulation
    }
}

