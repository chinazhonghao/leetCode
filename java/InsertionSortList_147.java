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
    public ListNode insertionSortList(ListNode head) {
        ListNode current = null;
        while(head != null){
            if(current == null){
                current = head;
                head = head.next;
                current.next = null;
            }
            else {
                ListNode tmp = current, prev = null, h=head;
                while(current != null && current.val < head.val){
                    prev = current;
                    current = current.next;
                }
                head = head.next;
                h.next = current;
                if(prev != null){
                    prev.next = h;
                }
                else {
                    tmp = h;
                }
                current = tmp;
            }
        }
        return current;
    }
}