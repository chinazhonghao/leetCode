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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return _build(head);
    }

    public TreeNode _build(ListNode head){
        if(head == null){
            return null;
        }
        ListNode slow = head, fast = head, prev=null;
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
        System.out.println(slow.val);
        TreeNode root = new TreeNode(slow.val);
        if(prev != null){
            prev.next = null;
            root.left = _build(head);
        }
        fast = slow.next;
        root.right = _build(fast);
        return root;
    }
}