class Solution {
public:
    vector<vector<int>> imageSmoother(vector<vector<int>>& M) {
        int row = M.size();
        int col = M[0].size();
        vector<vector<int>> result;
        for(int i=0; i<row; i++){
            vector<int> res_row;
            for(int j=0; j<col; j++){
                int nums = M[i][j];
                int count = 1;
                if(i>0){
                    if(j>0){
                        nums += M[i-1][j-1];
                        count++;
                    }
                    nums += M[i-1][j];
                    count++;
                    if(j<col-1){
                        nums += M[i-1][j+1];
                        count++;
                    }
                }
                
                if(j>0){
                    nums += M[i][j-1];
                    count++;
                }

                if(j<col-1){
                    nums += M[i][j+1];
                    count++;
                }

                if(i<row-1){
                    if(j>0){
                        nums += M[i+1][j-1];
                        count++;
                    }
                    nums += M[i+1][j];
                    count++;
                    if(j<col-1){
                        nums += M[i+1][j+1];
                        count++;
                    }
                }
                res_row.push_back(nums / count);
            }
            result.push_back(res_row);
        }
        return result;
    }
};