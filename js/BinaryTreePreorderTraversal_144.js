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
 * @return {number[]}
 */
var preorderTraversal = function (root) {
  const result = [];
  const stack = [];
  const current = root;
  while (current || stack.length > 0) {
    if ( current ) {
      result.push(current.val);
      stack.push(current);
      current = current.left;
    } else {
      current = stack.pop();
      current = current.right;
    }
  }
  return result;
};
