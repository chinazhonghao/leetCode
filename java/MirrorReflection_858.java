class Solution {
    public int mirrorReflection(int p, int q) {
        int k = gcd(p, q);
        p /= k;
        q /= k;
        p %= 2;
        q %= 2;
        if(p == 1 && q == 1){
            return 1;
        }
        return p == 1 ? 0 : 2;
    }

    private int gcd(int a, int b){
        int m = a > b ? b : a;
        int n = a > b ? a : b;
        while(m > 0){
            b = n % m;
            n = m;
            m = b;
        }
        return n;
    }
}