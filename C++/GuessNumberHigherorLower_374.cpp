// Forward declaration of guess API.
// @param num, your guess
// @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
int guess(int num);

class Solution {
public:
    int guessNumber(int n) {
        long left = 1;
        long right = n;
        while(1){
            long current = (left + right) / 2;
            int result = guess(current);
            if(result==0){
                return current;
            }
            else if(result<0){
                right = current-1;
            }
            else{
                left = current+1;
            }
        }
    }
};