class Solution {
public:
    int addDigits(int num) {
        int result = num;
        while(result > 9){
        	int tmp = result;
        	result = 0;
        	while(tmp > 0){
        		result += tmp % 10;
        		tmp /= 10;
        	}
        }
        return result;
    }
};