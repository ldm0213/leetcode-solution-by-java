package com.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author  lidongmeng
 * @date 2023-01-30 19:03:18
 * @link https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class T23MergeKSortedLists {

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static void main(String[] args) {
        Solution solution = new T23MergeKSortedLists().new Solution();
        // write test case
   }

   //leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node: lists) {
            if (node != null) {
                q.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (!q.isEmpty()) {
            ListNode t = q.poll();
            prev.next = t;
            if (t.next != null) {
                q.add(t.next);
            }
            prev = prev.next;
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}