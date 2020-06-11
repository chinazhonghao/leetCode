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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode p=null, pre = null, current = head, next = head.next;
        boolean isRepeated = false;
        while(current != null){
            while(current!=null&&current.next!=null&&current.next.val == current.val){
                isRepeated = true;
                current.next = current.next.next;
            }
            if(isRepeated){
                isRepeated = false;
                if(pre != null){
                    pre.next = current.next;
                }
                current = current.next;
            }
            else {
                if(p == null){
                    p = current;
                }
                pre = current;
                current = current.next;
            }
        }
        return p;
    }
}