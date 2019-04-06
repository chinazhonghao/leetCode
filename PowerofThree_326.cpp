class Solution {
public:
    bool isPowerOfThree(int n) {
    	if(n <= 0){
    		return false;
    	}
        while(n > 1){
        	if((n / 3) * 3 == n){
        		n = n / 3;
        	}
        	else{
        		return false;
        	}
        }
        return true;
    }
};