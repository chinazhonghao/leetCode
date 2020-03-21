class Solution {
public:
    int titleToNumber(string s) {
        int result = 0;
        int length = s.size();
        int base = 26;
        for(int i=0; i<length; i++){
        	result = base * result + (s[i] - 'A' + 1);
        }
        return result;
    }
};