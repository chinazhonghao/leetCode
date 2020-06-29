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
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode slow = head, fast=head;
        while(fast != null){
            fast = fast.next;
            if(fast == null){
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        if(fast == null){
            return;
        }
        ListNode next = fast.next;
        ListNode tmp = null;
        fast.next = null;
        while(next != null){
            tmp = next.next;
            next.next = fast;
            fast = next;
            next = tmp;
        }

        slow = head;
        while(fast != null){
            tmp = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            slow = fast.next;
            fast = tmp;
        }
    }
}