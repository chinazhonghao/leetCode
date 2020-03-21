class Solution {
    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int maxK = Math.max(row, col);
        int[][] sum = new int[row+1][col+1];
        for(int i=1; i<=row; i++){
        	for(int j=1; j<=col; j++){
        		sum[i][j] = matrix[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
        	}
        }

        int result = 0;
        for(int i=1; i<=row; i++){
        	for(int j=1; j<=col; j++){
        		for(int k=0; k<=maxK; k++){
        			int baseI = i - k, baseJ = j - k;
        			if(baseI < 1 || baseJ < 1){
        				continue;
        			}
        			int val = sum[i][j] - sum[baseI-1][j] - sum[i][baseJ-1] + sum[baseI-1][baseJ-1];
        			if(val == (k+1)*(k+1)){
        				result++;
        			}
        		}
        	}
        }
        return result;
    }
}