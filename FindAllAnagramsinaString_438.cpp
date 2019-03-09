class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> res;
        int c[26];
        memset(c, 0, sizeof(c));
        int lengthP = p.size();
        count(c, p, lengthP);
        int lengthS = s.size();
        for(int i=0; i<lengthS-lengthP+1; i++){
        	if(isAnagram(c, s.substr(i, lengthP), lengthP)){
        		res.push_back(i);
        	}
        }
        return res;
    }

    bool isAnagram(int *refer, string s, int length){
    	int c[26];
    	memset(c, 0, sizeof(c));
    	count(c, s, length);
    	for(int i=0; i<26; i++){
    		if(c[i] != refer[i]){
    			return false;
    		}
    	}
    	return true;
    }

    void count(int *res, string s, int length){
    	for(int i=0; i<length; i++){
    		res[s.at(i)-'a']++;
    	}
    }
};