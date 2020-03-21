class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        int start = 0;
        bool isStart = false;
        int end = nums.size();
        bool isEnd = false;
        while(start < end && !isStart){
            int startNum = nums[start];
            for(int i=start+1; i<end; i++){
                if(startNum > nums[i]){
                    isStart = true;
                    break;
                }
            }
            if(!isStart){
                start++;
            }
        }
        while(start < end && !isEnd){
            int endNum = nums[end-1];
            for(int i=end-1; i>start; i--){
                if(endNum < nums[i-1]){
                    isEnd = true;
                    break;
                }
            }
            if(!isEnd){
                end--;
            }
        }
        int distance = end - start;
        return distance > 1 ? distance : 0;
    }
};