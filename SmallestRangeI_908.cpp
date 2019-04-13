class Solution {
public:
    int smallestRangeI(vector<int>& A, int K) {
        auto result = minmax_element(A.begin(), A.end());
        int maxNum = *result.second;
        int minNum = *result.first;
        int diff = maxNum - minNum - 2*K;
        return diff >= 0 ? diff : 0;
    }
};