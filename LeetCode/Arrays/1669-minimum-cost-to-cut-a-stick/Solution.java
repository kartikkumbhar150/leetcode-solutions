import java.util.*;

class Solution {
    public int minCost(int n, int[] cuts) {

        int m = cuts.length;

        // Add 0 and n
        int[] arr = new int[m + 2];

        arr[0] = 0;
        arr[m + 1] = n;

        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }

        // Sort cuts
        Arrays.sort(arr);

        // dp[i][j] = minimum cost to make all cuts
        // between arr[i] and arr[j]
        int[][] dp = new int[m + 2][m + 2];

        // Length of interval
        for (int len = 2; len < m + 2; len++) {

            for (int i = 0; i + len < m + 2; i++) {

                int j = i + len;

                dp[i][j] = Integer.MAX_VALUE;

                // Try every possible first cut
                for (int k = i + 1; k < j; k++) {

                    int cost = arr[j] - arr[i]
                             + dp[i][k]
                             + dp[k][j];

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][m + 1];
    }
}