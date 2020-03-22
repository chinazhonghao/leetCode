class Solution {
    public int removeDuplicates(int[] nums) {
    	int length = nums.length;
    	if(length < 1){
    		return 0;
    	}
        int left=1, count=1, current=nums[0];
        for(int i=1; i<length; i++){
        	if(nums[i] == current){
        		count++;
        	}
        	else {
        		current = nums[i];
        		count = 1;
        	}
        	if(count <= 2) {
        		if(i != left){
	        		nums[left] = nums[i];
	        	}
	        	left++;
        	}
        }
        return left;
    }
}