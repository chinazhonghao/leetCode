class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int length = nums.size();
        int res = 0;
        for(int i=0; i<length; i++){
        	res = res ^ nums[i];
        }
        return res;
    }
};