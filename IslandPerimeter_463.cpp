class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int perimeter = 0;
        int row = grid.size();
        int col = grid[0].size();
        for(int i=0; i<row; i++){
        	for(int j=0; j<col; j++){
        		if(grid[i][j] == 1){
        			if(i > 0){
        				if(grid[i-1][j] == 0){
        					perimeter++;
        				}
        			}
        			else{
        				perimeter++;
        			}
        			if(i < row-1){
        				if(grid[i+1][j] == 0){
        					perimeter++;
        				}
        			}
        			else{
        				perimeter++;
        			}
        			if(j>0){
        				if(grid[i][j-1]==0){
        					perimeter++;
        				}
        			}
        			else{
        				perimeter++;
        			}
        			if(j<col-1){
        				if(grid[i][j+1]==0){
        					perimeter++;
        				}
        			}
        			else{
        				perimeter++;
        			}
        		}
        	}
        }
        return perimeter;
    }
};