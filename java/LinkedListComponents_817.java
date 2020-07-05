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
    public int numComponents(ListNode head, int[] G) {
        Map<Integer, Integer[]> m = new HashMap<>();
        int count = 0;
        ListNode prev = null;
        while(head != null){
            Integer[] vals = {-1, -1};
            if(prev != null){
                vals[0] = prev.val;
            }
            if(head.next != null){
                vals[1] = head.next.val;
            }
            m.put(head.val, vals);
            prev = head;
            head = head.next;
        }

        int length = G.length;
        for(int i=0; i<length; i++){
            int current = G[i];
            Integer[] vals = m.get(current);
            int links = 0;
            for(int k=0; k<vals.length; k++){
                if(vals[k] == -1){
                    continue;
                }
                for(int j=0; j<i; j++){
                    if(vals[k] == G[j]){
                        links++;
                        break;
                    }
                }
            }
            if(links == 0){
                count++;
            }
            else if(links == 2){
                count--;
            }
        }
        return count;
    }
}