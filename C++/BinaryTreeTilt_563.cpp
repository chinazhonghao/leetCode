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
    int findTilt(TreeNode* root) {
        int result = 0;
        findVal(root, result);
        return result;
    }

    int findVal(TreeNode * current, int &sum){
        if(!current){
            return 0;
        }

        int left = findVal(current->left, sum);
        int right = findVal(current->right, sum);
        sum += fabs(left - right);
        return left+right+current->val;
    }
};