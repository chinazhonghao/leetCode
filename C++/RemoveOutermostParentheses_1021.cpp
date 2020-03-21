class Solution {
public:
    string removeOuterParentheses(string S) {
        int length = S.size();
        if(length < 1){
            return "";
        }
        vector<char> result;
        stack<char> rem;
        rem.push(S[0]);
        int start = 0;
        for(int i=1; i<length; i++){
            if(rem.empty()){
                rem.push(S[i]);
                start = i;
            }
            else{
                if(rem.top()=='(' && S[i]==')'){
                    rem.pop();
                    if(rem.empty()){
                        if(i-start > 1){
                            for(int j=start+1; j<i; j++){
                                result.push_back(S[j]);
                            }
                        }
                    }
                }
                else{
                    rem.push(S[i]);
                }
            }
        }
        if(result.empty()){
            return "";
        }
        return string((char *)&result[0], result.size());
    }
};