# 1475. Maximum Sum BST in Binary Tree

![Hard](https://img.shields.io/badge/Difficulty-Hard-red)

**Problem:** [https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/](https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/)

**Difficulty:** Hard  
**Tags:** `Dynamic Programming` · `Tree` · `Depth-First Search` · `Binary Search Tree` · `Binary Tree` · `DP on Trees`  
**Language:** java  
**Runtime:** 5 ms  
**Memory:** 62.5 MB  

---

## Solution

```java
class Solution {

    int ans = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    // returns:
    // [isBST, min, max, sum]
    private int[] dfs(TreeNode root) {

        // null is a valid BST
        // min = +infinity
        // max = -infinity
        if (root == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // Check whether current subtree is BST
        if (left[0] == 1 &&
            right[0] == 1 &&
            root.val > left[2] &&
            root.val < right[1]) {

            int sum = left[3] + right[3] + root.val;

            int min = Math.min(root.val, left[1]);
            int max = Math.max(root.val, right[2]);

            ans = Math.max(ans, sum);

            return new int[]{1, min, max, sum};
        }

        // Not a BST
        return new int[]{0, 0, 0, 0};
    }
}
```

---

*Auto-committed by [uCode](https://github.com/topics/ucode) on August 17, 2026*
