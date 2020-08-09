import java.math.BigInteger;

class Solution {
    public int superPow(int a, int[] b) {
        BigInteger A = BigInteger.valueOf(a);
        StringBuffer sb = new StringBuffer();
        for(int i : b){
            sb.append(i);
        }
        BigInteger B = new BigInteger(sb.toString());
        return A.modPow(B, BigInteger.valueOf(1337)).intValue();
    }
}