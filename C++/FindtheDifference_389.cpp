class Solution {
public:
    char findTheDifference(string s, string t) {
    	sort(s.begin(), s.end());
    	sort(t.begin(), t.end());
    	int lengthS = s.size();
    	int diff = 0;
    	for(int i=0; i<lengthS; i++){
    		diff += (s.at(i) - t.at(i));
    	}
    	return t.at(t.size()-1) - diff;
    }
};