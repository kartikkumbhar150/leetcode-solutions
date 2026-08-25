# 4080. Smallest Missing Multiple of K

![Easy](https://img.shields.io/badge/Difficulty-Easy-brightgreen)

**Problem:** [https://leetcode.com/problems/smallest-missing-multiple-of-k/](https://leetcode.com/problems/smallest-missing-multiple-of-k/)

**Difficulty:** Easy  
**Tags:** `Array` · `Hash Table`  
**Language:** java  
**Runtime:** 2 ms  
**Memory:** 45.7 MB  

---

## Solution

```java
class Solution {
    public int missingMultiple(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int multiple = k;

        while (set.contains(multiple)) {
            multiple += k;
        }

        return multiple;
    }
}
```

---

*Auto-committed by [uCode](https://github.com/topics/ucode) on August 25, 2026*
