class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        int length = s.size();
        int halfLength = length >> 1;
        for(int i=1; i<=halfLength; i++){
            if(length % i == 0 && isRepeated(s, i)){
                return true;
            }
        }
        return false;
    }

    inline bool isRepeated(string& s, int len){
        int length = s.size();
        string base = s.substr(0, len);
        for(int i=len; i<length; i+=len){
            if(base.compare(s.substr(i, len))!=0){
                return false;
            }
        }
        return true;
    }
};