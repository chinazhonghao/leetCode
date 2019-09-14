class Solution {
public:
    int hammingDistance(int x, int y) {
        int distance = 0;
        while(x != y){
            distance += (x&1)^(y&1);
            x = x >> 1;
            y = y >> 1;
        }
        return distance;
    }
};