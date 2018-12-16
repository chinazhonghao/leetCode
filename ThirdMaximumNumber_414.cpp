class Solution {
public:
    int thirdMax(vector<int>& nums) {
        int length = nums.size();
        long maxNumArray[3] = {LONG_MIN, LONG_MIN, LONG_MIN};
        for(int i=0; i<length; i++){
            int currentValue = nums[i];
            for(int j=0; j<3; j++){
                if(currentValue > maxNumArray[j]){
                    for(int k=2; k>j; k--){
                        maxNumArray[k] = maxNumArray[k-1];
                    }
                    maxNumArray[j] = currentValue;
                    break;
                }
                else if(currentValue == maxNumArray[j]){
                    break;
                }
            }
        }
        return maxNumArray[2] > LONG_MIN ? maxNumArray[2] : maxNumArray[0];
    }
};