class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[] suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int M = n; M >= 1; M--) {

                if (2 * M >= n - i) {
                    dp[i][M] = suffix[i];
                    continue;
                }

                for (int X = 1; X <= 2 * M; X++) {
                    dp[i][M] = Math.max(
                        dp[i][M],
                        suffix[i] - dp[i + X][Math.max(M, X)]
                    );
                }
            }
        }

        return dp[0][1];
    }
}