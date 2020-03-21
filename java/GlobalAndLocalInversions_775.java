class Solution {
    public boolean isIdealPermutation(int[] A) {
        int length = A.length;
        if(length <= 2){
        	return true;
        }
        int min = A[length-1];
        for(int i=length-3; i>=0; i--){
        	if(A[i] > min){
        		return false;
        	}
        	min = Math.min(min, A[i+1]);
        }
        return true;
    }
}