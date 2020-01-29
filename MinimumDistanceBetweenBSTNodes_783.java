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
    public int minDiffInBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode current = root;
        int diff = Integer.MAX_VALUE;
        TreeNode last = null;
        while(current != null || !s.empty()){
            if(current != null){
                s.push(current);
                current = current.left;
            }
            else {
                current = s.pop();
                if(last != null){
                    int tmp = Math.abs(current.val - last.val);
                    if(tmp < diff){
                        diff = tmp;
                    }
                }
                last = current;
                current = current.right;
            }
        }
        return diff;   
    }
}