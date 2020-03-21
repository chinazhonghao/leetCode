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
    bool isSymmetric(TreeNode* root) {
        return symmetric(root, root);
    }

    bool symmetric(TreeNode* p, TreeNode* q){
        if(p == nullptr && q == nullptr){
            return true;
        }
        else if(p == nullptr || q== nullptr){
            return false;
        }
        else {
            return (p->val == q->val) && symmetric(p->left, q->right) && symmetric(p->right, q->left);
        }
    }
};