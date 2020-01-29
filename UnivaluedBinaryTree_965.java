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
    public boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        return _uni(root.left, val) && _uni(root.right, val);
    }

    private boolean _uni(TreeNode root, int val){
    	if(root == null){
    		return true;
    	}
    	if(root.val != val){
    		return false;
    	}
    	return _uni(root.left, val) && _uni(root.right, val);
    }
}