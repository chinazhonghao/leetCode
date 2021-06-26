/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var recoverTree = function (root) {
    let o = null, l = null, r = null;
    function _recursive(root) {
        const val = root.val;
        
    }
    _recursive(root);
    function swap(a, b) {
        const val = a.val;
        a.val = b.val;
        b.val = val;
    }
    if(state.left !== null && state.right !== null) {
        swap(state.left, state.right);
    } else if(state.left !== null) {
        swap(state.left, state.root);
    } else {
        swap(state.root, state.right);
    }
};