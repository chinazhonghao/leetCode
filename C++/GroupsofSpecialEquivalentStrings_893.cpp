class Solution {
public:
    int numSpecialEquivGroups(vector<string>& A) {
        int length = A.size();
        int result = 0;
        vector<string> oddStr, evenStr;
        for(int i=0; i<length; i++){
            string & current = A[i];
            int len = current.size();
            string even = "";
            for(int j=0; j<len; j+=2){
                even.push_back(current[j]);
            }
            string odd = "";
            for(int j=1; j<len; j+=2){
                odd.push_back(current[j]);
            }
            evenStr.push_back(even);
            oddStr.push_back(odd);
        }
        bool * flag = new bool[length];
        memset(flag, 0, sizeof(bool)*length);
        for(int i=0; i<length; i++){
            if(flag[i]){
                continue;
            }
            flag[i]=true;
            result++;
            string & currentEven = evenStr[i];
            string & currentOdd = oddStr[i];
            for(int j=0; j<length; j++){
                if(j==i){
                    continue;
                }
                if(isEqual(currentEven, evenStr[j]) && isEqual(currentOdd, oddStr[j])){
                    flag[j] = true;
                }
            }
        }
        delete [] flag;
        return result;
    }

    bool isEqual(string & a, string & b){
        int lengthA = a.size();
        int lengthB = b.size();
        if(lengthA != lengthB){
            return false;
        }
        int flag[26];
        memset(flag, 0, sizeof(int)*26);
        for(int i=0; i<lengthA; i++){
            flag[a[i]-'a']++;
        }
        for(int i=0; i<lengthB; i++){
            flag[b[i]-'a']--;
        }
        for(int i=0; i<26; i++){
            if(flag[i] != 0){
                return false;
            }
        }
        return true;
    }
};