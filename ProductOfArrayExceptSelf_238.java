class Solution {
    public int[] productExceptSelf(int[] nums) {
    	int length = nums.length;
        int[] result = new int[length];
        for(int i=0; i<nums.length; i++){
        	result[i] = 1;
        }

        for(int i=1; i<nums.length; i++){
        	result[i] = result[i-1] * nums[i-1];
        }

        int r = 1;
        for(int i=length-2; i>=0; i--){
        	r = r * nums[i];
        	result[i] *= r;
        }
        return result;
    }
}