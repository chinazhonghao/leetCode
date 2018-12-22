class Solution {
public:
    int arrayPairSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int length = nums.size() / 2;
        int res= 0;
        for(int i=0; i<length; i++){
            res += nums[2*i];
        }
        return res;
    }
};