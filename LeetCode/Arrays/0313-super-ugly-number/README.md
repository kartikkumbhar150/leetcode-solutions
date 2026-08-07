# 0313. Super Ugly Number

![Medium](https://img.shields.io/badge/Difficulty-Medium-yellow)

**Problem:** [https://leetcode.com/problems/super-ugly-number/](https://leetcode.com/problems/super-ugly-number/)

**Difficulty:** Medium  
**Tags:** `Array` · `Math` · `Dynamic Programming`  
**Language:** java  
**Runtime:** 31 ms  
**Memory:** 43.9 MB  

---

## Solution

```java
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
    int k = primes.length;
    int[] ugly = new int[n];
    int[] idx = new int[k];
    long[] cand = new long[k];

    ugly[0] = 1;

    for (int i = 0; i < k; i++) {
        idx[i] = 0;
        cand[i] = primes[i];
    }

    for (int i = 1; i < n; i++) {
        long next = Long.MAX_VALUE;

        for (int j = 0; j < k; j++)
            next = Math.min(next, cand[j]);

        ugly[i] = (int) next;

        for (int j = 0; j < k; j++) {
            if (cand[j] == next) {
                idx[j]++;
                cand[j] = (long) primes[j] * ugly[idx[j]];
            }
        }
    }
    return ugly[n - 1];
}

}
```

---

*Auto-committed by [LeetSync](https://github.com/topics/leetsync) on July 19, 2026*
