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
function height(node) {
  return node ? 1 + Math.max(height(node.left), height(node.right)) : 0;
}

var countNodes = function (root) {
  var h = height(root);
  if(h < 1){
    return 0;
  }
  if(height(root.right) === h-1){
    return (1 << (h-1)) + countNodes(root.right);
  }
  else {
    return (1 << (h-2)) + countNodes(root.left);
  }
};