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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* head = NULL;
        if(l1 == NULL){
            return l2;
        }
        
        if(l2 == NULL){
            return l1;
        }

        if(l1->val > l2->val){
            head = l2;
            l2 = l2->next;
        }
        else {
            head = l1;
            l1 = l1->next;
        }
        ListNode* current = head;
        current->next = NULL;
        while(l1!=NULL && l2!=NULL ){
            if(l1->val > l2->val){
                current->next = l2;
                l2 = l2->next;
            }
            else {
                current->next = l1;
                l1 = l1->next;
            }
            current = current->next;
        }
        if(l1 != NULL){
            current->next = l1;
        }
        else if(l2 != NULL){
            current->next = l2;
        }
        return head;
    }
};