class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        int l=0, r=0;
        int current = 1;
        if(k == 1){
        	return 0;
        }
        for(; r<nums.length; r++){
        	current = current * nums[r];
        	while(current >= k){
        		current /= nums[l++];
        	}
        	result += r - l + 1;
        }
        return result;
    }
}