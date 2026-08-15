# 0076. Minimum Window Substring

![Hard](https://img.shields.io/badge/Difficulty-Hard-red)

**Problem:** [https://leetcode.com/problems/minimum-window-substring/](https://leetcode.com/problems/minimum-window-substring/)

**Difficulty:** Hard  
**Tags:** `Hash Table` · `String` · `Sliding Window`  
**Language:** java  
**Runtime:** 23 ms  
**Memory:** 47.6 MB  

---

## Solution

```java
class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> map1 = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0)+1);
        }
        Map<Character, Integer> map2 = new HashMap<>();

        int left = 0;
        int start = 0;
        int have = 0;
        int max = Integer.MAX_VALUE;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map2.put(ch, map2.getOrDefault(ch,0)+1);

            if(map1.containsKey(ch) && map1.get(ch).equals(map2.get(ch))){
                have++;
            }
            while(have == map1.size()){
                if(max > i-left+1){
                    max = i-left+1;
                    start = left;
                }
                char c = s.charAt(left);
                map2.put(c, map2.getOrDefault(c,0)-1);

                if(map1.containsKey(c) && map2.get(c) < map1.get(c)){
                    have--;
                }
                left++;
            }
        }
        return max == Integer.MAX_VALUE ? "" : s.substring(start, start+max);
    }
}
```

---

*Auto-committed by [uCode](https://github.com/topics/ucode) on July 9, 2026*
