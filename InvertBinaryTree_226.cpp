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
    TreeNode* invertTree(TreeNode* root) {
        if(root == NULL){
            return root;
        }
        queue<TreeNode*> q;
        TreeNode* current = root;
        TreeNode* tmp = NULL;
        q.push(current);
        while(!q.empty()){
            current = q.front();
            q.pop();
            if(current->left != NULL){
                q.push(current->left);
            }
            if(current->right != NULL){
                q.push(current->right);
            }
            tmp = current->left;
            current->left = current->right;
            current->right = tmp;
        }
        return root;
    }
};