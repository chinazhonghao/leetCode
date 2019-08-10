class Solution {
public:
    bool isSubsequence(string s, string t) {
        int lengthS = s.size();
        int lengthT = t.size();
        if(lengthS > lengthT){
            return false;
        }
        int start = 0;
        for(int i=0; i<lengthS; i++){
            char current = s[i];
            bool isFound = false;
            for(int j=start; j<lengthT; j++){
                if(current == t[j]){
                    start = j+1;
                    isFound = true;
                    break;
                }
            }
            if(!isFound){
                return false;
            }
        }
        return true;
    }
};