class Solution {
public:
    int maxCount(int m, int n, vector<vector<int>>& ops) {
        int rows = ops.size();
        if(rows < 1){
            return m*n;
        }
        int minA = ops[0][0];
        int minB = ops[0][1];
        for(int i=1; i<rows; i++){
            if(ops[i][0] < minA){
                minA = ops[i][0];
            }
            if(ops[i][1] < minB){
                minB = ops[i][1];
            }
        }
        return minA * minB;
    }
};