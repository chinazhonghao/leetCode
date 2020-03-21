class Solution {
public:
    int dominantIndex(vector<int>& nums) {
        int length = nums.size();
        if(length < 2){
            return 0;
        }
        int maxNum;
        int secNum;
        int maxIndex;
        if(nums[1] > nums[0]) {
            maxNum = nums[1];
            secNum = nums[0];
            maxIndex = 1;
        }
        else{
            maxNum = nums[0];
            secNum = nums[1];
            maxIndex = 0;
        }
        
        for(int i=2; i<length; i++){
            if(nums[i] > maxNum)
            {
                secNum = maxNum;
                maxNum = nums[i];
                maxIndex = i;
            }
            else if(nums[i] > secNum){
                secNum = nums[i];
            }
        }

        return (maxNum >= 2*secNum ? maxIndex : -1);
    }
};