# 0124. Binary Tree Maximum Path Sum

![Hard](https://img.shields.io/badge/Difficulty-Hard-red)

**Problem:** [https://leetcode.com/problems/binary-tree-maximum-path-sum/](https://leetcode.com/problems/binary-tree-maximum-path-sum/)

**Difficulty:** Hard  
**Tags:** `Dynamic Programming` · `Tree` · `Depth-First Search` · `Binary Tree` · `DP on Trees`  
**Language:** java  
**Runtime:** 0 ms  
**Memory:** 46.5 MB  

---

## Solution

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    public int dfs(TreeNode root){

        if(root == null){
            return 0;
        }

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        maxSum = Math.max(maxSum , root.val+left + right);

        return root.val + Math.max(left, right);
    }
}
```

---

*Auto-committed by [uCode](https://github.com/topics/ucode) on August 17, 2026*
