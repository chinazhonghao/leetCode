class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        for(int i=1; i<A.length; i++){
        	A[i] += A[i-1];
        }
        int result = A[L+M-1];
        int lmax = A[L-1];
        int mmax = A[M-1];
        for(int i=L+M; i<A.length; i++){
        	lmax = Math.max(lmax, A[i-M]-A[i-L-M]);
        	mmax = Math.max(mmax, A[i-L]-A[i-L-M]);
        	result = Math.max(result, lmax + A[i]-A[i-M]);
        	result = Math.max(result, mmax + A[i]-A[i-L]);
        }
        return result;
    }
}