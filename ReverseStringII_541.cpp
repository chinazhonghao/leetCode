class Solution {
public:
    string reverseStr(string s, int k) {
        int length = s.size();
        vector<char> rev;
        rev.reserve(length);
        for(int i=0; i<length; i+=2*k){
            string str = s.substr(i, 2*k);
            reverse(rev, str, k);
        }
        for(int i=rev.size(); i<length; i++){
            rev.push_back(s[i]);
        }
        char *tmp = &rev[0];
        return string(tmp, length);
    }

    inline void reverse(vector<char>& res, string &s, int k){
        int length = s.size();
        if(length < k){
            for(int i=length-1; i>=0; i--){
                res.push_back(s[i]);
            }
        }
        else{
            for(int i=k-1; i>=0 && i<length; i--){
                res.push_back(s[i]);
            }
            for(int i=k; i<2*k && i<length; i++){
                res.push_back(s[i]);
            }
        }
    }
};