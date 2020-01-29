/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode current = root;
        while(current != null){
        	if(current.val < val){
        		current = current.right;
        	}
        	else if(current.val > val){
        		current = current.left;
        	}
        	else {
        		return current;
        	}
        }
        return null;
    }
}