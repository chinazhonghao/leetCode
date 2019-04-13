class Solution {
public:
    int binaryGap(int N) {
        int maxDist = 0;
        int dist = 0;
        int mask = 1;
        bool start = false;
        int startPos = 0;
        int currentPos = 0;
        while(N > 0){
            int res = N & mask;
            if(res && !start){
                start = true;
                startPos = currentPos;
            }
            else if(res && start){
                dist = currentPos - startPos;
                maxDist = dist > maxDist ? dist : maxDist;
                startPos = currentPos;
            }
            currentPos++;
            N = N >> 1;
        }
        return maxDist > dist ? maxDist : dist;
    }
};