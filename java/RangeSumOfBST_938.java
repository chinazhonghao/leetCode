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
    public int rangeSumBST(TreeNode root, int L, int R) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode current = root;
        int sum = 0;
        while(current != null || !s.empty()){
        	if(current != null){
        		s.push(current);
        		current = current.left;
        	}
        	else {
        		current = s.pop();
        		if(current.val >= L && current.val <= R){
        			sum += current.val;
        		}
        		current = current.right;
        	}
        }
        return sum;
    }
}