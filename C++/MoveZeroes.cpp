class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int length = nums.size();
        int zeroIndex = -1;
        for(int i=0; i<length; i++){
            if(nums[i] == 0){
                zeroIndex = i;
                break;
            }
        }
        if(zeroIndex == -1){
            return;
        }
        for(int i=0; i<length; i++){
            int tmp = nums[i];
            if(tmp == 0){
                continue;
            }
            if(i < zeroIndex){
                continue;
            }
            nums.erase(nums.begin() + i);
            nums.insert(nums.begin() + zeroIndex, tmp);
            zeroIndex++;
        }
    }
};