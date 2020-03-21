class Solution {
public:
    int distributeCandies(vector<int>& candies) {
    	sort(candies.begin(), candies.end());
    	int kinds = 0;
    	int length = candies.size();
    	int nums = length >> 1;
    	int lastKind = -1;
    	for(int i=0; i<length; i++){
    		if(nums > 0){
    			if(candies[i] != lastKind){
    				nums--;
    				kinds++;
    				lastKind = candies[i];
    			}
    		}
    		else{
    			break;
    		}
    	}
    	return kinds;
    }
};