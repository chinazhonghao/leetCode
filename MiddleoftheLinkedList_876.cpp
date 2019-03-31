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
    ListNode* middleNode(ListNode* head) {
        int length = 0;
        ListNode* current = head;
        while(current){
            length++;
            current = current->next;
        }
        int halfLen = length >> 1;
        current = head;
        while(halfLen){
            halfLen--;
            current = current->next;
        }
        return current;
    }
};