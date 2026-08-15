# 0739. Daily Temperatures

![Medium](https://img.shields.io/badge/Difficulty-Medium-yellow)

**Problem:** [https://leetcode.com/problems/daily-temperatures/](https://leetcode.com/problems/daily-temperatures/)

**Difficulty:** Medium  
**Tags:** `Array` · `Stack` · `Monotonic Stack`  
**Language:** java  
**Runtime:** 61 ms  
**Memory:** 107.9 MB  

---

## Solution

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] ans = new int[temperatures.length];

        
        Stack<Integer>stack = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int id = stack.pop();
                ans[id] = i-id;
            }
            stack.push(i);
        }
        return ans;
    }
}
```

---

*Auto-committed by [uCode](https://github.com/topics/ucode) on December 31, 2025*
