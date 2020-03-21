/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isBalanced(TreeNode* root) {
        int depth = 0;
        return getDepth(root, depth);
    }

    bool getDepth(TreeNode * current, int & depth){
        if(!current){
            return 0;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        if(getDepth(current->left, leftDepth) && getDepth(current->right, rightDepth)){
            if(fabs(leftDepth - rightDepth) <= 1){
                depth = leftDepth > rightDepth ? leftDepth+1:rightDepth+1;
                return true;
            }
        }
        return false;
    }
};