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
    public ListNode rotateRight(ListNode head, int k) {
        int length =0;
        ListNode current = head;
        ListNode tail = null;
        while(current != null){
            length++;
            tail = current;
            current = current.next;
        }
        if(length < 2){
            return head;
        }
        if(k >= length){
            k = k % length;
        }
        if(k < 1){
            return head;
        }
        current = head;
        k = length - k;
        ListNode pre = null;
        while(k > 0){
            pre = current;
            current = current.next;
            k--;
        }
        tail.next = head;
        pre.next = null;
        return current;
    }
}