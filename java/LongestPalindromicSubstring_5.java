class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] flag = new boolean[len][len];
        for(int i=0; i<len; i++){
            flag[i][i] = true;
        }
        int length = 1, pos = 0;
        for(int i=0; i<len; i++){
            for(int j=0; j<i; j++){
                flag[j][i] = (s.charAt(i) == s.charAt(j) && (i - j < 2 || flag[j+1][i-1]));
                if(flag[j][i] && i - j + 1> length){
                    pos = j;
                    len = i-j+1;
                }
            }
        }
        return s.substring(pos, pos+len);
    }
}