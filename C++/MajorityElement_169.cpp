class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int majorityElement = -1;
        map<int, int> countsRec;
        int length = nums.size();
        int halfLength =  length >> 1;
        int maxCount = 0;
        for(int i=0; i<length; i++){
            int currentKey = nums[i];
            int currentCount = 0;
            try{
                currentCount = countsRec.at(currentKey);
            }
            catch(...){
            }
            currentCount++;
            countsRec[currentKey] = currentCount;
            if(currentCount > maxCount){
                maxCount = currentCount;
                majorityElement = currentKey;
            }
        }
        return majorityElement;
    }
};