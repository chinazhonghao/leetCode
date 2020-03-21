class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int length = cost.size();
        int f1 = 0;
        int f2 = 0;
        for(int i=length-1; i>=0; i--){
            int fn = cost[i] + min(f1, f2);
            f2 = f1;
            f1 = fn;
        }
        return min(f1, f2);
    }
};