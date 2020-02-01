class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] sum = new int[row+1][col+1];
        for(int i=1; i<=row; i++){
        	for(int j=1; j<=col; j++){
        		sum[i][j] = mat[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
        	}
        }

        int ans = 0;
        for(int i=1; i<=row; i++){
        	for(int j=1; j<=col; j++){
        		for(int k=0; k<=Math.min(row, col); k++){
        			int r1 = i - k, c1 = j - k;
        			int r = i, c = j;
        			if(r1 < 1 || c1 < 1){
        				continue;
        			}
        			int val = sum[r][c] - sum[r1-1][c] - sum[r][c1-1] + sum[r1-1][c1-1];
        			if(val <= threshold){
        				ans = Math.max(ans, k+1);
        			}
        		}
        	}
        }
        return ans;
    }
}