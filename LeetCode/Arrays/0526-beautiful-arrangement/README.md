# 0526. Beautiful Arrangement

![Medium](https://img.shields.io/badge/Difficulty-Medium-yellow)

**Problem:** [https://leetcode.com/problems/beautiful-arrangement/](https://leetcode.com/problems/beautiful-arrangement/)

**Difficulty:** Medium  
**Tags:** `Array` · `Dynamic Programming` · `Backtracking` · `Bit Manipulation` · `Bitmask`  
**Language:** java  
**Runtime:** 35 ms  
**Memory:** 42 MB  

---

## Solution

```java
class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean [] used = new boolean[n+1];
        backtrack(1,n,used);
        return count;

    }
    public void backtrack(int pos, int n, boolean [] used){
        if(pos > n){
            count++;
            return;
        }
        for(int num = 1; num <= n; num++){
            if(!used[num] && (num % pos == 0 || pos % num == 0)){
                used[num] = true;
                backtrack(pos+1, n,used);
                used[num] = false;
            }
        }
    }
}
```

---

*Auto-committed by [LeetSync](https://github.com/topics/leetsync) on July 20, 2026*
