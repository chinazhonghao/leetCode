class Solution {
public:
    bool hasAlternatingBits(int n) {
        int expected = 1 - n & 1;
        n = n>>1;
        while(n > 0){
            int current = n & 1;
            if(expected == current){
                expected = 1 - expected;
            }
            else{
                return false;
            }
            n = n >> 1;
        }
        return true;
    }
};