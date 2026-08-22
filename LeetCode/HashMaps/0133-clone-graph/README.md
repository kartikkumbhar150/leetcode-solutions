# 0133. Clone Graph

![Medium](https://img.shields.io/badge/Difficulty-Medium-yellow)

**Problem:** [https://leetcode.com/problems/clone-graph/](https://leetcode.com/problems/clone-graph/)

**Difficulty:** Medium  
**Tags:** `Hash Table` · `Depth-First Search` · `Breadth-First Search` · `Graph Theory`  
**Language:** java  
**Runtime:** 25 ms  
**Memory:** 44.5 MB  

---

## Solution

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        if(node == null){
            return null;
        }
        Map<Node, Node> map = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        map.put(node, new Node(node.val));
        while(!queue.isEmpty()){
            Node curr = queue.poll();

            for(Node neigh : curr.neighbors){
                if(!map.containsKey(neigh)){
                    map.put(neigh, new Node(neigh.val));
                    queue.offer(neigh);
                }
                map.get(curr).neighbors.add(map.get(neigh));
                
            }

        }
        return map.get(node);
    }
}
```

---

*Auto-committed by [uCode](https://github.com/topics/ucode) on August 22, 2026*
