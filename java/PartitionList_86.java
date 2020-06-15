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
    public ListNode partition(ListNode head, int x) {
        ListNode less = null, prev=null, current = head;
        while(current != null){
            if(current.val < x){
                if(prev == null){
                    prev = current;
                }
                else {
                    prev.next = current.next;
                    if(less != prev){
                        if(less == null){
                            current.next = head;
                            head = current;
                        }
                        else {
                            current.next = less.next;
                            less.next = current;
                        }
                    }
                    else {
                        less.next = current;
                        prev = current;
                    }
                }
                less = current;
            }
            else {
                prev = current;
            }
            current = prev.next;
        }
        return head;
    }
}