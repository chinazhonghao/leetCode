class Solution {
public:
    int surfaceArea(vector<vector<int>>& grid) {
         int row = grid.size();
         int col = grid[0].size();
         int area = 0;
         for(int i=0; i<row; i++){
             for(int j=0; j<col; j++){
                 int height = grid[i][j];
                 if(height == 0){
                     continue;
                 }
                 area += (6*height - (height - 1)*2);
                 if(i > 0){
                     area -= min(grid[i][j],grid[i-1][j]);
                 }
                 if(i<row-1){
                     area -= min(grid[i][j],grid[i+1][j]);
                 }
                 if(j>0){
                     area -= min(grid[i][j],grid[i][j-1]);
                 }
                 if(j<col-1){
                     area -= min(grid[i][j],grid[i][j+1]);
                 }
             }
         }
         return area;
    }
};