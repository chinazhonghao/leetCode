class Solution {
public:
    string removeDuplicates(string S) {
        vector<char> result;
        stack<char> rem;
        int length = S.size();
        rem.push(S[0]);
        for(int i=1; i<length; i++){
            if(!rem.empty()){
                if(rem.top() == S[i]){
                    rem.pop();
                    continue;
                }
            }
            rem.push(S[i]);
        }
        if(rem.empty()){
            return "";
        }
        stack<char> revert;
        while(!rem.empty()){
            revert.push(rem.top());
            rem.pop();
        }
        while(!revert.empty()){
            result.push_back(revert.top());
            revert.pop();
        }
        return string((char *)&result[0], result.size());
    }
};