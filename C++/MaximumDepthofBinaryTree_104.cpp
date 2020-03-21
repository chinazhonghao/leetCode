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
    int maxDepth(TreeNode* root) {
        int depth = 0;
        stack<TreeNode*> s;
        stack<TreeNode*> r;
        TreeNode* current = root;
        TreeNode* last = nullptr;
        while(current!= nullptr||!s.empty()){
            if(current!= nullptr){
                s.push(current);
                current = current->left;
            }
            else{
                current = s.top();
                if(!r.empty() && r.top()==current){
                    if(s.size() > depth){
                        depth = s.size();
                    }
                    s.pop();
                    r.pop();
                    current = nullptr;
                }
                else {
                    r.push(current);
                    current = current->right;
                }
            }
        }
        return depth;
    }
};