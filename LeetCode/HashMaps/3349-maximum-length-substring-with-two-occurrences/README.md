# 3349. Maximum Length Substring With Two Occurrences

![Easy](https://img.shields.io/badge/Difficulty-Easy-brightgreen)

**Problem:** [https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/](https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/)

**Difficulty:** Easy  
**Tags:** `Hash Table` · `String` · `Sliding Window`  
**Language:** java  
**Runtime:** 3 ms  
**Memory:** 43.6 MB  

---

## Solution

```java
class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.get(ch) > 2) {
                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);

                left++;
            }

            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}
```

---

*Auto-committed by [uCode](https://github.com/topics/ucode) on August 14, 2026*
