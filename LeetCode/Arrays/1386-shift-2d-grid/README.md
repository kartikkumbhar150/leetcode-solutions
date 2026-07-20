# 1386. Shift 2D Grid

![Easy](https://img.shields.io/badge/Difficulty-Easy-brightgreen)

**Problem:** [https://leetcode.com/problems/shift-2d-grid/](https://leetcode.com/problems/shift-2d-grid/)

**Difficulty:** Easy  
**Tags:** `Array` · `Matrix` · `Simulation`  
**Language:** java  
**Runtime:** 6 ms  
**Memory:** 47.1 MB  

---

## Solution

```java
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        int [] arr = new int[grid.length * grid[0].length];
        int idx = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                arr[idx++] = grid[i][j];
            }
        }
        
        while(k > 0){
            int temp = arr[arr.length-1];
            for(int i = arr.length-1; i > 0; i--){
                arr[i] = arr[i-1];
            }
            arr[0] = temp;
            k--;
        }
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < grid.length; i++){
            ans.add(new ArrayList<>());
        }
        int id = 0;
        for(int i = 0; i < arr.length; i++){
            ans.get(id).add(arr[i]);

            if((i + 1) % grid[0].length == 0){
                id++;
            }
        }
        return ans;
    }
}
```

---

*Auto-committed by [LeetSync](https://github.com/topics/leetsync) on July 20, 2026*
