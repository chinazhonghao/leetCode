// Forward declaration of isBadVersion API.
bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        long left = 1;
        long right = n;
        while(1){
            if(left==right || left+1==right){
                return isBadVersion(left)?left:right;
            }
            long current = (left + right) / 2;
            if(isBadVersion(current)){
                right = current;
            }
            else{
                left = current;
            }
        }
    }
};