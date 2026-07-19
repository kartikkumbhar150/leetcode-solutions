# 0005. Longest Palindromic Substring

![Medium](https://img.shields.io/badge/Difficulty-Medium-yellow)

**Problem:** [https://leetcode.com/problems/longest-palindromic-substring/](https://leetcode.com/problems/longest-palindromic-substring/)

**Difficulty:** Medium  
**Tags:** `Two Pointers` · `String` · `Dynamic Programming`  
**Language:** java  
**Runtime:** 2590 ms  
**Memory:** 47.1 MB  

---

## Solution

```java
class Solution {
    public String longestPalindrome(String s) {
        
        String longest = "";
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                String str = s.substring(i,j+1);

                if(isPalindrome(str) && str.length() > max){
                    max = str.length();
                    longest = str;
                }
            }
        }
        return longest;
    }
    public boolean isPalindrome(String str){
        int left = 0;
        int right = str.length()-1;

        while(left <= right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}                
```

---

*Auto-committed by [LeetSync](https://github.com/topics/leetsync) on July 19, 2026*
