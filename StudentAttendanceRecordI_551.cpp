class Solution {
public:
    bool checkRecord(string s) {
        int length = s.size();
        int countA = 0;
        int countL = 0;
        for(int i=0; i<length; i++){
            if(s[i] == 'A'){
                if(++countA >= 2){
                    return false;
                }
                countL = 0;
            }
            else if(s[i]=='L'){
                if(++countL >= 3){
                    return false;
                }
            }
            else{
                countL = 0;
            }
        }
        return true;
    }
};