class Solution {
public:
    int search(vector<int>& nums, int target) {
        int length = nums.size();
        int left = 0;
        int right = length-1;
        int mid;
        while(1){
            if(nums[left]==target){
                return left;
            }

            if(nums[right]==target){
                return right;
            }

            mid = (left + right) >> 1;
            if(mid == left){
                break;
            }
            if(nums[mid] > target){
                right = mid;
            }
            else if(nums[mid] < target){
                left = mid;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
};