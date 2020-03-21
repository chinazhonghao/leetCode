class MyLinkedList {
public:
    /** Initialize your data structure here. */
    MyLinkedList() {
        head = NULL;
        tail = NULL;
        count = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    int get(int index) {
        if(!count || index >= count){
            return -1;
        }
        LinkedNode* current = head;
        while(index){
            index--;
            current = current->next;
        }
        return current->val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    void addAtHead(int val) {
        LinkedNode* current = new LinkedNode();
        current->val = val;
        current->next = head;
        current->prev = NULL;
        if(head){
            head->prev = current;
        }
        head = current;
        if(!tail){
            tail = current;
        }
        count++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    void addAtTail(int val) {
        LinkedNode* current = new LinkedNode();
        current->val = val;
        current->prev = tail;
        current->next = NULL;
        if(tail){
            tail->next = current;
        }
        tail = current;
        if(!head){
            head = current;
        }
        count++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    void addAtIndex(int index, int val) {
        if(index > count){
            return;
        }
        if(index == count){
            addAtTail(val);
            return;
        }
        else if(index==0){
            addAtHead(val);
            return;
        }
        LinkedNode* current = head;
        while(index){
            index--;
            current = current->next;
        }
        cout<<count<<endl;
        LinkedNode* newNode = new LinkedNode();
        newNode->val = val;
        newNode->prev = current->prev;
        newNode->next = current;
        current->prev->next = newNode;
        current->prev = newNode;
        count++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    void deleteAtIndex(int index) {
        if(index >= count || !count){
            return;
        }
        if(index==0){
            head = head->next;
            delete head->prev;
            head->prev = NULL;
            count--;
            return;
        }
        else if(index==count-1){
            tail = tail->prev;
            delete tail->next;
            tail->next = NULL;
            count--;
            return;
        }
        LinkedNode* current = head;
        while(index){
            index--;
            current = current->next;
        }
        current->prev->next = current->next;
        current->next->prev = current->prev;
        count--;
    }

private:
    typedef struct LinkedNode {
        int val;
        struct LinkedNode* next;
        struct LinkedNode* prev;
    }LinkedNode;

    LinkedNode* head;
    LinkedNode* tail;
    int count;
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList* obj = new MyLinkedList();
 * int param_1 = obj->get(index);
 * obj->addAtHead(val);
 * obj->addAtTail(val);
 * obj->addAtIndex(index,val);
 * obj->deleteAtIndex(index);
 */