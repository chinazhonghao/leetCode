class Solution {
    public int maxAreaOfIsland(int[][] grid) {
    	int row = grid.length;
    	int col = grid[0].length;
        boolean[][] flag = new boolean[row][col];
        int result = 0;
        int[][] direct = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
        for(int i=0; i<row; i++){
        	for(int j=0; j<col; j++){
        		if(flag[i][j] || grid[i][j] < 1){
        			continue;
        		}
        		Stack<int[]> s = new Stack<>();
        		int area = 0;
        		s.push(new int[] {i, j});
        		flag[i][j] = true;
        		while(!s.empty()){
        			int[] current = s.pop();
        			area++;
        			for(int k=0; k<4; k++){
        				int[] d = direct[k];
        				int px = current[0]+d[0];
        				int py = current[1]+d[1];
        				if(px >= 0 && px < row && py >=0 && py < col){
        					if(!flag[px][py] && grid[px][py]>0){
        						s.push(new int[]{px, py});
        						flag[px][py] = true;
        					}
        				}
        			}
        		}
        		result = Math.max(result, area);
        	}
        }
        return result;
    }
}