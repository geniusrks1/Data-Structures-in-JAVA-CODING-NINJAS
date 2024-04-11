public class Solution {

    public static int smallestSuperSequence(String str1, String str2) {
        return recursiveSS(str1, str2, str1.length(), str2.length());
    }

    private static int recursiveSS(String str1, String str2, int m, int n) {
        // Base cases
        if (m == 0) return n; // If str1 is empty, return the length of str2
        if (n == 0) return m; // If str2 is empty, return the length of str1

        // If last characters of both strings are same
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return 1 + recursiveSS(str1, str2, m - 1, n - 1);

        // If last characters are not same, return 1 plus the minimum of:
        // - Remove the last character of str1 and calculate recursively
        // - Remove the last character of str2 and calculate recursively
        return 1 + Math.min(recursiveSS(str1, str2, m - 1, n), recursiveSS(str1, str2, m, n - 1));
    }
}


// using memoization

 public static int smallestSuperSequence(String str1, String str2) {
        int[][] memo = new int[str1.length() + 1][str2.length() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return recursiveSS(str1, str2, str1.length(), str2.length(), memo);
    }

    private static int recursiveSS(String str1, String str2, int m, int n, int[][] memo) {
        // Base cases
        if (m == 0) return n; 
        if (n == 0) return m; 

        if (memo[m][n] != -1) return memo[m][n];

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return  memo[m][n] = 1 + recursiveSS(str1, str2, m - 1, n - 1, memo);
        }
        
        return  memo[m][n] = 1 + Math.min(recursiveSS(str1, str2, m - 1, n, memo), recursiveSS(str1, str2, m, n - 1, memo));
    }


// using iterative way
public class Solution {

    public static int smallestSuperSequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        // Initialization
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }

        // Fill DP array
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[len1][len2];
    }
}
