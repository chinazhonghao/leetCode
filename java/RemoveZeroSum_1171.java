
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
    public ListNode removeZeroSumSublists(ListNode head) {
        int length = 0;
        ListNode current = head;
        while(current != null){
            length++;
            current = current.next;
        }

        int[] vals = new int[length+1];
        int index = 1;
        current = head;
        while(current != null){
            vals[index] = vals[index-1] + current.val;
            index++;
            current = current.next;
        }

        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<=length; ){
            boolean isFound = false;
            for(int j=length; j>i; j--){
                if(vals[i]==vals[j]){
                    m.put(i, j);
                    isFound = true;
                    i = j+1;
                    break;
                }
            }
            if(!isFound){
                i++;
            }
        }
        if(m.size() == 0){
            return head;
        }

        ListNode[] nodes = new ListNode[m.size()*2];
        int pos = 0;
        for(Map.Entry<Integer, Integer> entry: m.entrySet()){
            int start = entry.getKey();
            int end = entry.getValue();
            end++;
            index = 0;
            current = head;
            while(index <= end && current!=null){
                if(index == start-1){
                    nodes[pos] = current;
                }
                else if(index == end-1){
                    nodes[pos+1] = current;
                }
                index++;
                current = current.next;
            }
            pos += 2;
        }

        for(int i=0; i<nodes.length; i+=2){
            ListNode start = nodes[i];
            ListNode end = nodes[i+1];
            if(start != null && end != null){
                start.next = end;
            }
            else if(start == null && end == null){
                return null;
            }
            else if(start == null){
                head = end;
            }
            else if(end == null){
                start.next = null;
            }
        }
        return head;
    }
}