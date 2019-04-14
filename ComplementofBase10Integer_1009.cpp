class Solution {
public:
    int bitwiseComplement(int N) {
        if(N == 0){
            return 1;
        }
        int copyN = N;
        int base = 1;
        int count = 0;
        while(N > 0){
            N = N >> 1;
            count++;
        }
        return pow(2, count) - 1 - copyN;
    }
};