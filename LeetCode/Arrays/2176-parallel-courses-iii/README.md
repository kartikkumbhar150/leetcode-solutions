# 2176. Parallel Courses III

![Hard](https://img.shields.io/badge/Difficulty-Hard-red)

**Problem:** [https://leetcode.com/problems/parallel-courses-iii/](https://leetcode.com/problems/parallel-courses-iii/)

**Difficulty:** Hard  
**Tags:** `Array` · `Dynamic Programming` · `Graph Theory` · `Topological Sort` · `Directed Acyclic Graph`  
**Language:** java  
**Runtime:** 24 ms  
**Memory:** 109.1 MB  

---

## Solution

```java
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n + 1];

        for (int[] relation : relations) {
            int u = relation[0];
            int v = relation[1];

            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        int[] dp = new int[n + 1];

        // Courses with no prerequisites
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                dp[i] = time[i - 1];
            }
        }

        int answer = 0;

        while (!queue.isEmpty()) {

            int u = queue.poll();

            answer = Math.max(answer, dp[u]);

            for (int v : graph.get(u)) {

                dp[v] = Math.max(
                    dp[v],
                    dp[u] + time[v - 1]
                );

                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return answer;
    }
}
```

---

*Auto-committed by [uCode](https://github.com/topics/ucode) on August 22, 2026*
