class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int length = nums.size();
        int pivot = -1;
        int numsSum = 0;
        for(int i=0; i<length; i++){
            numsSum += nums[i];
        }

        int leftSum = 0;
        for(int i=0; i<length; i++){
            if(leftSum == (numsSum - leftSum - nums[i])){
                pivot = i;
                break;
            }
            leftSum += nums[i];
        }
        return pivot;
    }
};