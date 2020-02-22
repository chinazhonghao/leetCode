class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int result = 0;
        for(int i=0; i<length; i++){
        	for(int j=i+1; j<length; j++){
        		int target = nums[i] + nums[j];
        		int index = _binarySearch(nums, j+1, length-1, target);
        		result += (index - j - 1);
        	}
        }
        return result;
    }

    private int _binarySearch(int[] nums, int l, int r, int target){
    	while(l<=r && r<nums.length){
    		int mid = (l+r)>>1;
    		if(nums[mid] >= target){
    			r = mid-1;
    		}
    		else {
    			l = mid + 1;
    		}
    	}
    	return l;
    }
}