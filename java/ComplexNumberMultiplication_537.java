class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] as = a.split("\\+");
        String[] bs = b.split("\\+");
        int a0 = Integer.valueOf(as[0]);
        int b0 = Integer.valueOf(bs[0]);
        String as1 = as[1].substring(0, as[1].length()-1);
        String bs1 = bs[1].substring(0, bs[1].length()-1);
        int a1 = Integer.valueOf(as1);
        int b1 = Integer.valueOf(bs1);
        int c = a0 * b0 - (a1*b1);
        int d = a0*b1 + b0*a1;
        return c + "+" + d + "i";
    }
}