class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] m = new int[A.length+1][B.length+1];
        int result = 0;
        for(int i=A.length-1; i>=0; i--){
        	for(int j=B.length-1; j>=0; j--){
        		if(A[i] == B[j]){
        			m[i][j] = m[i+1][j+1] + 1;
        			result = Math.max(result, m[i][j]);
        		}
        	}
        }
        return result;
    }
}