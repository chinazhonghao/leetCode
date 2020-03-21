class Solution {
public:
    int mySqrt(int x) {
        if(!x){
            return 0;
        }
        if(x < 3){
            return 1;
        }
        int minX = 1;
        int maxX = x;
        int halfX = ((long)minX + (long)maxX) >> 1;
        while(true){
            long tmp = (long)halfX * (long)halfX;
            if(tmp > x){
                maxX = halfX;
            }
            else if(tmp< x){
                minX = halfX;
            }
            else {
                return halfX;
            }
            halfX = (minX + maxX) >> 1;
            if(halfX == minX){
                return halfX;
            }
        }
    }
};