# 1685. Stone Game V

![Hard](https://img.shields.io/badge/Difficulty-Hard-red)

**Problem:** [https://leetcode.com/problems/stone-game-v/](https://leetcode.com/problems/stone-game-v/)

**Difficulty:** Hard  
**Tags:** `Array` · `Math` · `Dynamic Programming` · `Game Theory`  
**Language:** java  
**Runtime:** 352 ms  
**Memory:** 47.8 MB  

---

## Solution

```java
class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        // Prefix sum
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        // dp[l][r] = maximum score Alice can get from l to r
        int[][] dp = new int[n][n];

        // Length of current subarray
        for (int len = 2; len <= n; len++) {

            for (int l = 0; l + len <= n; l++) {
                int r = l + len - 1;

                // Try every possible split
                for (int k = l; k < r; k++) {

                    int leftSum = prefix[k + 1] - prefix[l];
                    int rightSum = prefix[r + 1] - prefix[k + 1];

                    if (leftSum < rightSum) {
                        // Left side remains
                        dp[l][r] = Math.max(
                            dp[l][r],
                            leftSum + dp[l][k]
                        );

                    } else if (rightSum < leftSum) {
                        // Right side remains
                        dp[l][r] = Math.max(
                            dp[l][r],
                            rightSum + dp[k + 1][r]
                        );

                    } else {
                        // Equal: Alice chooses which side remains
                        dp[l][r] = Math.max(
                            dp[l][r],
                            leftSum + Math.max(
                                dp[l][k],
                                dp[k + 1][r]
                            )
                        );
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
```

---

*Auto-committed by [uCode](https://github.com/topics/ucode) on August 17, 2026*
