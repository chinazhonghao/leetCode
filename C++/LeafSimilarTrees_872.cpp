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
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int> leaf1, leaf2;
        travel(root1, leaf1);
        travel(root2, leaf2);
        if(leaf1.size() == leaf2.size()){
            int len = leaf1.size();
            for(int i=0; i<len; i++){
                if(leaf1[i] != leaf2[i]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    void travel(TreeNode* root, vector<int>& leaf){
        if(root==NULL){
            return;
        }
        stack<TreeNode*> s;
        TreeNode* current = root;
        while(current!=NULL || !s.empty()){
            if(current != NULL){
                s.push(current);
                current = current->left;
            }
            else{
                current = s.top();
                s.pop();
                if(current->left==NULL && current->right==NULL){
                    leaf.push_back(current->val);
                }
                current = current->right;
            }
        }
    }
};