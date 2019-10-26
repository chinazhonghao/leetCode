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
    int longestUnivaluePath(TreeNode* root) {
        length = 0;
        longestLength(root);
        return length;
    }

    int longestLength(TreeNode* root){
        if(root== nullptr){
            return 0;
        }
        int left = longestLength(root->left);
        int right = longestLength(root->right);
        int arrowLeft = 0, arrowRight = 0;
        if(root->left!= nullptr&&root->left->val==root->val){
            arrowLeft = left + 1;
        }
        if(root->right!= nullptr&&root->right->val==root->val){
            arrowRight = right + 1;
        }

        length = length > arrowLeft+arrowRight?length:arrowLeft+arrowRight;
        return arrowLeft > arrowRight ? arrowLeft:arrowRight;
    }
private:
    int length;
};