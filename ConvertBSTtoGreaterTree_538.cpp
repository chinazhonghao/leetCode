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
    TreeNode* convertBST(TreeNode* root) {
          stack<TreeNode *> travel;
          stack<TreeNode *> result;
          TreeNode* current = root;
          while(current!=NULL || !travel.empty()){
              if(current != NULL){
                  travel.push(current);
                  current = current->left;
              }
              else{
                  current = travel.top();
                  travel.pop();
                  result.push(current);
                  current = current->right;
              }
          }
          int sum = 0;
          while(!result.empty()){
              current = result.top();
              result.pop();
              sum += current->val;
              current->val = sum;
          }
          return root;
    }
};