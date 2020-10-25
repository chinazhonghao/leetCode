class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int len = nums.length;
        int counts = l.length;
        List<Boolean> result = new ArrayList<>();
        for(int i=0; i<counts; i++){
            result.add(_isOk(nums, l[i], r[i]));
        }
        return result;
    }

    private boolean _isOk(int[] nums, int l, int r){
        int[] copy = new int[r-l+1];
        for(int i=l; i<=r; i++){
            copy[i-l] = nums[i];
        }
        Arrays.sort(copy);
        int d = copy[1] - copy[0];
        for(int i=1; i<r-l; i++){
            int d2 = copy[i+1] - copy[i];
            if(d2 != d){
                return false;
            }
        }
        return true;
    }
}