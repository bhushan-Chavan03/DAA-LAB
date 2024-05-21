import java.util.*;

class SubsetSum {

    static boolean subsetSum(int ind, int target, int[] arr, int[][] dp, List<Integer> curr, List<List<Integer>> ans) {

       
        if (ind < 0) {
            if (target == 0) {
                ans.add(new ArrayList<>(curr));
                return true;
            }
            else return false;

        }

        if (dp[ind][target] != -1)
            return dp[ind][target] == 1;

        boolean notTaken = subsetSum(ind - 1, target, arr, dp, curr, ans);

        boolean taken = false;
        if (arr[ind] <= target) {
            curr.add(arr[ind]);
            taken = subsetSum(ind - 1, target - arr[ind], arr, dp, curr, ans);
            curr.remove(curr.size() - 1);
        }

        dp[ind][target] = (notTaken || taken) ? 1 : 0;
        return notTaken || taken;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int dp[][] = new int[n][k + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        if (subsetSum(n - 1, k, arr, dp, curr, ans)) {
            System.out.println("Subset with the given target found");
        } else {
            System.out.println("Subset with the given target not found");
        }

        for (List<Integer> subset : ans) {
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
