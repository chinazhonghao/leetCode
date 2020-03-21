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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> l = preOrder(root);
        int left = 0;
        int right = l.size()-1;
        while(left < right){
        	if(l.get(left) + l.get(right) > k){
	        	right--;
	        }
	        else if(l.get(left) + l.get(right) < k){
	        	left++;
	        }
	        else {
	        	return true;
	        }
        }
        return false;
    }

    private List<Integer> preOrder(TreeNode root){
    	TreeNode current = root;
    	List<Integer> l = new ArrayList<>();
    	Stack<TreeNode> s = new Stack<>();
    	while(current != null || !s.empty()){
    		if(current != null){
    			s.push(current);
    			current = current.left;
    		}
    		else{
    			current = s.pop();
    			l.add(current.val);
    			current = current.right;
    		}
    	}
    	return l;
    }
}