class Solution {
public:
    int trailingZeroes(int n) {
        int result = 0;
        int maxLimit = 1;
        while(pow(5, maxLimit) < n){
        	maxLimit++;
        }
        for(int i=1; i<maxLimit; i++){
        	result += n / pow(5, i);
        }
        return result;
    }
};