class Solution {
    public int maxWidthRamp(int[] A) {
    	int N = A.length;
    	Integer[] B = new Integer[N];
    	for(int i=0; i<N; i++){
    		B[i] = i;
    	}
    	Arrays.sort(B, (i, j) -> A[i] - A[j]);
    	int result = 0;
    	int m = N;
    	for(int i=0; i<N; i++){
    		result = Math.max(result, B[i] - m);
    		m = Math.min(m, B[i]);
    	}
    	return result;
    }
}