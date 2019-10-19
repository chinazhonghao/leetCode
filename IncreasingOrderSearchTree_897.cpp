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
    TreeNode* increasingBST(TreeNode* root) {
        TreeNode* current = root;
        TreeNode* last = NULL;
        TreeNode* head = NULL;
        stack<TreeNode*> s;
        while(current!=NULL || !s.empty()){
            if(current!=NULL){
                s.push(current);
                current = current->left;
            }
            else{
                current = s.top();
                current->left = NULL;
                s.pop();
                if(last == NULL){
                    last = current;
                    head = last;
                }
                else{
                    last->right = current;
                    last = current;
                }
                current = current->right;
            }
        }
        return head;
    }
};