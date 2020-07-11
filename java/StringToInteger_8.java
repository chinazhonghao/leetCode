class Solution {
    public int myAtoi(String str) {
        long result = 0;
        int i=0;
        for(; i<str.length(); i++){
            if(str.charAt(i) != ' '){
                break;
            }
        }
        if(i >= str.length()){
            return 0;
        }
        int sign = 1;
        if(str.charAt(i)=='+' ){
            i++;
        }
        else if(str.charAt(i)=='-'){
            i++;
            sign = -1;
        }
        int j = i;
        for(; j<str.length(); j++){
            if(str.charAt(j) > '9' || str.charAt(j) < '0'){
                break;
            }
        }
        for(; i<j; i++){
            result = result * 10 + str.charAt(i)-'0';
            if(result > Integer.MAX_VALUE){
                break;
            }
        }
        result = result * sign;
        if(result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        else if(result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)result;
    }
}