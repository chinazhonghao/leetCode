class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        int sum = 0;
        for(int i=0; i<m; i++){
        	for(int j=0; j<n; j++){
        		row[i] += grid[i][j];
        	}
        	if(row[i] > 1){
        		sum += row[i];
        	}
        }

        for(int j=0; j<n; j++){
        	for(int i=0; i<m; i++){
        		col[j] += grid[i][j];
        	}
        	if(col[j] > 1){
        		sum += col[j];
        	}
        }

        for(int i=0; i<m; i++){
        	if(row[i] < 2){
        		continue;
        	}
        	for(int j=0; j<n; j++){
        		if(col[j] < 2){
        			continue;
        		}
        		if(grid[i][j] > 0){
        			sum--;
        		}
        	}
        }
        return sum;
    }
}