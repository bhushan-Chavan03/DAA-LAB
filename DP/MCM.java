import java.util.*;

class MCM {
    static int f(int arr[], int i, int j, int[][] dp) {
        if (i == j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int mini = Integer.MAX_VALUE;

        for (int k = i; k < j ; k++) {
            int ans = arr[i - 1] * arr[k] * arr[j] + f(arr, i, k, dp) + f(arr, k + 1, j, dp) ;
            mini = Math.min(mini, ans);
        }
        return mini;
    }

    static int matrixMultiplication(int[] arr, int N) {

        int dp[][] = new int[N][N];

        for (int row[] : dp)
            Arrays.fill(row, -1);

        int i = 1;
        int j = N - 1;

        return f(arr, i, j, dp);

    }

    public static void main(String args[]) {
        int arr[] = { 10, 20, 30, 40, 50 };
        int n = arr.length;
        System.out.println("The minimum number of operations are " + matrixMultiplication(arr, n));
    }
}