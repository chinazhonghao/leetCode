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
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        stack<vector<int>> _s;
        vector<vector<int>> result;
        if(!root){
            return result;
        }
        queue<TreeNode *> _q;
        _q.push(root);
        int count = 1;
        while(_q.size() > 0){
            int record = count;
            count = 0;
            vector<int> level;
            for(int i=0; i<record; i++){
                TreeNode * current = _q.front();
                level.push_back(current->val);
                if(current->left){
                    _q.push(current->left);
                    count++;
                }
                if(current->right){
                    _q.push(current->right);
                    count++;
                }
                _q.pop();
            }
            _s.push(level);
        }
        while(!_s.empty()){
            result.push_back(_s.top());
            _s.pop();
        }
        return result;
    }
};