class Solution {
    public String lexGreaterPermutation(String s, String target) {
        
        int n = s.length();

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] ans = new char[n];

        for (int i = 0; i < n; i++) {

            int t = target.charAt(i) - 'a';

            // Case 1: We can keep the prefix equal to target
            if (freq[t] > 0) {
                ans[i] = target.charAt(i);
                freq[t]--;
            } 
            else {
                // target[i] is unavailable.
                // Try to make the answer greater at this position.
                for (int c = t + 1; c < 26; c++) {

                    if (freq[c] > 0) {

                        ans[i] = (char) ('a' + c);
                        freq[c]--;

                        // Fill remaining positions with smallest chars
                        fillRemaining(ans, i + 1, freq);

                        return new String(ans);
                    }
                }

                // Can't make it greater here.
                // Backtrack to previous positions.
                return backtrack(ans, target, i, freq);
            }
        }

        /*
         * We constructed target exactly.
         * Therefore, we need to backtrack and find
         * the next greater permutation.
         */
        return backtrack(ans, target, n, freq);
    }

    private String backtrack(
            char[] ans,
            String target,
            int pos,
            int[] freq) {

        for (int i = pos - 1; i >= 0; i--) {

            // Restore the character used at position i
            int current = ans[i] - 'a';
            freq[current]++;

            int targetChar = target.charAt(i) - 'a';

            // Find smallest character greater than target[i]
            for (int c = targetChar + 1; c < 26; c++) {

                if (freq[c] > 0) {

                    ans[i] = (char) ('a' + c);
                    freq[c]--;

                    // Fill the rest with smallest characters
                    fillRemaining(ans, i + 1, freq);

                    return new String(ans);
                }
            }
        }

        return "";
    }

    private void fillRemaining(
            char[] ans,
            int start,
            int[] freq) {

        int index = start;

        for (int c = 0; c < 26; c++) {

            while (freq[c] > 0) {
                ans[index++] = (char) ('a' + c);
                freq[c]--;
            }
        }
    }
}