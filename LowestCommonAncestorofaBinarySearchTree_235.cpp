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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode* current = root;
        int minVal = p->val < q->val ? p->val : q->val;
        int maxVal = p->val > q->val ? p->val : q->val;
        while(current != nullptr){
            int currentVal = current->val;
            if(currentVal<maxVal && currentVal>minVal){
                return current;
            }
            else if(currentVal<minVal){
                current = current->right;
            }
            else if(currentVal>maxVal){
                current = current->left;
            }
            else if(currentVal==minVal || currentVal==maxVal){
                return current;
            }
        }
        return nullptr;
    }
};