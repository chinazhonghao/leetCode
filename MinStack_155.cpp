class MinStack {
public:
    /** initialize your data structure here. */
    MinStack() {
        minValue = INT_MAX;
    }

    void push(int x) {
        if(minValue > x){
            minValue = x;
        }
        data.push(x);
    }

    void pop() {
        int value = data.top();
        data.pop();
        if(value == minValue){
            minValue = INT_MAX;
            stack<int> copy;
            while(!data.empty()){
                value = data.top();
                if(value < minValue){
                    minValue = value;
                }
                copy.push(value);
                data.pop();
            }
            while(!copy.empty()){
                data.push(copy.top());
                copy.pop();
            }
        }
    }

    int top() {
        return data.top();
    }

    int getMin() {
        return minValue;
    }

private:
    stack<int> data;
    int minValue;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */