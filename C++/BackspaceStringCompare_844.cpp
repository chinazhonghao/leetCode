class Solution {
public:
    bool backspaceCompare(string S, string T) {
        vector<char> sResult;
        vector<char> tResult;
        getResult(S, sResult);
        getResult(T, tResult);
        string s((char *)&sResult[0], sResult.size());
        string t((char *)&tResult[0], tResult.size());
        return s.compare(t) == 0;
    }
    inline void getResult(string& s, vector<char>& result){
    	int length = s.size();
    	for(int i=0; i<length; i++){
    		if(s[i]!='#'){
    			result.push_back(s[i]);
    		}
    		else if(result.size() > 0){
    			result.pop_back();
    		}
    	}
    }
};