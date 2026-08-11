# 3236. Smallest Missing Integer Greater Than Sequential Prefix Sum

![Easy](https://img.shields.io/badge/Difficulty-Easy-brightgreen)

**Problem:** [https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/](https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/)

**Difficulty:** Easy  
**Tags:** `Array` · `Hash Table` · `Sorting`  
**Language:** java  
**Runtime:** 1 ms  
**Memory:** 44.1 MB  

---

## Solution

```java
class Solution {
    public int missingInteger(int[] nums) {

        int sum = nums[0];

        // Find sequential prefix sum
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Store all numbers
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // Find smallest missing integer >= sum
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}
```

---

*Auto-committed by [uCode](https://github.com/topics/ucode) on August 11, 2026*
