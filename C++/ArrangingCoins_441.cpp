class Solution {
public:
    int arrangeCoins(int n) {
        long num = (long)n * 8 + 1;
        return (sqrt(num) - 1) / 2;
    }
};