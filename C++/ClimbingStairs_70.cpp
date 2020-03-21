class Solution {
public:
    int climbStairs(int n) {
        int f1 = 1;
        int f2 = 2;
        if(n == 2){
            return f2;
        }
        else if(n == 1){
            return f1;
        }
        else if(n < 1){
            return 0;
        }
        int result = 0;
        for(int i=3; i<=n; i++){
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }
        return result;
    }
};