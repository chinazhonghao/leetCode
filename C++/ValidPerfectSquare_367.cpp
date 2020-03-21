class Solution {
public:
    bool isPerfectSquare(int num) {
    	if(num == 1){
    		return true;
    	}
    	long minLimit = 0;
    	long maxLimit = num;
    	while(true){
    		long mid = (minLimit + maxLimit) >> 1;
    		if(mid == minLimit){
    			return false;
    		}
    		long midmid = mid * mid;
    		if(midmid > num){
    			maxLimit = mid;
    		}
    		else if(midmid < num){
    			minLimit = mid;
    		}
    		else {
    			return true;
    		}
    	}
    	return false;
    }
};