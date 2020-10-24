class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] seq = new int[len];
        int size = 0;
        for(int i=0; i<len; i++){
            int index = findIndex(seq, size, nums[i]);
            if(index == size){
                size++;
            }
            seq[index] = nums[i];
        }
        return size;
    }

    public int findIndex(int[] seq, int size, int t){
        if(size == 0){
            return 0;
        }
        int l=0, r=size-1;
        while(l+1<r){
            int m = (l+r) >> 1;
            if(seq[m] == t){
                return m;
            }
            else if(seq[m]>t){
                r = m-1;
            }
            else {
                l = m;
            }
        }
        if(seq[r] < t){
            return r+1;
        }
        if(seq[l] < t){
            return l+1;
        }
        return 0;
    }
}