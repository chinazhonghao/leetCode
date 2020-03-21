class Solution {
    public int search(int[] nums, int target) {
    	int length = nums.length;
    	if(length < 1){
    		return -1;
    	}
    	if(length < 2){
    		if(nums[0] == target){
    			return 0;
    		}
    		return -1;
    	}
        int left = 0, right = length-1;
        int mid = 0;
        if(nums[0] > nums[length-1]){
        	while(left < right){
	        	mid = (left + right) >> 1;
	        	if(nums[mid] > nums[left]){
	        		left = mid;
	        	}
	        	else {
	        		right = mid;
	        	}
	        }
	        left = 0;
	        right = length-1;
	        if(mid == 0){
	        	mid = 1;
	        }
	        if(nums[mid] > nums[left]){
	        	mid = mid+1;
	        }
	        if(nums[right] >= target){
	        	left = mid;
	        }
	        else {
	        	right = mid-1;
	        }
        }
        while(left <= right){
        	mid = (left + right) >> 1;
        	if(nums[mid] < target){
        		left = mid+1;
        	}
        	else if(nums[mid] == target){
        		return mid;
        	}
        	else {
        		right = mid-1;
        	}
        }
        return -1;
    }
}