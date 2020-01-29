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
    public int findSecondMinimumValue(TreeNode root) {
        long a1 = Long.MAX_VALUE, a2 = Long.MAX_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
        	TreeNode current = q.remove();
        	if(current.left == null){
        		if(current.val < a1){
        			a2 = a1;
        			a1 = current.val;
        		}
        		else if(current.val > a1 && current.val < a2){
        			a2 = current.val;
        		}
        	}
        	else {
        		q.add(current.left);
        		q.add(current.right);
        	}
        }
        if(a2 != Long.MAX_VALUE && a2 != a1){
        	return (int)a2;
        }
        return -1;
    }
}