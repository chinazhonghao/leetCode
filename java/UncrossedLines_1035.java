class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
    	int[][] m = new int[A.length][B.length];
    	for(int i=0; i<A.length; i++){
    		for(int j=0; j<B.length; j++){
    			m[i][j] = -1;
    		}
    	}
        return _solve(A, B, 0, 0, m);
    }

    private int _solve(int[] A, int[] B, int startA, int startB, int[][] m){
    	if(startA >= A.length || startB >= B.length){
    		return 0;
    	}
    	if(m[startA][startB] != -1){
    		return m[startA][startB];
    	}
    	int result = 0;
    	if(A[startA] == B[startB]){
    		result = Math.max(result, 1 + _solve(A, B, startA+1, startB+1, m));
    	}
    	else {
    		result = Math.max(result, _solve(A, B, startA+1, startB, m));
    		result = Math.max(result, _solve(A, B, startA, startB+1, m));
    	}
    	m[startA][startB] = result;
    	return result;
    }
}