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
    string tree2str(TreeNode* t) {
        vector<char> res;
        if(t==NULL){
            return "";
        }
        char str[4];
        preorder(t, res, str);
        char* tmp = &res[0];
        return string(tmp, res.size());
    }

    inline void preorder(TreeNode* p, vector<char>& res, char* str){
        if(!p){
            return;
        }
        int val = p->val;
        if(val < 0){
            res.push_back('-');
            val = -val;
        }
        if(val == 0){
            res.push_back('0');
        }
        else{
            vector<char> tmp;
            while(val > 0){
                tmp.push_back(val % 10 + '0');
                val /= 10;
            }
            for(int i=tmp.size()-1; i>=0; i--){
                res.push_back(tmp[i]);
            }
        }
        if(p->left){
            res.push_back('(');
            preorder(p->left, res, str);
            res.push_back(')');
        }
        if(p->right){
            if(!p->left){
                res.push_back('(');
                res.push_back(')');
            }
            res.push_back('(');
            preorder(p->right, res, str);
            res.push_back(')');
        }
    }
};