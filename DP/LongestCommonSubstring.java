public class LongestCommonSubstring {

    
    public static String longestCommonSubstring(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

       
        int[][] dp = new int[n + 1][m + 1];
        int maxLength = 0;
        int endIndex = -1; 

        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

       
        if (maxLength == 0) {
            return "";
        }

       
        return str1.substring(endIndex - maxLength, endIndex);
    }

    public static void main(String[] args) {
        String str1 = "abcdxyz";
        String str2 = "xyzabcd";

        String result = longestCommonSubstring(str1, str2);
        if (!result.isEmpty()) {
            System.out.println("Longest common substring: " + result);
        } else {
            System.out.println("No common substring found.");
        }
    }
}
