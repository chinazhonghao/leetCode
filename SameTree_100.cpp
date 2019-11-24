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
    bool isSameTree(TreeNode* p, TreeNode* q) {
        queue<TreeNode*> qp, qq;
        if(p != nullptr && q!= nullptr){
            qp.push(p);
            qq.push(q);
        }
        else if(p!= nullptr || q!= nullptr){
            return false;
        }
        while(!qp.empty()){
            p = qp.front();
            q = qq.front();
            qp.pop();
            qq.pop();
            if(p->val != q->val){
                return false;
            }
            if(p->left != nullptr && q->left != nullptr){
                qp.push(p->left);
                qq.push(q->left);
            }
            else if(p->left != nullptr || q->left != nullptr){
                return false;
            }

            if(p->right != nullptr && q->right != nullptr){
                qp.push(p->right);
                qq.push(q->right);
            }
            else if(p->right != nullptr || q->right != nullptr){
                return false;
            }
        }
        return true;
    }
};