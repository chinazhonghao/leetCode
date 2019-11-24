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
    int sumOfLeftLeaves(TreeNode* root) {
        if(root == nullptr){
            return 0;
        }
        int sum = 0;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            root = q.front();
            q.pop();
            if(root->left != nullptr){
                q.push(root->left);
                if(root->left->left == nullptr && root->left->right == nullptr){
                    sum += root->left->val;
                }
            }
            if(root->right != nullptr){
                q.push(root->right);
            }
        }
        return sum;
    }
};