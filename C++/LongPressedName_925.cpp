class Solution {
public:
    bool isLongPressedName(string name, string typed) {
        if(name.compare(typed) == 0){
        	return true;
        }

        vector<char> a,b;
        vector<int>ca, cb;
        countChar(name, a, ca);
        countChar(typed, b, cb);
        if(a.size()!=b.size()){
        	return false;
        }
        for(int i=0; i<a.size(); i++){
        	if(a[i]!=b[i] || ca[i]>cb[i]){
        		return false;
        	}
        }
        return true;
    }
    inline void countChar(string& s, vector<char>& charR, vector<int>& c){
    	int length = s.size();
    	for(int i=0; i<length;){
    		int count = 1;
    		char current = s[i++];
    		while(i<length && current==s[i]){
    			count++;
    			i++;
    		}
    		charR.push_back(current);
    		c.push_back(count);
    	}
    }
};