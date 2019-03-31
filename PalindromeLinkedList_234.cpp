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
    bool isPalindrome(ListNode* head) {
        ListNode* current = head;
        int length = 0;
        while(current){
            length++;
            current = current->next;
        }
        int halfLen = 0;
        if(isEven(length)){
           halfLen = length / 2;
        }
        else{
            halfLen = length / 2 + 1;
        }
        current = head;
        while(halfLen){
            halfLen--;
            current = current->next;
        }
        current = reverseList(current);
        while(current){
            if(current->val != head->val){
                return false;
            }
            current = current->next;
            head = head->next;
        }
        return true;
    }

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

    inline bool isEven(int num){
        return (num >> 1)<<1 == num;
    }
};