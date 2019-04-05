class Solution {
public:
    bool isPowerOfTwo(int n) {
    	if(n < 1){
    		return false;
    	}
        while(n > 1){
        	if((n >> 1) * 2 == n){
        		n = n >> 1;
        	}
        	else {
        		return false;
        	}
        }
        return true;
    }
};