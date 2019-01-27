class Solution {
public:
    int numMagicSquaresInside(vector<vector<int>>& grid) {
        int row = grid.size();
        int col = grid[0].size();
        int count = 0;
        for(int i=1; i<row-1; i++){
            for(int j=1; j<col-1; j++){
                int center = grid[i][j];
                if(center == 5){
                    if(isMagicSquare(grid, i, j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    bool containsAll(vector<vector<int>>& grid, int row, int col){
        bool isIn[10];
        for(int i=0; i<10; i++){
            isIn[i] = false;
        }
        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                int current = grid[row+i][col+j];
                if(current<1 || current>9 || isIn[current]){
                    return false;
                }
                else{
                    isIn[current] = true;
                }
            }
        }
        return true;
    }

    bool isMagicSquare(vector<vector<int>>& grid, int row, int col){
        if(!containsAll(grid, row, col)){
            return false;
        }
        int sum = 0;
        for(int i=-1; i<=1; i++){
            if(grid[row+i][col-1]+grid[row+i][col]+grid[row+i][col+1] == 15){
                continue;
            }
            return false;
        }

        for(int i=-1; i<=1; i++){
            if(grid[row-1][col+i]+grid[row][col+i]+grid[row+1][col+i] == 15){
                continue;
            }
            return false;
        }

        if(grid[row-1][col-1]+grid[row+1][col+1]!= 10 || grid[row-1][col+1]+grid[row+1][col-1]!=10){
            return false;
        }
        return true;
    }
};