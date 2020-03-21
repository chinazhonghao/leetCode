class Solution {
public:
    bool judgeSquareSum(int c) {
        int left = sqrt(c / 2);
        int right = sqrt(c - left*left);
        while(left >= 0){
            if(left*left + right*right == c){
                return true;
            }
            left -= 1;
            right = sqrt(c - left * left);
        }
        return false;
    }
};