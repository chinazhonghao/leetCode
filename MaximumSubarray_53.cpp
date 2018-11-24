class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int maxSum = 0;
        int sum = 0;
        int head = 0;
        int tail = 0;
        int len = nums.size();
        if(len > 0){
            maxSum = nums.at(0);
        }
        for(tail = 0; tail < len; tail++){
            if(sum >= 0){
                sum += nums.at(tail);
            }
            else{
                sum = nums.at(tail);
                head = tail;
            }

            if(sum > maxSum){
                maxSum = sum;
            }
            cout<<"head: "<<head<<", tail: "<<tail<<", sum: "<<sum<<", maxSum: "<<maxSum<<endl;
        }
        return maxSum;
    }
};