class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int base = 0;
        int sum = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum >= s){
                if(count == 0){
                    count = i - base + 1;
                }
                else {
                    count = Math.min(count, i-base+1);
                }
                while(sum >= s){
                    sum -= nums[base++];
                    if(sum >= s){
                        count = Math.min(count, i-base+1);
                    }
                }
            }
        }
        return count;
    }
}