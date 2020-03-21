class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        vector<int>::iterator end = nums.end();
        for(; k>0; k--){
            int currentKey = *end;
            nums.erase(end);
            nums.insert(nums.begin(), currentKey);
            end = nums.end();
        }
    }
};