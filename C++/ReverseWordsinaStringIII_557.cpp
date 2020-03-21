class Solution {
public:
    string reverseWords(string s) {
        char flag = ' ';
        int length = s.size();
        int startIndex = -1;
        int endIndex = -1;
        for(int i=0; i<length; i++){
            if(s[i] == flag){
                if(startIndex >= 0){
                    endIndex = i;
                    reverse(s.begin()+startIndex, s.begin()+endIndex);
                    startIndex = -1;
                }
            }
            else {
                if(startIndex < 0){
                    startIndex = i;
                }
            }
        }
        if(startIndex >=0){
            reverse(s.begin()+startIndex, s.end());
        }
        return s;
    }
};