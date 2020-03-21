class Solution {
public:
    int findNthDigit(int n) {
        int result = 0;
        long lastNum = 0;
        long num = 9;
        long start = 1;
        int bitsNum = 1;
        while(num < n){
        	bitsNum++;
        	start *= 10;
        	lastNum = num;
        	num = lastNum + 9 * pow(10, bitsNum-1) * bitsNum;
        }
        int diff = n - lastNum;
        int numberCount = diff / bitsNum;
        int diffCount = diff - numberCount * bitsNum;
        long numberStart = start + numberCount - 1;
        long nextStart = numberStart + 1;
        if(diffCount > 0){
        	diffCount = bitsNum - diffCount;
        	while(diffCount){
        		nextStart = nextStart / 10;
                diffCount--;
        	}
        	result = nextStart % 10;
        }
        else {
        	result = numberStart % 10;
        }
        return result;
    }
};