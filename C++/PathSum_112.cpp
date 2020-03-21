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
    bool hasPathSum(TreeNode* root, int sum) {
        if(root == nullptr){
            return false;
        }
        int count = 0;
        stack<TreeNode*> s;
        TreeNode* current = root;
        TreeNode* pre = nullptr;
        while(!s.empty() || current != nullptr){
            if(current != nullptr){
                s.push(current);
                current = current->left;
            }
            else {
                current = s.top();
                if(current->right == nullptr && current->left == nullptr){
                    if(check(s, sum)){
                        return true;
                    }
                }

                if(pre == current->right || current->right == nullptr){
                    pre = current;
                    current = nullptr;
                    s.pop();
                }
                else {
                    current = current->right;
                }
            }
        }
        return count;
    }

    bool check(stack<TreeNode*> s, int sum){
        stack<TreeNode*> copy;
        int result = 0;
        while(!s.empty()){
            TreeNode* current = s.top();
            s.pop();
            copy.push(current);
            result += current->val;
        }
        while(!copy.empty()){
            TreeNode* current = copy.top();
            copy.pop();
            s.push(current);
        }
        return result==sum;
    }
};