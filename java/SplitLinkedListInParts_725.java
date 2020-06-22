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
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        int length = 0;
        ListNode current = root;
        while(current != null){
            length++;
            current = current.next;
        }
        int count = length / k;
        int left = length - k * count;
        int index = 0;
        current = root;
        ListNode prev = null;
        while(current != null){
            if(left > 0){
                result[index] = current;
                prev = current;
                current = current.next;
                left--;
            }
            for(int i=0; i<count; i++){
                if(result[index] == null){
                    result[index] = current;
                }
                prev = current;
                current = current.next;
            }
            if(prev != null){
                prev.next = null;
            }
            index++;
        }
        return result;
    }
}