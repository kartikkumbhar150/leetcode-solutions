# 0299. Bulls and Cows

![Medium](https://img.shields.io/badge/Difficulty-Medium-yellow)

**Problem:** [https://leetcode.com/problems/bulls-and-cows/](https://leetcode.com/problems/bulls-and-cows/)

**Difficulty:** Medium  
**Tags:** `Hash Table` · `String` · `Counting`  
**Language:** java  
**Runtime:** 3 ms  
**Memory:** 43.5 MB  

---

## Solution

```java
class Solution {
    public String getHint(String secret, String guess) {

        int bulls = 0;
        int cows = 0;

        int[] freqSecret = new int[10];
        int[] freqGuess = new int[10];

        for (int i = 0; i < secret.length(); i++) {

            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                freqSecret[secret.charAt(i) - '0']++;
                freqGuess[guess.charAt(i) - '0']++;
            }
        }

        
        for (int i = 0; i < 10; i++) {
            cows += Math.min(freqSecret[i], freqGuess[i]);
        }

        return bulls + "A" + cows + "B";
    }
}
```

---

*Auto-committed by [uCode](https://github.com/topics/ucode) on August 8, 2026*
