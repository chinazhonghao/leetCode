class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int positive = 1;
        int negative = 1;
        int result = 0;
        for(int i=0; i<nums.length; i++){
            int tmpPos, tmpNeg;
            if(nums[i] > 0){
                tmpPos = Math.max(positive * nums[i], nums[i]);
                tmpNeg = Math.min(negative * nums[i], nums[i]);
                positive = tmpPos;
                negative = tmpNeg;
            }
            else if(nums[i] < 0){
                tmpPos = Math.max(negative * nums[i], nums[i]);
                tmpNeg = Math.min(positive * nums[i], nums[i]);
                positive = tmpPos;
                negative = tmpNeg;
            }
            else {
                negative = 0;
                positive = 0;
            }
            result = Math.max(result, positive);
        }
        return result;
    }
}