#include <vector>

class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int res = 0;
        int maxConsecutive = 0;
        int lenght = nums.size();
        for(int i=0; i<lenght; i++){
            if(nums[i] == 1){
                res++;
            }
            else{
                maxConsecutive = res > maxConsecutive ? res : maxConsecutive;
                res = 0;
            }
        }
        maxConsecutive = res > maxConsecutive ? res : maxConsecutive;
        return maxConsecutive;
    }
};