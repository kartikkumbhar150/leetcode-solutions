# 0002. Add Two Numbers

![Medium](https://img.shields.io/badge/Difficulty-Medium-yellow)

**Problem:** [https://leetcode.com/problems/add-two-numbers/](https://leetcode.com/problems/add-two-numbers/)

**Difficulty:** Medium  
**Tags:** `Linked List` · `Math` · `Recursion`  
**Language:** java  
**Runtime:** 1 ms  
**Memory:** 46.6 MB  

---

## Solution

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int carry = 0;
        ListNode curr = dummy;

        while(l1 != null || l2 != null || carry !=0 ){
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2+carry;
            int digit = sum%10;
            carry = sum / 10;

            curr.next = new ListNode(digit);
            curr = curr.next;
            if(l1!= null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }

        }
        return dummy.next;

    }
}
```

---

*Auto-committed by [LeetSync](https://github.com/topics/leetsync) on July 19, 2026*
