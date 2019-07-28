class Solution {
public:
    vector<string> letterCasePermutation(string S) {
        vector<string> result;
        convert(S, 0, result);
        return result;
    }

    void convert(string& s, int start, vector<string>& result){
        if(start == s.size()){
            result.push_back(s);
            return;
        }
        if(s[start]>='a' && s[start]<='z'){
            convert(s, start+1, result);
            s[start] = s[start] - 'a' + 'A';
            convert(s, start+1, result);
        }
        else if(s[start]>='A' && s[start]<='Z'){
            s[start] = s[start] - 'A' + 'a';
            convert(s, start+1, result);
            s[start] = s[start] - 'a' + 'A';
            convert(s, start+1, result);
        }
        else{
            convert(s, start+1, result);
        }
    }
};