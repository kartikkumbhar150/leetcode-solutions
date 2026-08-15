# 4033. Longest Subsequence With Non-Zero Bitwise XOR

![Medium](https://img.shields.io/badge/Difficulty-Medium-yellow)

**Problem:** [https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/](https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/)

**Difficulty:** Medium  
**Tags:** `Array` · `Bit Manipulation`  
**Language:** java  
**Runtime:** 2 ms  
**Memory:** 133.3 MB  

---

## Solution

```java
class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean hasNonZero = false;

        for (int num : nums) {
            xor ^= num;

            if (num != 0) {
                hasNonZero = true;
            }
        }

        if (xor != 0) {
            return nums.length;
        }

        return hasNonZero ? nums.length - 1 : 0;
    }
}
```

---

*Auto-committed by [uCode](https://github.com/topics/ucode) on August 15, 2026*
