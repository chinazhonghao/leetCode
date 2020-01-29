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
    public TreeNode trimBST(TreeNode root, int L, int R) {
    	TreeNode pre = null;
    	TreeNode current = root;
    	while(current != null){
			if(current.val<L){
				current = current.right;
			}
			else if(current.val>R){
				current = current.left;
			}
			else {
				break;
			}
		}
		if(current == null){
			return null;
		}
		pre = current;
		_trim(pre, current.left, L, R);
		_trim(pre, current.right, L, R);
		return pre;
    }

    private void _trim(TreeNode pre, TreeNode current, int L, int R){
    	if(current == null){
    		return;
    	}
    	if(current.val < L){
    		pre.left = current.right;
    		_trim(pre, current.right, L, R);
    	}
    	else if(current.val > R){
    		pre.right = current.left;
    		_trim(pre, current.left, L, R);
    	}
    	else {
    		_trim(current, current.left, L, R);
    		_trim(current, current.right, L, R);
    	}
    }
}