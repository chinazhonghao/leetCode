import java.util.Arrays;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1){
            return 1;
        }
        int[] nums = Arrays.copyOf(primes, primes.length);
        int[] result = new int[n];
        int[] indexs = new int[primes.length];
        result[0] = 1;
        for(int i=1; i<n; i++){
            int value = _minNum(nums);
            result[i] = value;
            for(int j=0; j<primes.length; j++){
                if(nums[j] == value){
                    indexs[j]++;
                    nums[j] = result[indexs[j]] * primes[j];
                }
            }
        }
        return result[n-1];
    }

    private int _minNum(int[] nums){
        int value = nums[0];
        for(int i=1; i<nums.length; i++){
            value = Math.min(value, nums[i]);
        }
        return value;
    }
}