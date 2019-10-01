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
    int diameterOfBinaryTree(TreeNode* root) {
        int result = 0;
        stack<TreeNode*> s;
        TreeNode* current = root;
        if(current == NULL){
            return result;
        }
        s.push(current);
        current = current->left;
        TreeNode* last = NULL;
        while(current != NULL || s.size() > 0){
            if(current != NULL){
                s.push(current);
                current = current->left;
            }
            else{
                current = s.top();
                if(current->right && last != current->right){
                    current = current->right;
                }
                else{
                    last = s.top();
                    s.pop();
                    int sum = 0;
                    current->val = 0;
                    if(current->left){
                        sum += current->left->val + 1;
                        current->val = current->left->val + 1;
                    }
                    if(current->right){
                        if(current->right->val+1 > current->val){
                            current->val = current->right->val+1;
                        }
                        sum += current->right->val + 1;
                    }
                    if(sum > result){
                        result = sum;
                    }
                    current = NULL;
                }
            }
        }
        return result;
    }
};