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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null, current = head, h = null, l=null;
        int index = 1;
        while(current != null){
            if(index == m){
                h = current;
                l = h;
                current = current.next;
            }
            else if(index == n){
                l.next = current.next;
                current.next = h;
                if(prev != null){
                    prev.next = current;
                }
                else {
                    head = current;
                }
                break;
            }
            else if(index > m && index < n) {
                ListNode tmp = current.next;
                current.next = h;
                h = current;
                current = tmp;
            }
            else {
                prev = current;
                current = current.next;
            }
            index++;
        }
        return head;
    }
}