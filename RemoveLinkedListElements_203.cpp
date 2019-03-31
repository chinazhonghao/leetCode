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
    ListNode* removeElements(ListNode* head, int val) {
        ListNode* current = head;
        ListNode* last = NULL;
        while(current){
            if(current->val != val){
                head = current;
                last = head;
                break;
            }
            current = current->next;
            head = current;
        }
        if(!current){
            return head;
        }
        current = current->next;
        while(current){
            if(current->val == val){
                last->next = current->next;
                current = last->next;
            }
            else{
                last = current;
                current = current->next;
            }
        }
        return head;
    }
};