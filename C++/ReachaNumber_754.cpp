class Solution {
public:
    int reachNumber(int target) {
        target = fabs(target);
        int k = 0;
        while (target > 0)
            target -= ++k;
        return target % 2 == 0 ? k : k + 1 + k%2;
    }
};