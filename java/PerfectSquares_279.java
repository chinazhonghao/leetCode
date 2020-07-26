class Solution {
    private int[] nums;
    public int numSquares(int n) {
        int base = (int)Math.sqrt(n);
        nums = new int[base];
        for(int i=base; i>0; i--){
            nums[i-1] = i*i;
        }
        int count = 1;
        while(true){
            if(_recursive(n, count)){
                return count;
            }
            count++;
        }
    }

    private boolean _recursive(int n, int count){
        if(n == 0){
            return true;
        }
        else if(count == 0){
            return false;
        }
        int base = (int)Math.sqrt(n);
        count--;
        for(; base>0; base--){
            int left = n - nums[base-1];
            if(_recursive(left, count)){
                return true;
            }
        }
        return false;
    }
}