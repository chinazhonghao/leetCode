class Solution {
    public int getMaxLen(int[] nums) {
        int result = 0;
        int length = nums.length;
        int start=-1, end=-1;
        for(int i=0; i<length; i++){
            if(nums[i]>0){
                nums[i] = 1;
            }
            else if(nums[i] < 0){
                nums[i] = -1;
            }
        }
        int[] muls = new int[length];
        muls[0] = nums[0];
        for(int i=0; i<length-1; i++){
            if(muls[i] == 0){
                muls[i+1] = nums[i+1];
            }
            else {
                muls[i+1] = muls[i] * nums[i+1];
            }
        }
        int zeroIndex = -1;
        for(int i=0; i<length; i++){
            System.out.println(muls[i]);
            if (muls[i] > 0) {
                result = Math.max(result, i - zeroIndex);
            }
            else if(muls[i] == 0){
                zeroIndex = i;
            }
        }
        for(int i=0; i<length; i++){
            if(muls[i] == 0){
                if(start != -1 && end != -1){
                    result = Math.max(result, end - start);
                }
                start = -1;
                end = -1;
            }
            else if(muls[i] < 0){
                if(start == -1){
                    start = i;
                }
                else {
                    end = i;
                }
            }
        }
        if(start != -1 && end != -1){
            result = Math.max(result, end - start);
        }
        return result;
    }
}