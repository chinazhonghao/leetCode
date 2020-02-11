class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int result = Integer.MIN_VALUE;
        int current = 0;
        int length = A.length;
        int left = 0, right = -1;
        while(right < 2 * length){
        	if(right - left + 1 > length){
        		current -= A[left];
        		if(current <= 0){
        			current = 0;
        			left = right;
        		}
        		else {
        			left++;
        		}
        	}
        	int pos = right + 1;
        	if(pos >= length){
        		pos -= length;
        	}
        	current += A[pos];
        	result = Math.max(result, current);
        	if(current <= 0){
        		left = ++right;
        	}
        }
        return result;
    }
}