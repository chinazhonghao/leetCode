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
    ListNode* reverseList(ListNode* head) {
        ListNode* current = head;
        if(!current || !current->next){
            return current;
        }
        head = current->next;
        current->next = NULL;
        ListNode* pre = head->next;
        head->next = current;
        current = pre;
        while(current){
            pre = current->next;
            current->next = head;
            head = current;
            current = pre;
        }
        return head;
    }
};