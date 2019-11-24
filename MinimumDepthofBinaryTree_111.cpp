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
    int minDepth(TreeNode* root) {
        if(root == nullptr){
            return 0;
        }
        int result = 1;
        queue<TreeNode*> l, r;
        l.push(root);
        while(!l.empty() || !r.empty()){
            if(!l.empty()){
                while(!l.empty()){
                    root = l.front();
                    l.pop();
                    if(root->left == nullptr && root->right== nullptr){
                        return result;
                    }
                    if(root->left != nullptr){
                        r.push(root->left);
                    }
                    if(root->right != nullptr){
                        r.push(root->right);
                    }
                }
                result++;
            }
            else {
                while(!r.empty()){
                    root = r.front();
                    r.pop();
                    if(root->left == nullptr && root->right== nullptr){
                        return result;
                    }
                    if(root->left != nullptr){
                        l.push(root->left);
                    }
                    if(root->right != nullptr){
                        l.push(root->right);
                    }
                }
                result++;
            }
        }
        return result;
    }
};