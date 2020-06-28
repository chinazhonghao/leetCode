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
    public ListNode sortList(ListNode head) {
        ListNode node = new ListNode();
        mergeSort(head, node);
        return node.next;
    }

    private void mergeSort(ListNode head, ListNode begin){
        if(head == null || head.next==null){
            begin.next = head;
            return;
        }
        ListNode slow = head, fast = head;
        ListNode prev = null;
        while(fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
            else {
                break;
            }
            prev = slow;
            slow = slow.next;
        }
        ListNode begin1 = head;
        ListNode begin2 = slow;
        prev.next = null;
        mergeSort(begin1, begin);
        begin1 = begin.next;
        mergeSort(begin2, begin);
        begin2 = begin.next;

        ListNode tmp = begin;
        while(begin1 != null && begin2 != null){
            if(begin1.val < begin2.val){
                tmp.next = begin1;
                begin1 = begin1.next;
            }
            else {
                tmp.next = begin2;
                begin2 = begin2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = (begin1==null)?begin2:begin1;
    }
}