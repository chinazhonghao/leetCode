class Solution {
public:
    bool buddyStrings(string A, string B) {
        int lengthA = A.size();
        int lengthB = B.size();
        if(lengthA != lengthB){
            return false;
        }
        int index[3] = {-1, -1, -1};
        int currentIndex= 0;
        for(int i=0; i<lengthA; i++){
            if(A[i] != B[i]){
                index[currentIndex] = i;
                currentIndex++;
                if(currentIndex > 2){
                    return false;
                }
            }
        }
        if(currentIndex > 0){
            if(currentIndex == 1){
                return false;
            }
            else{
                int first = index[0];
                int second = index[1];
                if(!(A[first] == B[second] && A[second]==B[first])){
                    return false;
                }
                return true;
            }
        }
        else{
            int record[26];
            memset(record, 0, sizeof(int)*26);
            for(int i=0; i<lengthA; i++){
                record[A[i]-'a']++;
                if(record[A[i]-'a'] > 1){
                    return true;
                }
            }
            return false;
        }
    }
};