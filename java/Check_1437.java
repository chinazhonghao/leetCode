class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int last = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                last = i;
                break;
            }
        }
        if(last == -1){
            return true;
        }
        for(int i=last+1; i<nums.length; i++){
            if(nums[i] > 0){
                if(i - last - 1 < k){
                    return false;
                }
                last = i;
            }
        }
        return true;
    }
}