class Solution {
public:
    bool isToeplitzMatrix(vector<vector<int>>& matrix) {
        int row = matrix.size();
        if(row < 1){
            return true;
        }

        int col = matrix[0].size();
        if(col < 1){
            return true;
        }

        for(int i=1; i<row; i++){
            vector<int>& lastColumn = matrix[i-1];
            vector<int>& currentColumn = matrix[i];
            for(int j=1; j<col; j++){
                if(currentColumn[j] != lastColumn[j-1]){
                    return false;
                }
            }
        }
        return true;
    }
};