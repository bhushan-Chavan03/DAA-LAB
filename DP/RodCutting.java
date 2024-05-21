import java.util.Arrays;

public class RodCutting {

    static int cutRod(int length[], int price[], int ind, int rem, int dp[][]){
        if(ind==0)return price[0]*rem;

        if(dp[ind][rem]!=-1)return dp[ind][rem];

        int notTake=cutRod(length, price, ind-1, rem,dp);
        int take=Integer.MIN_VALUE;
        if(rem>=ind+1){
            take=price[ind]+cutRod(length, price, ind, rem-(ind+1),dp);
        }
        return dp[ind][rem]=Math.max(take, notTake);

    }
    public static void main(String[] args) {
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int rodLength = 4;
        int dp[][]=new int[length.length][rodLength+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        System.out.println(cutRod(length,price,price.length-1, rodLength,dp));

    }
}