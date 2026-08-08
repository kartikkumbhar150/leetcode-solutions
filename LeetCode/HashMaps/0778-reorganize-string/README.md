# 0778. Reorganize String

![Medium](https://img.shields.io/badge/Difficulty-Medium-yellow)

**Problem:** [https://leetcode.com/problems/reorganize-string/](https://leetcode.com/problems/reorganize-string/)

**Difficulty:** Medium  
**Tags:** `Hash Table` · `String` · `Greedy` · `Sorting` · `Heap (Priority Queue)` · `Counting`  
**Language:** java  
**Runtime:** 1 ms  
**Memory:** 43.3 MB  

---

## Solution

```java
// 767. Reorganize String

class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int max = 0;
        int maxChar = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > max) {
                max = freq[i];
                maxChar = i;
            }
        }

        if (max > (s.length() + 1) / 2) {
            return "";
        }

        char[] ans = new char[s.length()];
        int index = 0;

        while (freq[maxChar] > 0) {
            ans[index] = (char) ('a' + maxChar);
            index += 2;
            freq[maxChar]--;
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }

                ans[index] = (char) ('a' + i);
                index += 2;
                freq[i]--;
            }
        }

        return new String(ans);
    }
}
```

---

*Auto-committed by [uCode](https://github.com/topics/ucode) on August 8, 2026*
