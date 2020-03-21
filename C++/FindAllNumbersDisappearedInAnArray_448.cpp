class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int length = nums.size();
        vector<bool> flag;
        for(int i=0; i<length; i++){
            flag.push_back(false);
        }
        for(int i=0; i<length; i++){
            int currentValue = nums[i];
            flag[currentValue-1] = true;
        }
        vector<int> res;
        for(int i=0; i<length; i++){
            if(!flag[i]){
                res.push_back(i+1);
            }
        }
        return res;
    }
};