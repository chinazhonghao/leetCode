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
    vector<double> averageOfLevels(TreeNode* root) {
        vector<double> result;
        TreeNode * current = root;
        if(!current){
            return result;
        }
        queue<TreeNode *> _q;
        _q.push(current);
        int count = 1;
        while(_q.size() > 0){
            double sum = 0;
            int record = count;
            count = 0;
            for(int i=0; i<record; i++){
                current = _q.front();
                _q.pop();
                sum += current->val;
                if(current->left){
                    _q.push(current->left);
                    count++;
                }
                if(current->right){
                    _q.push(current->right);
                    count++;
                }
            }
            result.push_back(sum / record);
        }
        return result;
    }
};