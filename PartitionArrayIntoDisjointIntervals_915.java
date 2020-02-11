class Solution {
    public int partitionDisjoint(int[] A) {
        int length = A.length;
        int[] M = new int[length];
        int[] N = new int[length];
        int left = A[0];
        for(int i=0; i<length; i++){
        	left = Math.max(left, A[i]);
        	M[i] = left;
        }

        int right = A[length-1];
        for(int j=length-1; j>=0; j--){
        	right = Math.min(right, A[j]);
        	N[j] = right;
        }

        for(int i=1; i<length; i++){
        	if(M[i-1] <= N[i]){
        		return i;
        	}
        }
        return -1;
    }
}