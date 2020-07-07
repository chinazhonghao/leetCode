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
    public int[] nextLargerNodes(ListNode head) {
        ListNode current = head;
        int length = 0;
        while(current != null){
            length++;
            current = current.next;
        }
        int[] result = new int[length];
        Stack<int[]> s = new Stack<>();
        int i = 0;
        while(head != null){
            while(!s.empty() && s.peek()[0] < head.val){
                int index = s.peek()[1];
                result[index] = head.val;
                s.pop();
            }
            s.push(new int[]{head.val, i});
            head = head.next;
            i++;
        }
        return result;
    }
}