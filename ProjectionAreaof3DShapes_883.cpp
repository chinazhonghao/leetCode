class Solution {
public:
    int projectionArea(vector<vector<int>>& grid) {
        int row = grid.size();
        int col = grid[0].size();
        int area = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] != 0){
                    area++;
                }
            }
        }
        for(int i=0; i<row; i++){
            area += findMax((grid[i]));
        }
        for(int j=0; j<col; j++){
            int maxX = 0;
            for(int i=0; i<row; i++){
                if(grid[i][j] > maxX){
                    maxX = grid[i][j];
                }
            }
            area += maxX;
        }
        return area;
    }

    inline int findMax(vector<int>& num){
        int maxNum = num[0];
        int length = num.size();
        for(int i=1; i<length; i++){
            if(num[i] > maxNum){
                maxNum = num[i];
            }
        }
        return maxNum;
    }
};