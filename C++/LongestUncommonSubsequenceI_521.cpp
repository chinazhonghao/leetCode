class Solution {
public:
    int findLUSlength(string a, string b) {
        int lengthA = a.size();
        int lengthB = b.size();
        if(lengthA > lengthB){
            return lengthA;
        }
        else if(lengthA < lengthB){
            return lengthB;
        }
        else if(a.compare(b)==0){
            return -1;
        }
        else {
            return lengthA;
        }
    }
};