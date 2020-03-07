class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int start = 1;
        int limit = (n-1) >> 1;
        for(int i=0; i<=limit; i++){
        	int m = n-1-i;
        	if(i==m){
        		result[i][i] = start++;
        		continue;
        	}
        	for(int k=i; k<m; k++){
        		result[i][k] = start++;
        	}
        	for(int k=i; k<m; k++){
        		result[k][m] = start++;
        	}
        	for(int k=m; k>i; k--){
        		result[m][k] = start++;
        	}
        	for(int k=m; k>i; k--){
        		result[k][i] = start++;
        	}
        }
        return result;
    }
}