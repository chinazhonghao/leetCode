

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {
    private HashMap<Integer, Integer> h;

    public FindElements(TreeNode root) {
        root.val = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        h = new HashMap<>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                node.left.val = node.val * 2 + 1;
                h.put(node.left.val, 1);
                q.offer(node.left);
            }

            if(node.right != null){
                node.right.val = node.val * 2 + 2;
                h.put(node.right.val, 1);
                q.offer(node.right);
            }
        }
    }
    
    public boolean find(int target) {
        return h.containsKey(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */