class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        if(k < 0){
            return 0;
        }
        map<int, int> record;
        int length = nums.size();
        for(int i=0; i<length; i++){
            int currentValue = nums[i];
            for(int j=i+1; j<length; j++){
                if(currentValue - nums[j] == k){
                    record.insert(pair<int, int>(nums[j], currentValue));
                }
                else if(nums[j] - currentValue == k){
                    record.insert(pair<int, int>(currentValue, nums[j]));
                }
            }
        }
        return record.size();
    }
};