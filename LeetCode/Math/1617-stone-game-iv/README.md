# 1617. Stone Game IV

![Hard](https://img.shields.io/badge/Difficulty-Hard-red)

**Problem:** [https://leetcode.com/problems/stone-game-iv/](https://leetcode.com/problems/stone-game-iv/)

**Difficulty:** Hard  
**Tags:** `Math` · `Dynamic Programming` · `Minimax` · `Game Theory` · `Nim Game` · `Sprague–Grundy Theorem` · `Zero-Sum Game`  
**Language:** java  
**Runtime:** 14 ms  
**Memory:** 42.4 MB  

---

## Solution

```java
class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        dp[0] = false;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j * j <= i; j++) {

                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
```

---

*Auto-committed by [uCode](https://github.com/topics/ucode) on August 10, 2026*
