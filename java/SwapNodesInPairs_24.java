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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode result = head.next;
        head.next = head.next.next;
        result.next = head;
        ListNode pre = result.next;
        ListNode current = pre.next;
        while(current != null && current.next != null){
            pre.next = current.next;
            current.next = current.next.next;
            pre.next.next = current;
            pre = current;
            current = pre.next;
        }
        return result;
    }
}