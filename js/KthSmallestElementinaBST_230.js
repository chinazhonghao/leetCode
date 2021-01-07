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
 * @param {number} k
 * @return {number}
 */
function countChilds(root){
  if(!root) return 0;
  if(root.num) {
    return root.num;
  }
  root.lnum = countChilds(root.left);
  root.rnum = countChilds(root.right);
  root.num = root.lnum + root.rnum + 1;
  return root.num;
}

var kthSmallest = function(root, k) {
    countChilds(root);
    function _b(root, k){
      if(root.lnum >= k){
        return _b(root.left, k);
      }
      else if(root.lnum + 1 >= k){
        return root.val;
      }
      else {
        k -= (root.lnum + 1);
        return _b(root.right, k);
      }
    }
    return _b(root, k);
};