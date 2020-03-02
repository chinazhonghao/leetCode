class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int length = nums.length;
        int closest = 0;
        for(int i=0; i<length; i++){
        	int j=i+1;
        	int k = length-1;
        	while(k > j){
        		int sum = nums[i] + nums[j] + nums[k];
        		int diff = Math.abs(sum - target);
        		if(diff < result){
        			result = diff;
        			closest = sum;
        		}
        		if(sum > target){
        			k--;
        		}
        		else {
        			j++;
        		}
        	}
        }
        return closest;
    }
}