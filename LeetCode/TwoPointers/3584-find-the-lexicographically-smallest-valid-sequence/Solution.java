class Solution {
    public int[] validSequence(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int n = w1.length;
        int m = w2.length;
        
        // right[i] stores the max length of a valid exact suffix match of word2
        // that can be found in word1[i...n-1]
        int[] right = new int[n + 1];
        int j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && w1[i] == w2[j]) {
                j--;
            }
            right[i] = m - 1 - j;
        }
        
        int[] res = new int[m];
        boolean skipped = false;
        int last_i = -1;
        
        for (int k = 0; k < m; k++) {
            boolean found = false;
            
            for (int i = last_i + 1; i < n; i++) {
                // If it's an exact match, it's always optimal to take it.
                if (w1[i] == w2[k]) {
                    res[k] = i;
                    last_i = i;
                    found = true;
                    break;
                } 
                // Alternatively, if we haven't skipped yet, we can use this character as a mismatch 
                // provided the exact rest of word2 can be successfully matched in the rest of word1.
                else if (!skipped && right[i + 1] >= m - 1 - k) {
                    res[k] = i;
                    last_i = i;
                    skipped = true;
                    found = true;
                    break;
                }
            }
            
            // If we couldn't find a valid continuation for word2[k], sequence isn't achievable 
            if (!found) {
                return new int[0];
            }
        }
        
        return res;
    }
}