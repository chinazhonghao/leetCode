class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        int length = nums.size();
        if(length < 1){
        	return 0;
        }
        int increasingLenght = 1;
        int maxincreasingLength = 1;
        int beginNum = nums[0];
        for(int i=1; i<length; i++){
        	if(beginNum	< nums[i]){
        		increasingLenght++;
        	}
        	else{
        		if(increasingLenght > maxincreasingLength){
        			maxincreasingLength = increasingLenght;
        		}
        		increasingLenght = 1;
        	}
        	beginNum = nums[i];
        }
        maxincreasingLength = maxincreasingLength > increasingLenght ? maxincreasingLength : increasingLenght;
        return maxincreasingLength;
    }
};