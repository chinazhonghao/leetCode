class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int col=0; col<n; col++){
        	int count = Math.min(m, n-col);
        	for(int i=0; i<count; i++){
        		for(int j=0; j<count-i-1; j++){
        			if(mat[j][j+col] > mat[j+1][j+col+1]){
        				int tmp = mat[j][j+col];
        				mat[j][j+col] = mat[j+1][j+col+1];
        				mat[j+1][j+col+1] = tmp;
        			}
        		}
        	}
        }

        for(int row=1; row<m; row++){
        	int count = Math.min(n, m-row);
        	for(int i=0; i<count; i++){
        		for(int j=0; j<count-i-1; j++){
        			if(mat[j+row][j] > mat[j+row+1][j+1]){
        				int tmp = mat[j+row][j];
        				mat[j+row][j] = mat[j+row+1][j+1];
        				mat[j+row+1][j+1] = tmp;
        			}
        		}
        	}
        }
        return mat;
    }
}