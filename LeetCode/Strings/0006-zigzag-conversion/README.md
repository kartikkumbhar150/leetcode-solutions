# 0006. Zigzag Conversion

![Medium](https://img.shields.io/badge/Difficulty-Medium-yellow)

**Problem:** [https://leetcode.com/problems/zigzag-conversion/](https://leetcode.com/problems/zigzag-conversion/)

**Difficulty:** Medium  
**Tags:** `String`  
**Language:** java  
**Runtime:** 4 ms  
**Memory:** 46.8 MB  

---

## Solution

```java
class Solution {
    public String convert(String s, int numRows) {
        StringBuilder [] rows = new StringBuilder[numRows];

        if(numRows == 1 || numRows >= s.length()){
            return s;
        }

        for(int i = 0; i< numRows ;i++){
            rows[i] = new StringBuilder();
        }
        int currentRow = 0;
        boolean goingDown = false;

        for(char c : s.toCharArray()){
            rows[currentRow].append(c);

            if(currentRow == 0 || currentRow == numRows-1){
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1:-1;
        }
        StringBuilder result = new StringBuilder();

        for(StringBuilder row : rows){
            result.append(row);
        }
        return result.toString();
    }
}
```

---

*Auto-committed by [uCode](https://github.com/topics/ucode) on August 25, 2026*
