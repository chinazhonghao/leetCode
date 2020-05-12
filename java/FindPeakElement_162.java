class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        int pre = nums[0] - 1;
        int next = nums[1];
        int min = nums[nums.length-1]-1;
        for(int i=0; i<nums.length; i++){
            if(i < nums.length-1){
                next = nums[i+1];
            }
            else {
                next = min;
            }
            if(nums[i] > pre && nums[i] > next){
                return i;
            }
            pre = nums[i];
        }
        return -1;
    }
}