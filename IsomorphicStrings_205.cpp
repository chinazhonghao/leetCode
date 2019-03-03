class Solution {
public:
    bool isIsomorphic(string s, string t) {
        int sLength = s.size();
        int tLength = t.size();
        if(sLength != tLength){
        	return false;
        }
        map<char, char> stRecord;
        map<char, char> tsRecord;
        for(int i=0; i<sLength; i++){
        	char sChar = s[i];
        	char tChar = t[i];
        	map<char, char>::iterator stIt = stRecord.find(sChar);
        	if(stIt != stRecord.end()){
        		if(stIt->second != tChar){
        			return false;
        		}
        	}
        	else{
        		stRecord.insert(pair<char, char>(sChar, tChar));
        	}

        	map<char, char>::iterator tsIt = tsRecord.find(tChar);
        	if(tsIt != tsRecord.end()){
        		if(tsIt->second != sChar){
        			return false;
        		}
        	}
        	else{
    			tsRecord.insert(pair<char, char>(tChar, sChar));
    		}

        }
        return true;
    }
};