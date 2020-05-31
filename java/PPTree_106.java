
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
class Solution {
    private int[] index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = new int[inorder.length];
        for(int i=0; i<postorder.length; i++){
            index[i] = _index(inorder, postorder[i]);
        }
        return _recursive(inorder, postorder, 0, inorder.length-1, inorder.length-1);
    }

    private TreeNode _recursive(int[] inorder, int[] postorder, int start, int end, int prestart){
        System.out.println(start+":"+end+":"+prestart);
        if(start > end || prestart < 0){
            return null;
        }
        TreeNode node = new TreeNode(postorder[prestart]);
        if(start == end){
            return node;
        }
        int pos = index[prestart];
        node.right = _recursive(inorder, postorder, pos+1, end, prestart-1);
        node.left = _recursive(inorder, postorder, start, pos-1, prestart-(end-pos+1));
        return node;
    }

    private int _index(int[] vals, int val){
        for(int i=0; i<vals.length; i++){
            if(vals[i] == val){
                return i;
            }
        }
        return -1;
    }
}