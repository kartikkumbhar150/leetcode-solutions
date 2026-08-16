# 2156. Stone Game IX

![Medium](https://img.shields.io/badge/Difficulty-Medium-yellow)

**Problem:** [https://leetcode.com/problems/stone-game-ix/](https://leetcode.com/problems/stone-game-ix/)

**Difficulty:** Medium  
**Tags:** `Array` · `Math` · `Greedy` · `Minimax` · `Counting` · `Game Theory` · `Nim Game` · `Zero-Sum Game`  
**Language:** java  
**Runtime:** 3 ms  
**Memory:** 114.6 MB  

---

## Solution

```java
class Solution {
    public boolean stoneGameIX(int[] stones) {

        int[] cnt = new int[3];

        for (int stone : stones) {
            cnt[stone % 3]++;
        }

        int zero = cnt[0];
        int one = cnt[1];
        int two = cnt[2];

        // No 1 or 2 stones -> Alice cannot avoid losing
        if (one == 0 && two == 0) {
            return false;
        }

        // Even number of 0 stones
        if (zero % 2 == 0) {
            return one > 0 && two > 0;
        }

        // Odd number of 0 stones
        return Math.abs(one - two) > 2;
    }
}
```

---

*Auto-committed by [uCode](https://github.com/topics/ucode) on August 16, 2026*
