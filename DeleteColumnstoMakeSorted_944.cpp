class Solution {
public:
    int minDeletionSize(vector<string>& A) {
        int row = A.size();
        int column = A[0].size();
        int count = 0;
        for(int j=0; j<column; j++){
            for(int i=0; i<row-1; i++){
                if(A[i][j] > A[i+1][j]){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
};