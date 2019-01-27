class Solution {
public:
    vector<vector<int>> transpose(vector<vector<int>>& A) {
        int row = A.size();
        int col = A[0].size();
        vector<vector<int>> AT;
        for(int i=0; i<col; i++){
            vector<int> rowT;
            for(int j=0; j<row; j++){
                rowT.push_back(A[j][i]);
            }
            AT.push_back(rowT);
        }
        return AT;
    }
};