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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode* currentB = headB;
        while(headA){
            currentB = headB;
            while(currentB){
                if(headA == currentB){
                    return headA;
                }
                currentB = currentB->next;
            }
            headA = headA->next;
        }
        return NULL;
    }
};