class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = (l+r)>>1;
            int me = nums[mid];
            int cr = nums[r];
            int cl = nums[l];
            if(me == target){
                return true;
            }
            if(cl == me && cr == me){
                l++; r--;
            }
            else if(cl <= me){
                if(target>=cl && target<=me){
                    r = mid - 1;
                }
                else {
                    l = mid+1;
                }
            }
            else {
                if(target>=me && target<=cr){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
            }
        }
        return false;
    }
}