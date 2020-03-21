class MyStack {
public:
    /** Initialize your data structure here. */
    MyStack() {

    }

    /** Push element x onto stack. */
    void push(int x) {
        data.push(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    int pop() {
        int value = data.back();
        queue<int> copy;
        int size = data.size()-1;
        while(size>0){
            copy.push(data.front());
            data.pop();
            size--;
        }
        if(!data.empty()){
            data.pop();
        }
        size = copy.size();
        while(size > 0){
            data.push(copy.front());
            copy.pop();
            size--;
        }
        return value;
    }

    /** Get the top element. */
    int top() {
        return data.back();
    }

    /** Returns whether the stack is empty. */
    bool empty() {
        return data.empty();
    }

private:
    queue<int> data;
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */