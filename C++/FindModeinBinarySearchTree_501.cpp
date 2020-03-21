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
    vector<int> findMode(TreeNode* root) {
        vector<int> result;
        int val = -1;
        int maxCount = 0;
        int count = 0;
        stack<TreeNode*> s;
        TreeNode* current = root;
        if(current == nullptr){
            return result;
        }
        s.push(current);
        current = current->left;
        while(current != nullptr || s.size()>0){
            if(current!= nullptr){
                s.push(current);
                current = current->left;
            }
            else{
                current = s.top();
                if(current->val != val){
                    if(count > maxCount){
                        result.clear();
                        result.push_back(val);
                        maxCount = count;
                    }
                    else if(count == maxCount && count > 0){
                        result.push_back(val);
                    }
                    val = current->val;
                    count = 1;
                }
                else {
                    count++;
                }
                s.pop();
                current = current->right;
            }
        }
        if(count > maxCount){
            result.clear();
            result.push_back(val);
            maxCount = count;
        }
        else if(count == maxCount && count > 0){
            result.push_back(val);
        }
        return result;
    }
};