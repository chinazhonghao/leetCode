
class Solution {
    public int nthUglyNumber(int n){
        int val2 = 2;
        int val3 = 3;
        int val5 = 5;
        int[] nums = new int[n];
        nums[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for(int i=1; i<n; i++){
            int val = Math.min(val2, Math.min(val3, val5));
            nums[i] = val;
            if(val == val2) {
                index2 += 1;
                val2 = nums[index2] * 2;
            }
            if(val == val3){
                index3 += 1;
                val3 = nums[index3] * 3;
            }
            if(val == val5) {
                index5 += 1;
                val5 = nums[index5] * 5;
            }
        }
        return nums[n-1];
    }
}