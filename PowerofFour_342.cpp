class Solution {
public:
    bool isPowerOfFour(int num) {
        long tmp = (long)num;
        long input = tmp>0?tmp:-tmp;
        if((input & (input-1)) != 0){
            return false;
        }

        int count = 0;
        while(input > 1){
            input = input >> 1;
            count++;
        }
        return (count%2) == 0;
    }
};