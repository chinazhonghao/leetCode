class Solution {
    public int[] searchRange(int[] nums, int target) {
    	int[] pos = {-1, -1};
    	if(nums.length < 1){
    		return pos;
    	}
        int left = 0, right = nums.length-1;
        int mid = -1;
        while(left <= right){
        	mid = (left + right) >> 1;
        	if(nums[mid] == target){
        		break;
        	}
        	else if(nums[mid] < target){
        		left = mid+1;
        	}
        	else {
        		right = mid-1;
        	}
        }
        if(nums[mid] != target){
        	return pos;
        }
        int m = -1;
        while(left < mid){
        	if(nums[left] == target){
        		break;
        	}
        	m = (left + mid) >> 1;
        	if(m == mid){
        		left++;
        	}
        	if(nums[m] == target){
        		mid = m;
        	}
        	else {
        		left = m+1;
        	}
        }
        while(mid < right){
        	if(nums[right] == target){
        		break;
        	}
        	m = (right + mid) >> 1;
        	if(m == mid){
        		right--;
        	}
        	if(nums[m] == target){
        		mid = m;
        	}
        	else {
        		right = m-1;
        	}
        }
        pos[0] = left;
        pos[1] = right;
        return pos;
    }
}