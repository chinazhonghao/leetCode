class KthLargest {
public:
    KthLargest(int k, vector<int>& nums) {
        heap.resize(k);
        build_heap(nums);
    }

    int add(int val) {
        if(val > heap[0]){
            heap[0] = val;
            heapify(0);
        }
        return heap[0];
    }

private:
    void build_heap(vector<int>& nums){
        int heap_length = heap.size();
        int length = nums.size();
        int len = heap_length < length?heap_length:length;
        for(int i=0; i<len; i++){
            heap[i] = nums[i];
        }
        for(int i=len; i<heap_length; i++){
            heap[i] = INT_MIN;
        }
        int start = (heap_length - 2) >> 1;
        for(int i=start; i>=0; i--){
            heapify(i);
        }
        for(int i=heap_length; i<length; i++){
            if(heap[0] < nums[i]){
                heap[0] = nums[i];
                heapify(0);
            }
        }
    }

    void heapify(int start){
        int base_index = start<<1;
        int left = base_index+1;
        int right = base_index+2;
        int length = heap.size();
        if(left>=length){
            return;
        }
        if(right >= length){
            if(heap[left] < heap[start]){
                int tmp = heap[start];
                heap[start] = heap[left];
                heap[left] = tmp;
                heapify(left);
            }
            return;
        }
        if(heap[left]<heap[right]){
            if(heap[left] < heap[start]){
                int tmp = heap[start];
                heap[start] = heap[left];
                heap[left] = tmp;
                heapify(left);
            }
        }
        else{
            if(heap[right] < heap[start]){
                int tmp = heap[start];
                heap[start] = heap[right];
                heap[right] = tmp;
                heapify(right);
            }
        }
    }

    vector<int> heap;
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */