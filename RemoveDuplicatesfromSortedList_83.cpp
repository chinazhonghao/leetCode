/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        set<int> repeated;
        ListNode* current = head;
        if(!current){
            return NULL;
        }
        ListNode* last = current;
        repeated.insert(current->val);
        while(current){
            int val = current->val;
            if(repeated.find(val) != repeated.end()){
                last->next = current->next;
                delete current;
                current = last->next;
            }
            else{
                repeated.insert(val);
                last = current;
                current = current->next;
            }
        }
        return head;
    }
};