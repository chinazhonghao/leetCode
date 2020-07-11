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
    public boolean isSubPath(ListNode head, TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode current = root;
        if(current != null){
            q.add(current);
        }
        while(!q.isEmpty()){
            current = q.poll();
            if(current.left!=null){
                q.add(current.left);
            }
            if(current.right!=null){
                q.add(current.right);
            }
            nodes.add(current);
        }
        for(int i=0; i<nodes.size(); i++){
            current = nodes.get(i);
            if(_isEqual(current, head)){
                return true;
            }
        }
        return false;
    }

    private boolean _isEqual(TreeNode root, ListNode head){
        if(head == null){
            return true;
        }
        else if(root == null || root.val != head.val){
            return false;
        }

        return _isEqual(root.left, head.next) || _isEqual(root.right, head.next);
    }
}