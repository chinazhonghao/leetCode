class Solution {
public:
    int repeatedStringMatch(string A, string B) {
        string C = A;
        int count = 1;
        while(C.size() < B.size()){
            C += A;
            count++;
        }
        if(C.find(B) != string::npos){
            return count;
        }
        C += A;
        if(C.find(B) != string::npos){
            return count+1;
        }
        return -1;
    }
};