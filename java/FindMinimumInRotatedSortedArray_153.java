class Solution {
    public int findMin(int[] nums) {
        int left=0, right=nums.length-1;
        int mid = 0;
        while(left < right){
            if(right-left<2){
                mid = nums[right] > nums[left]?left:right;
                break;
            }
            mid = (left + right) >> 1;
            if(nums[mid] > nums[left] && nums[mid] > nums[right]){
                left = mid+1;
                mid = left;
            }
            else if(nums[mid] < nums[left] && nums[mid] < nums[right]){
                right = mid;
                left++;
            }
            else if(nums[mid] > nums[left] && nums[mid] < nums[right]){
                mid = left;
                break;
            }
        }
        return nums[mid];
    }
}