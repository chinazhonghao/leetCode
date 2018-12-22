class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>>& nums, int r, int c) {
        int row = nums.size();
        int col = nums[0].size();
        if(row*col != r*c){
            return nums;
        }

        vector<int> nums_union;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                nums_union.push_back(nums[i][j]);
            }
        }

        vector<vector<int>> res;
        for(int i=0; i<r; i++){
            vector<int> res_row;
            for(int j=0; j<c; j++){
                res_row.push_back(nums_union[i*c + j]);
            }
            res.push_back(res_row);
        }
        return res;
    }
};