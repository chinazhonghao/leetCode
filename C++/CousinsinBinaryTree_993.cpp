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
    bool isCousins(TreeNode* root, int x, int y) {
        queue<TreeNode*> q_even, q_odd;
        TreeNode* current = root;
        TreeNode* parent_x = NULL;
        TreeNode* parent_y = NULL;
        if(current->val == x){
            parent_x = current;
        }
        else if(current->val == y){
            parent_y = current;
        }
        q_even.push(current);
        int depth = 0;
        while(q_even.size()>0 || q_odd.size()>0){
            if(depth & 0x01 == 1){
                current = q_odd.front();
                if(current->left){
                    if(current->left->val == x){
                        parent_x = current;
                    }
                    else if(current->left->val == y){
                        parent_y = current;
                    }
                    q_even.push(current->left);
                }
                if(current->right){
                    if(current->right->val == x){
                        parent_x = current;
                    }
                    else if(current->right->val == y){
                        parent_y = current;
                    }
                    q_even.push(current->right);
                }
                q_odd.pop();
                if(q_odd.size() == 0){
                    depth++;
                    if((parent_x!=NULL&&parent_y==NULL)||(parent_y!=NULL && parent_x==NULL) || (parent_x!=NULL&&parent_x==parent_y)){
                        return false;
                    }
                    else if((parent_x!=NULL && parent_y!=NULL && parent_x!=parent_y)){
                        return true;
                    }
                    else if(parent_x!=NULL && parent_y!=NULL && parent_x==parent_y){
                        return false;
                    }
                }
            }
            else{
                current = q_even.front();
                if(current->left){
                    if(current->left->val == x){
                        parent_x = current;
                    }
                    else if(current->left->val == y){
                        parent_y = current;
                    }
                    q_odd.push(current->left);
                }
                if(current->right){
                    if(current->right->val == x){
                        parent_x = current;
                    }
                    else if(current->right->val == y){
                        parent_y = current;
                    }
                    q_odd.push(current->right);
                }
                q_even.pop();
                if(q_even.size() == 0){
                    depth++;
                    if((parent_x!=NULL&&parent_y==NULL)||(parent_y!=NULL && parent_x==NULL) || (parent_x!=NULL&&parent_x==parent_y)){
                        return false;
                    }
                    else if((parent_x!=NULL && parent_y!=NULL && parent_x!=parent_y)){
                        return true;
                    }
                    else if(parent_x!=NULL && parent_y!=NULL && parent_x==parent_y){
                        return false;
                    }
                }
            }
        }
        return true;
    }
};