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
    public TreeNode sortedArrayToBST(int[] nums) {
        Node root = null;
        for(int i=0; i<nums.length; i++){
        	root = insert(root, nums[i]);
        }
        return root;
    }

    Node insert(Node node, int val){
    	if(node == null){
    		return new Node(val);
    	}

    	if(val < node.val){
    		node.left = insert((Node)node.left, val);
    	}
    	else if(val > node.val){
    		node.right = insert((Node)node.right, val);
    	}
    	else{
    		return node;
    	}

    	node.height = 1 + Math.max(height((Node)node.left), height((Node)node.right));

    	int balance = getBalance(node);
    	if(balance > 1 && val < node.left.val){
    		return ll_rotate(node);
    	}

    	if(balance < -1 && val > node.right.val){
    		return rr_rotate(node);
    	}

    	if(balance > 1 && val > node.left.val){
    		node.left = rr_rotate((Node)node.left);
    		return ll_rotate(node);
    	}

    	if(balance < -1 && val < node.right.val){
    		node.right = ll_rotate((Node)node.right);
    		return rr_rotate(node);
    	}

    	return node;
    }

    public static class Node extends TreeNode {
    	public Node(int x){
    		super(x);
    		this.height = 1;
    	}

    	public int height;
    }

    private Node ll_rotate(Node y){
    	Node x = (Node)y.left;
    	y.left = x.right;
    	x.right = y;

    	y.height = Math.max(height((Node)y.left), height((Node)y.right)) + 1;
    	x.height = Math.max(height((Node)x.left), height((Node)x.right)) + 1;
    	return x;
    }

    private Node rr_rotate(Node y){
    	Node x = (Node)y.right;
    	y.right = x.left;
    	x.left = y;

    	y.height = Math.max(height((Node)y.left), height((Node)y.right)) + 1;
    	x.height = Math.max(height((Node)x.left), height((Node)x.right)) + 1;
    	return x;
    }

    private int getBalance(Node y){
    	if(y == null){
    		return 0;
    	}
    	return height((Node)y.left) - height((Node)y.right);
    }

    private int height(Node y){
    	if(y == null){
    		return 0;
    	}
    	return y.height;
    }
}