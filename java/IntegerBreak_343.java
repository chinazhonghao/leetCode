class Solution {
    public int integerBreak(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        if(n == 4){
            return 4;
        }
        int count = 1;
        while (n >= 5){
            n = n - 3;
            count *= 3;
        }
        count *= n;
        return count;
    }
}