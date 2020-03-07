class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length-1;
        if(row < 0){
        	return result;
        }
        int col = matrix[0].length-1;
        int limit = Math.min(row, col) >> 1;
        for(int i=0; i<=limit; i++){
        	int m = row - i;
        	int n = col - i;
        	if(i==m){
        		for(int k=i; k<=n; k++){
        			result.add(matrix[i][k]);
        		}
        		continue;
        	}
        	else if(i==n){
        		for(int k=i; k<=m; k++){
        			result.add(matrix[k][i]);
        		}
        		continue;
        	}
        	for(int k=i; k<n; k++){
        		result.add(matrix[i][k]);
        	}
        	for(int k=i; k<m; k++){
        		result.add(matrix[k][n]);
        	}
        	for(int k=n; k>i; k--){
        		result.add(matrix[m][k]);
        	}
        	for(int k=m; k>i; k--){
        		result.add(matrix[k][i]);
        	}
        }
        return result;
    }
}