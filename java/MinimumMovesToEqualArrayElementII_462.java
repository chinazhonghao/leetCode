class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        long count = Integer.MAX_VALUE;
        for(int k=0; k<=nums.length; k++){
            long diff = _value(nums, k);
            long dk = 2 * k - nums.length;
            int x, max;
            if(k > 0){
                x = nums[k-1];
            }
            else {
                x = nums[k];
            }
            if(k<nums.length){
                max = nums[k];
            }
            else {
                max = nums[k-1];
            }
            for(; x<=max; x++){
                count = Math.min(count, diff + dk * x);
            }
        }
        return (int)count;
    }

    public long _value(int[] nums, int k){
        long sum1 = 0, sum2 = 0;
        for(int i=0; i<k; i++){
            sum1 += nums[i];
        }
        for(int i=k; i<nums.length; i++){
            sum2 += nums[i];
        }
        return sum2 - sum1;
    }
}