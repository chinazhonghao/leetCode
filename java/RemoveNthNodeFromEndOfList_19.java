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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode[] nodes = new ListNode[n+1];
        int index = 0;
        ListNode current = head;
        while(current != null){
            nodes[index] = current;
            index++;
            if(index > n){
                index -= (n+1);
            }
            current = current.next;
        }
        int currentIndex = (index + 1) % (n+1);
        current = nodes[currentIndex];
        if(current == head){
            return current.next;
        }
        nodes[index].next = current.next;
        return head;
    }
}