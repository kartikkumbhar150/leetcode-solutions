# 2002. Stone Game VIII

![Hard](https://img.shields.io/badge/Difficulty-Hard-red)

**Problem:** [https://leetcode.com/problems/stone-game-viii/](https://leetcode.com/problems/stone-game-viii/)

**Difficulty:** Hard  
**Tags:** `Array` · `Math` · `Dynamic Programming` · `Minimax` · `Prefix Sum` · `Game Theory` · `Zero-Sum Game`  
**Language:** java  
**Runtime:** 4 ms  
**Memory:** 92.1 MB  

---

## Solution

```java
class Solution {
    public int stoneGameVIII(int[] stones) {

        int n = stones.length;

        int[] prefix = new int[n];

        prefix[0] = stones[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        // Alice must take at least 2 stones
        int best = prefix[n - 1];

        for (int i = n - 2; i >= 1; i--) {
            best = Math.max(best, prefix[i] - best);
        }

        return best;
    }
}
```

---

*Auto-committed by [uCode](https://github.com/topics/ucode) on August 24, 2026*
