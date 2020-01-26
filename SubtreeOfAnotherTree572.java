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
    public boolean isSubtree(TreeNode s, TreeNode t) {
    	List<Integer> st = preOrder(t);
        List<Integer> rt = postOrder(t);
        List<TreeNode> ss = order(s);
        for(int i=0; i<ss.size(); i++){
        	if(ss.get(i).val == t.val){
        		List<Integer> ssr = preOrder(ss.get(i));
        		List<Integer> sst = postOrder(ss.get(i));
        		if(equals(st, ssr) && equals(sst, rt)){
        			return true;
        		}
        	}
        }
        return false;
    }

    private List<Integer> preOrder(TreeNode root){
    	List<Integer> nodes = new ArrayList<>();
    	Stack<TreeNode> s = new Stack<>();
    	TreeNode current = root;
    	while(current != null || !s.empty()){
    		if(current != null){
    			nodes.add(current.val);
    			s.push(current);
    			current = current.left;
    		}
    		else {
    			current = s.pop();
    			current = current.right;
    		}
    	}
    	return nodes;
    }

    private List<TreeNode> order(TreeNode root){
    	List<TreeNode> nodes = new ArrayList<>();
    	Stack<TreeNode> s = new Stack<>();
    	TreeNode current = root;
    	while(current != null || !s.empty()){
    		if(current != null){
    			nodes.add(current);
    			s.push(current);
    			current = current.left;
    		}
    		else {
    			current = s.pop();
    			current = current.right;
    		}
    	}
    	return nodes;
    }

    private List<Integer> postOrder(TreeNode root){
    	List<Integer> nodes = new ArrayList();
    	TreeNode current = root;
    	TreeNode last = null;
    	Stack<TreeNode> s = new Stack<>();
    	while(current != null || !s.empty()){
    		if(current != null){
    			s.push(current);
    			current = current.left;
    		}
    		else {
    			current = s.peek();
    			if(current.right == null || current.right == last){
    				nodes.add(current.val);
    				last = current;
    				current = null;
    				s.pop();
    			}
    			else {
    				current = current.right; 
    			}
    		}
    	}
    	return nodes;
    }

    private boolean equals(List<Integer> ss, List<Integer> st){
    	if (ss.size() != st.size()){
    		return false;
    	}

    	for(int i=0; i<ss.size(); i++){
    		if(!ss.get(i).equals(st.get(i))){
    			return false;
    		}
    	}
    	return true;
    }
}