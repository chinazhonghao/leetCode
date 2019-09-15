/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

#include <stdlib.h>
class Solution {
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> result;
        if(!root){
            return result;
        }
        stack<TreeNode *> _s;
        _s.push(root);
        TreeNode * current = root;
        TreeNode * pop = NULL;
        while(!_s.empty()){
            current = _s.top();
            if(!current->left && !current->right){
                result.push_back(getPath(_s));
                _s.pop();

                while(!_s.empty()){
                    pop = _s.top();
                    if(current == pop->right){
                        current = pop;
                        _s.pop();
                    }
                    else{
                        if(pop->right){
                            _s.push(pop->right);
                            break;
                        }
                        else{
                            current = pop;
                            _s.pop();
                        }
                    }
                }
                continue;
            }
            else if(current->left){
                _s.push(current->left);
            }
            else if(current->right){
                _s.push(current->right);
            }

        }
        return result;
    }

    string getNumStr(int val){
        char tmp[10];
        sprintf(tmp, "%d", val);
        return string(tmp, strlen(tmp));
    }

    string getPath(stack<TreeNode *>& _s){
        stack<TreeNode *> _copy;
        while(!_s.empty()){
            _copy.push(_s.top());
            _s.pop();
        }
        string path = "";
        while(!_copy.empty()){
            int val = _copy.top()->val;
            if(path.length() == 0){
                path = getNumStr(val);
            }
            else{
                path += "->" + getNumStr(val);
            }
            _s.push(_copy.top());
            _copy.pop();
        }
        return path;
    }
};