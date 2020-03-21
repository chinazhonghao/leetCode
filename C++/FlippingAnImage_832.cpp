class Solution {
public:
    vector<vector<int>> flipAndInvertImage(vector<vector<int>>& A) {
        int row = A.size();
        int col = A[0].size();
        for(int i=0; i<row; i++){
            vector<int>& currentRow = A[i];
            for(int i=0; i<col/2; i++){
                int tmp = currentRow[i];
                currentRow[i] = currentRow[col - i - 1];
                currentRow[col - i - 1] = tmp;
            }

            for(int i=0; i<col; i++){
                currentRow[i] ^= 1;
            }
        }
        return A;
    }
};