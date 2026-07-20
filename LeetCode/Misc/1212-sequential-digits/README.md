# 1212. Sequential Digits

![Medium](https://img.shields.io/badge/Difficulty-Medium-yellow)

**Problem:** [https://leetcode.com/problems/sequential-digits/](https://leetcode.com/problems/sequential-digits/)

**Difficulty:** Medium  
**Tags:** `Enumeration`  
**Language:** java  
**Runtime:** 0 ms  
**Memory:** 42.4 MB  

---

## Solution

```java
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= 9; i++){
            int num = i;
            for(int j = i+1; j <= 9; j++){
                num = num*10 + j;

                if(num >= low && num <= high){
                    list.add(num);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}
```

---

*Auto-committed by [LeetSync](https://github.com/topics/leetsync) on July 21, 2026*
