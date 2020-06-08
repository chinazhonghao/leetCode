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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return _recursive(preorder, inorder, 0, preorder.length-1, 0);
    }

    private TreeNode _recursive(int[] preorder, int[] inorder, int start, int end, int prestart){
        //System.out.println(start+":"+end+":"+prestart);
        if(start > end || prestart >= preorder.length){
            return null;
        }
        
        if(start == end){
            return new TreeNode(preorder[prestart]);
        }

        TreeNode node = new TreeNode(preorder[prestart]);
        int pos = _index(inorder, preorder[prestart]);
        node.left = _recursive(preorder, inorder, start, pos-1, prestart+1);
        node.right = _recursive(preorder, inorder, pos+1, end, prestart+1+(pos-start));

        return node;
    }
    
    private int _index(int[] vals, int val) {
        for(int i=0; i<vals.length; i++){
            if(vals[i] == val){
                return i;
            }
        }
        return -1;
    }
}