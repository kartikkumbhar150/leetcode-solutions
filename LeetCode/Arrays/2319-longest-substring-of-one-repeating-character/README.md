# 2319. Longest Substring of One Repeating Character

![Hard](https://img.shields.io/badge/Difficulty-Hard-red)

**Problem:** [https://leetcode.com/problems/longest-substring-of-one-repeating-character/](https://leetcode.com/problems/longest-substring-of-one-repeating-character/)

**Difficulty:** Hard  
**Tags:** `Array` · `String` · `Segment Tree` · `Ordered Set`  
**Language:** java  
**Runtime:** 112 ms  
**Memory:** 157.8 MB  

---

## Solution

```java
class Solution {
    class Node {
        int len;       // segment length
        int pref;      // longest same-character prefix
        int suff;      // longest same-character suffix
        int best;      // longest same-character substring
        char leftChar;
        char rightChar;

        Node() {}

        Node(char c) {
            len = 1;
            pref = suff = best = 1;
            leftChar = rightChar = c;
        }
    }

    Node[] tree;
    char[] s;

    void build(int idx, int l, int r) {
        if (l == r) {
            tree[idx] = new Node(s[l]);
            return;
        }

        int mid = (l + r) / 2;

        build(idx * 2, l, mid);
        build(idx * 2 + 1, mid + 1, r);

        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node res = new Node();

        res.len = a.len + b.len;
        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;

        res.pref = a.pref;
        res.suff = b.suff;
        res.best = Math.max(a.best, b.best);

        // Entire prefix is same character
        if (a.pref == a.len && a.rightChar == b.leftChar) {
            res.pref = a.len + b.pref;
        }

        // Entire suffix is same character
        if (b.suff == b.len && a.rightChar == b.leftChar) {
            res.suff = b.len + a.suff;
        }

        // Join suffix of left + prefix of right
        if (a.rightChar == b.leftChar) {
            res.best = Math.max(res.best, a.suff + b.pref);
        }

        return res;
    }

    void update(int idx, int l, int r, int pos, char c) {
        if (l == r) {
            tree[idx] = new Node(c);
            return;
        }

        int mid = (l + r) / 2;

        if (pos <= mid) {
            update(idx * 2, l, mid, pos, c);
        } else {
            update(idx * 2 + 1, mid + 1, r, pos, c);
        }

        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    public int[] longestRepeating(
        String s,
        String queryCharacters,
        int[] queryIndices
    ) {
        int n = s.length();
        int k = queryIndices.length;

        this.s = s.toCharArray();

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            int pos = queryIndices[i];
            char c = queryCharacters.charAt(i);

            this.s[pos] = c;

            update(1, 0, n - 1, pos, c);

            ans[i] = tree[1].best;
        }

        return ans;
    }
}
```

---

*Auto-committed by [uCode](https://github.com/topics/ucode) on August 14, 2026*
