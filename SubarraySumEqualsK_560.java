class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int[] sums = new int[nums.length+1];
        for(int i=0; i<nums.length; i++){
        	sums[i+1] = sums[i] + nums[i]; 
        }
        for(int i=0; i<nums.length; i++){
        	for(int j=i+1; j<=nums.length; j++){
        		if(sums[j] - sums[i] == k){
        			result++;
        		}
        	}
        }
        return result;
    }
}