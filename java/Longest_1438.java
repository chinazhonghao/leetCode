class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int result = 1;
        int left = 0;
        int max = nums[0];
        int min = nums[0];
        int i=1;
        for(; i<nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            if(max - min > limit){
                result = Math.max(result, i - left);
                for(int j=i-1; j>=left; j--){
                    if(Math.abs(nums[j] - nums[i]) > limit){
                        left = j + 1;
                        break;
                    }
                }
            }
        }
        result = Math.max(result, i - left);
        return result;
    }
}