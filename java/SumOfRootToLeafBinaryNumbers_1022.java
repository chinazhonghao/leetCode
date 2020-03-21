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
    public int sumRootToLeaf(TreeNode root) {
    	Queue<Node> q = new LinkedList<>();
    	q.add(new Node(root));
    	int sum = 0;
    	while(!q.isEmpty()){
    		Node node = q.remove();
			int parent = (node.parent << 1) + node.node.val;
			if(node.node.left == null && node.node.right == null){
				sum += parent;
				continue;
			}
			
			if(node.node.left != null){
				Node left = new Node(node.node.left);
				left.parent = parent;
				q.add(left);
			}

			if(node.node.right != null){
				Node right = new Node(node.node.right);
				right.parent = parent;
				q.add(right);
			}
    	}
    	return sum;
    }

    public static class Node {
    	public Node(TreeNode node){
    		this.node = node;
    		this.parent = 0;
    	}

    	public int parent;
    	public TreeNode node;
    }
}