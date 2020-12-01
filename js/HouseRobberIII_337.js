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
 * @return {number}
 */
var rob = function(root) {
    function _recursive(node){
        if(!node){
            return [0,0];
        }
        if(!node.left && !node.right){
            return [node.val, 0];
        }
        var left, right, child, current;
        left = _recursive(node.left);
        right = _recursive(node.right);
        child = left[0] + right[0];
        current = node.val + left[1] + right[1];
        current = current > child ? current : child;
        return [current, child]
    }

    return _recursive(root)[0];
};