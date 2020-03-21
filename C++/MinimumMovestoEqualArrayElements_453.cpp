class Solution {
public:
    int minMoves(vector<int>& nums) {
        int length = nums.size();
        long sum = 0;
        for(int i=0; i<length; i++){
            sum += nums[i];
        }
        long minNum = nums[0];
        for(int i=1; i<length; i++){
            if(nums[i] < minNum){
                minNum = nums[i];
            }
        }
        return sum - minNum*length;
    }
};