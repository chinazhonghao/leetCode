class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int length = nums.length;
        if(length == 0){
            return  false;
        }
        else if(k==0){
            for(int i=0; i<length-1; i++){
                if(nums[i] == 0 && nums[i+1]==0){
                    return true;
                }
            }
            return false;
        }
        int[] sums = new int[length];
        Map<Integer, Integer> m = new HashMap<>();
        sums[0] = nums[0];
        for(int i=1; i<length; i++){
            sums[i] = nums[i] + sums[i-1];
        }

        for(int i=0; i<length; i++){
            sums[i] %= k;
            if(sums[i] == 0 & i > 0){
                return true;
            }
            else {
                if(m.containsKey(sums[i])){
                    int index = m.get(sums[i]);
                    if(i - index > 1){
                        return true;
                    }
                }
                else {
                    m.put(sums[i], i);
                }
            }
        }
        return false;
    }
}