class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int len = nums.size();
        int i = 0;
        for(i=0; i<len; i++){
            int current = nums.at(i);
            if(target <= current){
                break;
            }
        }
        return i;
    }
};