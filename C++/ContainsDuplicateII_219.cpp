class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        int length = nums.size();
        for(int i=1; i<=k; i++){
            for(int j=0; j<length-i; j++){
                if(nums[j] == nums[j+i]){
                    return true;
                }
            }
        }
        return false;
    }
};