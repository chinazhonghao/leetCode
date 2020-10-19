class Solution {
    public int numDecodings(String s) {
        return _recursive(s);
    }

    private int _recursive(String s){
        int length = s.length();
        int digit = s.charAt(0) - '0';
        if(digit == 0){
            return 0;
        }
        int index = 1;
        if(index >= length){
            return 1;
        }
        int last = digit;
        digit = s.charAt(index++) - '0';
        int value = last * 10 + digit;
        int prev1 = 1, prev2 = 1;
        if(value>10 && value<27 && value!=20){
            prev2 = 2;
        }
        int sum = prev2;
        last = digit;
        for(; index<length; index++){
            digit = s.charAt(index) - '0';
            value = last * 10 + digit;
            if(digit ==0 && last==0){
                return 0;
            }
            else if(digit == 0){
                return (prev1 * _recursive(s.substring(index+1)));
            }
            else if(value>10 && value < 27){
                sum = prev1 + prev2;
                prev1 = prev2;
                prev2 = sum;
            }
            else {
                return sum * _recursive(s.substring(index));
            }
            last = digit;
        }
        return sum;
    }
}